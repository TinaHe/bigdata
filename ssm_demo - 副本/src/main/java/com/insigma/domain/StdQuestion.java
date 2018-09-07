package com.insigma.domain;

import java.util.Date;

public class StdQuestion {
    private Integer id;

    private String stdQuestion;

    private String stdQuestionCode;

    private String outAnswer;

    private String inAnswer;

    private String categoryCode;

    private Date createTime;

    private Date updateTime;

    private String createUserCode;

    private String updateUserCode;

    private Byte status;

    private Date validate;

    private String knowledgePointCode;

    private String auditUserCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdQuestion() {
        return stdQuestion;
    }

    public void setStdQuestion(String stdQuestion) {
        this.stdQuestion = stdQuestion == null ? null : stdQuestion.trim();
    }

    public String getStdQuestionCode() {
        return stdQuestionCode;
    }

    public void setStdQuestionCode(String stdQuestionCode) {
        this.stdQuestionCode = stdQuestionCode == null ? null : stdQuestionCode.trim();
    }

    public String getOutAnswer() {
        return outAnswer;
    }

    public void setOutAnswer(String outAnswer) {
        this.outAnswer = outAnswer == null ? null : outAnswer.trim();
    }

    public String getInAnswer() {
        return inAnswer;
    }

    public void setInAnswer(String inAnswer) {
        this.inAnswer = inAnswer == null ? null : inAnswer.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getValidate() {
        return validate;
    }

    public void setValidate(Date validate) {
        this.validate = validate;
    }

    public String getKnowledgePointCode() {
        return knowledgePointCode;
    }

    public void setKnowledgePointCode(String knowledgePointCode) {
        this.knowledgePointCode = knowledgePointCode == null ? null : knowledgePointCode.trim();
    }

    public String getAuditUserCode() {
        return auditUserCode;
    }

    public void setAuditUserCode(String auditUserCode) {
        this.auditUserCode = auditUserCode == null ? null : auditUserCode.trim();
    }

	@Override
	public String toString() {
		return "StdQuestion [id=" + id + ", stdQuestion=" + stdQuestion
				+ ", stdQuestionCode=" + stdQuestionCode + ", outAnswer="
				+ outAnswer + ", inAnswer=" + inAnswer + ", categoryCode="
				+ categoryCode + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", createUserCode=" + createUserCode
				+ ", updateUserCode=" + updateUserCode + ", status=" + status
				+ ", validate=" + validate + ", knowledgePointCode="
				+ knowledgePointCode + ", auditUserCode=" + auditUserCode + "]";
	}
    
    
}