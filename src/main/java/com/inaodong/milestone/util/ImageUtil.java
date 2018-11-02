package com.inaodong.milestone.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class ImageUtil {

	public static String base64ToImage(String dataString) {
		BASE64Decoder decoder = new BASE64Decoder();
		String imageString = getBase64String(dataString);
		String imageName = System.currentTimeMillis() + "." + getImageType(dataString);
		OutputStream outputStream = null;
		try {
			byte[] byteArr = decoder.decodeBuffer(imageString);
			for (int i = 0; i < byteArr.length; i++) {
				if (byteArr[i] < 0) {
					byteArr[i] += 256;
				}
			}
			outputStream = new FileOutputStream(
					getPath(dataString) + imageName);
			outputStream.write(byteArr);
			outputStream.flush();
			
		} catch (IOException e) {
			
			return "";
		} finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		String sqlString = "";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			sqlString = dataString.replace(getBase64String(dataString), "/milestone/resources/images/"+ imageName);
		} else {
			sqlString = dataString.replace(getBase64String(dataString), "/home/images/" +imageName );
		}
		return sqlString;
	}

	public static String getPath(String dataString) {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "G:/code/myproject/milestone/src/main/webapp/resources/images/";
		} else {
			basePath = "/home/images/";
		}
		basePath = basePath.replace("/", System.getProperty("file.separator"));
		// long currentTime = System.currentTimeMillis();
		// basePath = basePath + currentTime + getImageType(dataString);
		return basePath;
	}

	public static String getBase64String(String dataString) {
		String base64Code = dataString.substring(dataString.indexOf(",") + 1,
				dataString.indexOf("\"", dataString.indexOf("\"") + 1));
		// String imageType =
		// imageString.substring(imageString.indexOf("/")+1,imageString.indexOf(";"));
		return base64Code;
	}

	public static String getImageType(String dataString) {
		return dataString.substring(dataString.indexOf("/") + 1, dataString.indexOf(";"));
	}
}
