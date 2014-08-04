package com.zhuoxuan.vote.entity;

import java.util.Date;

/**
 * 
 * <p>
 *   选项数据
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月2日
 * @version： V1.0
 */
public class OptionDO {

	private int optionId;
	
	private int surveyId; //所属问卷ID
	
	private String title;
	
	private int count = 0;
	
	private Date created;
	
	private Date updated;

	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
	
	
}
