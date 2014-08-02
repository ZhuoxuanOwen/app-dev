package com.zhuoxuan.vote.dao;

import com.zhuoxuan.vote.entity.SurveyDO;

/**
 * 
 * <p>
 *   问卷数据操作接口
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年7月31日
 * @version： V1.0
 */
public interface SurveyDao {
	
	/**
	 * 添加文件数据
	 * @param surveyDO
	 */
	public void addSurvey(SurveyDO surveyDO);

}
