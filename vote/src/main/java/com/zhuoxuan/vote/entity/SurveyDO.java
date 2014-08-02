package com.zhuoxuan.vote.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>
 *   问卷问题
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年7月31日
 * @version： V1.0
 */
public class SurveyDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3967444204004831974L;
	
	private int surveyId;
	
	/**
	 * 分组ID
	 */
	private int groupId;
	
	/**
	 * 类型，单选，多选
	 */
	private int type;
	
	/**
	 * 问卷标题
	 */
	private String title;
	
	/**
	 * 问卷icon
	 */
	private String img;
	
	/**
	 * 选项 
	 */
	private String options;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 开始时间
	 */
	private Date startTime;
	
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	private Date updated;
	
	/**
	 * 创建人
	 */
	private String creator;
	

	
	
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
	
	
}
