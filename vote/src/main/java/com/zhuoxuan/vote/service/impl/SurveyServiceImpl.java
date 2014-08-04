package com.zhuoxuan.vote.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;
import com.zhuoxuan.vote.common.DateUtil;
import com.zhuoxuan.vote.common.ResultBase;
import com.zhuoxuan.vote.dao.OptionDao;
import com.zhuoxuan.vote.dao.SurveyDao;
import com.zhuoxuan.vote.entity.OptionDO;
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
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {

	@Resource
	private SurveyDao surveyDao;
	@Resource
	private OptionDao optionDao;
	
	private Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);
	
	@Override
	public ResultBase<Boolean> addSurvery(SurveyDO surveyDO) {
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		try {
			synchronized (this) {
				surveyDO.setCreateTime(DateUtil.getCurrentDate());
				int surveyId = surveyDao.addSurvey(surveyDO);
				//循环加入问卷选项
				String optionsString = surveyDO.getOptions();
				List<String> optionList = Splitter.on(";").omitEmptyStrings().trimResults().splitToList(optionsString);
				for (String optionTitle : optionList) {
					OptionDO optionDO = new OptionDO();
					optionDO.setSurveyId(surveyId);
					optionDO.setTitle(optionTitle);
					optionDO.setCreated(DateUtil.getCurrentDate());
					optionDao.addOption(optionDO);
				}
			}
			return result.setReturnRightValue(true);
		} catch (Exception e) {
			logger.error("保存问卷信息失败，" + e.getCause());
			return result.setReturnErrorMsg("保存问卷信息失败，" + e.getCause());
		}
	}

}
