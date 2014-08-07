package com.zhuoxuan.rule.workflow.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.role.common.RoleConstants;

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
		int start = (cpage -1) * 20;
		List<Task> taskOneList =  taskService.createTaskQuery().orderByTaskPriority().orderByDueDate().
				taskCandidateUser(email).listPage(start, 20);
		
		modelMap.put("taskList", taskOneList);
		return taskListView;
	}

}
