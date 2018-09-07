/**
 * 
 */
package com.insigma.bean;
import com.insigma.domain.StdQuestion;
import com.insigma.util.DateUtil;

/**
 * @author insigma
 *
 */
public class StdQuestionBean extends StdQuestion {

	private String categoryName;//分类名称
	private String validateStr;//有效期
	private String createTimeStr;//创建时间
	private String statusShow;//状态
	private String updateUserName;//更新人员名称
	private String auditUserName;//更新人员名称
	private String addAlikeQuestions;//新增相似问题字符串
	private String updateAlikeQuestions;//修改相似问题字符串
	private String delAlikeQuestionIds;//删除相似问题编号
	private String addRelaQuestions;//添加关联问题
	private String updateRelaQuestions;//添加关联问题
	private String delRelaQuestions;//添加关联问题
	
	private String[] categoryCodes;//该级分类下属所有分类
	public String[] getCategoryCodes() {
		return categoryCodes;
	}
	public void setCategoryCodes(String[] categoryCodes) {
		this.categoryCodes = categoryCodes;
	}
	public String getDelAlikeQuestionIds() {
		return delAlikeQuestionIds;
	}

	public void setDelAlikeQuestionIds(String delAlikeQuestionIds) {
		this.delAlikeQuestionIds = delAlikeQuestionIds;
	}

	private String updateTimeStr;//更新时间
	private String auditOpinion;//审核意见
	private String hasPriv;//是否为知识库管理员

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public String getValidateStr() {
		if (this.getValidate() != null) {
			validateStr = DateUtil.date2String(this.getValidate());
		}
		return validateStr;
	}

	public void setValidateStr(String validateStr) {
		this.validateStr = validateStr;
	}


	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getStatusShow() {
		if (getStatus() == null) return "";
		switch (getStatus()) {
			case 1:
				statusShow = "未提交";
				break;
			case 2:
				statusShow = "待审核";
				break;
			case 3:
				statusShow = "已发布";
				break;
			case 4:
				statusShow = "被驳回";
				break;
			default:
				break;
		}
		return statusShow;
	}

	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAddAlikeQuestions() {
		return addAlikeQuestions;
	}

	public void setAddAlikeQuestions(String addAlikeQuestions) {
		this.addAlikeQuestions = addAlikeQuestions;
	}

	public String getUpdateAlikeQuestions() {
		return updateAlikeQuestions;
	}

	public void setUpdateAlikeQuestions(String updateAlikeQuestions) {
		this.updateAlikeQuestions = updateAlikeQuestions;
	}

	public String getUpdateTimeStr() {
		updateTimeStr = DateUtil.date2String(this.getUpdateTime());
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public String getHasPriv() {
		return hasPriv;
	}

	public void setHasPriv(String hasPriv) {
		this.hasPriv = hasPriv;
	}
	public String getAddRelaQuestions() {
		return addRelaQuestions;
	}
	public void setAddRelaQuestions(String addRelaQuestions) {
		this.addRelaQuestions = addRelaQuestions;
	}
	public String getUpdateRelaQuestions() {
		return updateRelaQuestions;
	}
	public void setUpdateRelaQuestions(String updateRelaQuestions) {
		this.updateRelaQuestions = updateRelaQuestions;
	}
	public String getDelRelaQuestions() {
		return delRelaQuestions;
	}
	public void setDelRelaQuestions(String delRelaQuestions) {
		this.delRelaQuestions = delRelaQuestions;
	}
	
	
	
	
	
	
}
