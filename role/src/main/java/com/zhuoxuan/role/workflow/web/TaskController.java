package com.zhuoxuan.role.workflow.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.FormService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormData;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.role.common.ResultBase;
import com.zhuoxuan.role.common.RoleConstants;
import com.zhuoxuan.role.workflow.ao.TaskAO;
import com.zhuoxuan.role.workflow.entity.UserTask;

/**
 * 
 * <p>
 *  处理任务的请求
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月5日
 * @version： V1.0
 */
@Controller
@RequestMapping("/workflow/task")
public class TaskController {
	
	@Resource
	private TaskService taskService;
	@Resource
	private FormService formService;
	@Resource
	private TaskAO taskAO;
	
	/**
	 * 我的代办任务列表
	 * @return
	 */
	@RequestMapping("/theTask")
	public ModelAndView theTask(ModelMap modelMap,HttpServletRequest request,@RequestParam("cpage") int cpage){
		
		ModelAndView taskListView = new ModelAndView("workflow/the_task");
		Object loginUser = request.getSession().getAttribute(RoleConstants.LoginUser);
		if(loginUser == null){
			modelMap.put("errorMsg", "当前没有登录，请登录。");
			return taskListView;
		}
		User user = (User)loginUser;
		String email = user.getEmail();
		//调用流程引擎接口查询
		ResultBase<List<UserTask>> resultBase = taskAO.mergeUserTask(email, cpage);
		if (resultBase.isSuccess()) {
			modelMap.put("taskList", resultBase.getValue());
		}else{
			modelMap.put("errorMsg", "获取当前登录人的代办任务异常，"+resultBase.getErrorMsg());
		}
		return taskListView;
	}
	
	/**
	 * Task 处理详情页
	 */
	@RequestMapping("/taskClaim")
	public ModelAndView taskClaim(ModelMap modelMap,@RequestParam("taskId") String taskId){
		
		ModelAndView taskClaimView = new ModelAndView("workflow/task_claim");
		//调用流程引擎查询出任务
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(task == null){
			modelMap.put("errorMsg", "需要处理的任务不存在");
			return taskClaimView;
		}
		//调用接口获取任务详细信息
		UserTask userTask = taskAO.mergeUserTask(task);
		modelMap.put("ut", userTask);
		//处理任务的form
		FormData formData =	formService.getTaskFormData(taskId);
		if(formData != null){
		  List<FormProperty> formPropertieList = formData.getFormProperties();
		  modelMap.put("formProperties", formPropertieList);
		}
		return taskClaimView;
	}
	
	
	

}
