package com.zhuoxuan.vote.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.vote.common.DateUtil;
import com.zhuoxuan.vote.common.ResultBase;
import com.zhuoxuan.vote.common.VoteConstants;
import com.zhuoxuan.vote.common.VoteConstants.VoteGroup;
import com.zhuoxuan.vote.entity.SurveyDO;
import com.zhuoxuan.vote.service.SurveyService;

/**
 * 
 * <p>
 * 	Spring Controller
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月1日
 * @version： V1.0
 */

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@Resource
	private SurveyService surveyService;
	
	
	/**
	 * 初始化添加问卷问题页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/initAddSurvey")
	public ModelAndView initAddSurvey(ModelMap modelMap){
		
		VoteGroup [] voteGroupList = VoteConstants.VoteGroup.values();
		modelMap.put("voteGroupList", voteGroupList);
		
		return new ModelAndView("vote/add_survey");
	}
	
	/**
	 * 保存一个问卷调查
	 * @return
	 */
	@RequestMapping("/saveSurvey")
	@ResponseBody
	public ResultBase<Boolean> saveSurvey(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("title") String title,@RequestParam("type") int type,
			@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
			@RequestParam("options") String options,@RequestParam("creator") String creator){
		
		SurveyDO surveyDO = new SurveyDO();
		surveyDO.setTitle(title);
		surveyDO.setType(type);
		surveyDO.setCreator(creator);
		surveyDO.setStartTime(DateUtil.getDate(startTime, DateUtil.PT_DATE));
		surveyDO.setEndTime(DateUtil.getDate(endTime, DateUtil.PT_DATE));
		surveyDO.setOptions(options);
		//调用业务接口进行保存
		ResultBase<Boolean> resultSave = surveyService.addSurvery(surveyDO);
		return  resultSave;
	}

}
