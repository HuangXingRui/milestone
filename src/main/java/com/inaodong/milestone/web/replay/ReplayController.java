package com.inaodong.milestone.web.replay;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inaodong.milestone.entity.Replay;
import com.inaodong.milestone.service.ReplayService;
import com.inaodong.milestone.util.HttpServletRequestUtil;

@Controller
public class ReplayController {

	@Autowired
	private ReplayService replayService;
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="replay")
	public Map<String, Object> replay(HttpServletRequest request){
		HttpServletRequestUtil.getString(request, "");
		Replay replay = new Replay();
		
		replayService.insertRepaly(replay);
		return null;
	}
}
