package com.insigma.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Notify2H5Util {
	
	
	/**
	 * 通知h5系统
	 * @param h5url
	 * @return
	 */
	public static String notifyToH5(String h5url) {
		String output = null;
		BufferedReader responseBuffer = null;
		HttpURLConnection httpConnection = null;
		try {
			URL tarUrl = new URL(h5url);
			httpConnection = (HttpURLConnection) tarUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("GET");
			// 设置请求连接超时时间
			httpConnection.setConnectTimeout(5000);
			// 设置访问时的超时时间
			httpConnection.setReadTimeout(5000);
			// 开启连接
			httpConnection.connect();
			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}
			responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
			System.out.println("Output from Server:\n");
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
				return output;
			}
			responseBuffer.close();
			httpConnection.disconnect();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
