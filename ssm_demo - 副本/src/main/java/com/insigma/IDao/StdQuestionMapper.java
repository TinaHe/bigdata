package com.insigma.IDao;


import com.insigma.domain.StdQuestion;

public interface StdQuestionMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByCode(String code);

    int insert(StdQuestion record);


    int insertSelective(StdQuestion record);

    StdQuestion selectByPrimaryKey(Integer id);
    /**
     * 根据code获取问题 add by zhx
     * @param code
     * @return
     */
    StdQuestion selectByCode(String stdQuestionCode);
  
}