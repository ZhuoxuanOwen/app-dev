package com.zhuoxuan.vote.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhuoxuan.vote.common.ResultBase;
import com.zhuoxuan.vote.dao.SurveyDao;
import com.zhuoxuan.vote.entity.SurveyDO;
import com.zhuoxuan.vote.service.SurveyService;

/**
 * 
 * <p>
 * 	调查业务实现类
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年7月31日
 * @version： V1.0
 */
@Service("surveryService")
public class SurveryServiceImpl implements SurveyService {

	@Resource
	private SurveyDao surveyDao;
	
	@Override
	public ResultBase<Boolean> addSurvery(SurveyDO surveyDO) {
		
		
		surveyDao.addSurvey(surveyDO);
		
		return null;
	}

}
