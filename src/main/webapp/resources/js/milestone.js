//富文本
$(function() {
	function initToolbarBootstrapBindings() {
		var fonts = [ 'Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
				'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact',
				'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
				'Times New Roman', 'Verdana' ], fontTarget = $('[title=Font]')
				.siblings('.dropdown-menu');
		$.each(fonts, function(idx, fontName) {
			fontTarget.append($('<li><a data-edit="fontName ' + fontName
					+ '" style="font-family:\'' + fontName + '\'">' + fontName
					+ '</a></li>'));
		});
		$('a[title]').tooltip({
			container : 'body'
		});
		$('.dropdown-menu input').click(function() {
			return false;
		}).change(
				function() {
					$(this).parent('.dropdown-menu').siblings(
							'.dropdown-toggle').dropdown('toggle');
				}).keydown('esc', function() {
			this.value = '';
			$(this).change();
		});

		$('[data-role=magic-overlay]').each(
				function() {
					var overlay = $(this), target = $(overlay.data('target'));
					overlay.css('opacity', 0).css('position', 'absolute')
							.offset(target.offset()).width(target.outerWidth())
							.height(target.outerHeight());
				});
		$('#voiceBtn').hide();

	}
	;
	initToolbarBootstrapBindings();
	$('#editor').wysiwyg();
	window.prettyPrint && prettyPrint();
});
// 转json格式
(function($) {
	$.fn.serializeFormJSON = function() {

		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});

		return o;
	};
})(jQuery);

(function($) {
	$.fn.formData = function() {
		var data = {};
		data[this.attr('id')] = JSON.stringify(this.serializeFormJSON());
		return data;
	};
})(jQuery);

// 更换验证码
function changeCaptcha() {
	$('#captcha-img').attr('src',
			'/milestone/kaptcha?' + Math.floor(Math.random() * 100));
}

// 校验注册参数 用户名 邮箱 昵称 验证码
function checkParam(input) {
	if ($(input).val() == null || $(input).val() == "") {
		var str = "";

		switch (input.name) {
		case ("userName"):
			str = "请输入用户名！";
			break;
		case ("email"):
			str = "请输入邮箱！";
			break;
		case ("nickName"):
			str = "请输入昵称！";
			break;
		case ("captcha"):
			str = "请输入验证码！";
			break;
		}

		$("#" + input.name + "Help").text(str);
		$("#" + input.name + "Id").parent().addClass("has-error");
	} else {
		// 清空提示栏状态
		$("#" + input.name + "Help").text("");
		$("#" + input.name + "Id").parent().removeClass("has-error");

		var sendData = {};
		sendData["paramType"] = input.name;
		sendData[input.name] = $(input).val();
		$.post("/milestone/user/check", sendData, function(data) {
			if (!data.result) {
				$("#" + input.name + "Help").text(data.message);
				$("#" + input.name + "Id").parent().addClass("has-error");
			}
		});
	}
}

// 密码校验
function checkPassword(input) {
	if ($(input).val() == null || $(input).val() == "") {
		var str = "";

		switch (input.name) {
		case ("password"):
			str = "请输入密码！";
			break;
		case ("confirmPassword"):
			str = "请输入确认密码！";
			break;
		}

		$("#" + input.name + "Help").text(str);
		$("#" + input.name + "Id").parent().addClass("has-error");
	} else if (input.name == "password" && $(input).val().length < 6) {
		$("#" + input.name + "Help").text("密码需要6-16个字符！");
		$("#" + input.name + "Id").parent().addClass("has-error");
	} else if (input.name == "confirmPassword"
			&& $("#confirmPasswordId").val() != $("#passwordId").val()) {

		$("#" + input.name + "Help").text("两次密码输入不一致！");
		$("#" + input.name + "Id").parent().addClass("has-error");
	} else {
		// 清空提示栏状态
		$("#" + input.name + "Help").text("");
		$("#" + input.name + "Id").parent().removeClass("has-error");
	}
}

// 提交注册信息
function sendRegister() {
	// 存在error信息 不提交请求
	$(".text-danger").each(function() {
		var isReturn = false;
		if ($(this).hasClass("has-error")) {
			isReturn = true;
			return false;
		}

		if (isReturn) {
			return;
		}
	});

	// 注册请求
	$.post("/milestone/user/registerUser", $("#registerForm").formData(),
			function(data) {
				if (data.result) {
					$("#result").empty();
					$("#result").text("注册成功!");

				} else {
					$("#result").empty();
					$("#result").text("注册失败，请联系管理员！");
				}
				$("#themodal").modal("toggle");
			});
}

// 注册完成跳转登录页面
function clickConfirm() {
	if ($("#result").text() == "注册成功!") {
		window.location.href = 'login.html';
	}
}

// 提交信息
function sendLogin() {
	// 存在error信息 不提交请求
	$(".text-danger").each(function() {
		var isReturn = false;
		if ($(this).hasClass("has-error")) {
			isReturn = true;
			return false;
		}

		if (isReturn) {
			return;
		}
	});

	// 注册请求
	$.post("/milestone/user/toLogin", {
		userName : $("#userNameId").val(),
		password : $("#passwordId").val(),
		remenber : $("#rememberId").val()
	}, function(data) {
		if (data.result) {
			window.location.href = "index";
		} else {
			$("#result").empty();
			$("#result").text("用户名或密码错误！");
		}
	});
}

function newPage() {
	var sendData= {title:$("#title").val(),content:$("#editor").html(),district:$("#district").val()};
	$.post("/milestone/page/new", sendData, function(data) {

	})
}
