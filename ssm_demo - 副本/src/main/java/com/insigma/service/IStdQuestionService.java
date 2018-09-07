package com.insigma.service;

import java.util.Map;

import com.insigma.domain.StdQuestion;


  
public interface IStdQuestionService {
	/**
	 * 返回结果
	 * @return
	 */
	public Map<String,Object> getRusults();

	public StdQuestion getStdQuestion(String code);
	
}