package com.insigma.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.insigma.domain.StdQuestion;
import com.insigma.service.IStdQuestionService;
import com.insigma.util.ResponseUtil;

@Controller
@RequestMapping("/stdQuestion")
@PropertySource("classpath:configinfo.properties")
public class StdQuestionController {

	private static Logger logger = Logger
			.getLogger(StdQuestionController.class);

	@Resource
	private IStdQuestionService stdQuestionService;

	@RequestMapping("/getQuestion")
	public String getQuestion(HttpServletRequest request,HttpServletResponse res)
		throws Exception {
	String code = "9d5a3692-a9ec-4e78-9cf1-2da9aac90cb4";
	StdQuestion list = this.stdQuestionService.getStdQuestion(code);
	Object json = JSONObject.toJSON(list);
	JSONObject result = new JSONObject();
	result.put("rows", json);
	ResponseUtil.write(res, result);
	return null;
	}

}