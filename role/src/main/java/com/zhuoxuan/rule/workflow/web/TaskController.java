package com.zhuoxuan.rule.workflow.web;

import javax.annotation.Resource;

import org.activiti.engine.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
