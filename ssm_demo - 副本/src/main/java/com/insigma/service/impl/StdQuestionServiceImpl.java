package com.insigma.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.insigma.IDao.StdQuestionMapper;
import com.insigma.bean.StdQuestionBean;
import com.insigma.domain.StdQuestion;
import com.insigma.service.IStdQuestionService;

@Service("stdQuestionService")
public class StdQuestionServiceImpl implements IStdQuestionService {
	
	@Resource
	private StdQuestionMapper stdQuestionDao;
	
	// 返回结果属性
	private Map<String, Object> resultMap;

	/**
	 * 返回结果map
	 */
	@Override
	public Map<String, Object> getRusults() {

		return resultMap;
	}
	
	@Override
	public StdQuestion getStdQuestion(String code){
		return this.stdQuestionDao.selectByCode(code);
	}
	
	
}
