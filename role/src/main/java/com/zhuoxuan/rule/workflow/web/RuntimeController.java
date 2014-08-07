package com.zhuoxuan.rule.workflow.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.role.common.ResultBase;

/**
 * 
 * <p>
 *  流程运行时的业务处理
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月4日
 * @version： V1.0
 */
@Controller
@RequestMapping("/workflow/runtime")
public class RuntimeController {
	
	
	@Resource
	private RuntimeService runtimeService;
	
	/**
	 * 启动一个流程实例
	 * @param key
	 * @return
	 */
	@RequestMapping("/startProcess")
	@ResponseBody
	public ResultBase<Boolean> startProcess(@RequestParam("key") String key){
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(key);
		if(instance != null && instance.getProcessInstanceId() != null){
			return result.setReturnRightValue(true);
		}else {
			return result.setReturnErrorMsg("启动流程失败");
		}
	}
	
	/**
	 * 运行的流程实例查询
	 * @param cpage
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/processInstanceQuery")
	public ModelAndView processInstanceQuery(@RequestParam("cpage") int cpage,
			ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response){
		
		int start = (cpage -1) * 20;
		//调用接口查询流程实例，正在运行的
		List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().orderByProcessInstanceId().asc()
			.listPage(start, 20);
		
		modelMap.put("processInstanceList", processInstanceList);
		
		
		return new ModelAndView("workflow/instance_process_list");
	}
	

}
