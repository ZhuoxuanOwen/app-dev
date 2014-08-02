package com.zhuoxuan.vote.service;

import com.zhuoxuan.vote.common.ResultBase;
import com.zhuoxuan.vote.entity.SurveyDO;

/**
 * 
 * <p>
 *   问卷业务处理接口
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年7月31日
 * @version： V1.0
 */
public interface SurveyService {
	
	/**
	 * 添加问卷信息
	 * @param surveyDO
	 * @return
	 */
	ResultBase<Boolean> addSurvery(SurveyDO surveyDO);

}
