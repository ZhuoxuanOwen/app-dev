package com.zhuoxuan.rule.workflow.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>
 *  欢迎页
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月15日
 * @version： V1.0
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * 系统可用流程
	 * @return
	 */
	@RequestMapping("/processDefineMerge")
	public ModelAndView processDefineQuery(@RequestParam("cpage") int cpage,
			ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response){
		
		List<ProcessDefinition> processDefineList =  repositoryService.createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion().desc().latestVersion()
					.listPage( (cpage-1) * 20,20);

		modelMap.put("processDefineList", processDefineList);
		
		return new ModelAndView("/workflow/process_define_list");
	}

}
