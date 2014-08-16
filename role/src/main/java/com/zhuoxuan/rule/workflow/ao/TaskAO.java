package com.zhuoxuan.rule.workflow.ao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Repository;

import com.zhuoxuan.role.common.ResultBase;
import com.zhuoxuan.role.common.WorkFlowConstants;
import com.zhuoxuan.rule.workflow.entity.UserTask;

/**
 * 
 * <p>
 *  处理任务的一些信息
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月16日
 * @version： V1.0
 */
@Repository("taskAO")
public class TaskAO {
	
	@Resource
	private TaskService taskService;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private RepositoryService repositoryService;
	@Resource
	private IdentityService identityService;
	
	/**
	 * 获取用户的任务
	 * @param email
	 * @return
	 */
	public ResultBase<List<UserTask>> mergeUserTask(String email,int cpage){
		
		ResultBase<List<UserTask>> resultBase = new ResultBase<List<UserTask>>();
		
		try {
			List<UserTask> userTaskList = new ArrayList<UserTask>();
			
			int start = (cpage -1) * 20;
			//调用引擎，查询当前任务
			List<Task> taskOneList =  taskService.createTaskQuery().orderByTaskPriority().desc().orderByDueDate().desc().
					taskCandidateUser(email).listPage(start, 20);
			
			for (Task task : taskOneList) {
				UserTask ut = mergeUserTask(task);
				userTaskList.add(ut);
			}
			return resultBase.setReturnRightValue(userTaskList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultBase.setReturnErrorMsg("获取当前登录人得代办任务出现异常，原因："+ e.getMessage());
		}
	}
	
	
	/**
	 * 使用Task构建 UserTask 对象
	 * @param task
	 * @return
	 */
	public UserTask mergeUserTask(Task task){
		
		//获取流程实例中的共享变量
		Map<String, Object> vars = runtimeService.getVariables(task.getExecutionId());
		
		UserTask userTask = new UserTask();
		
		//设置用户信息
		if(vars.get(WorkFlowConstants.UserId) != null){
			User applyUser = identityService.createUserQuery().userId(String.valueOf(vars.get(WorkFlowConstants.UserId))).singleResult();
			userTask.setApplyUser(applyUser);
		}
		//设置流程实例信息
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().
				processInstanceId(task.getProcessInstanceId()).singleResult();
		userTask.setProcessInstance(processInstance);
		
		//设置流程定义信息
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().
				processDefinitionId(task.getProcessDefinitionId()).singleResult();
		userTask.setProcessDefinition(processDefinition);
		
		userTask.setTask(task);
		
		return userTask;
	}

}
