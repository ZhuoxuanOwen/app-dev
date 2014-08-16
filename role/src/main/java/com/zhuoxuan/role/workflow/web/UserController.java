package com.zhuoxuan.role.workflow.web;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 *   处理用户请求
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月5日
 * @version： V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	IdentityService identityService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 保存流程引擎的用户信息
	 * @return
	 */
	@RequestMapping("/saveWorkFlowUser")
	@ResponseBody
	public ResultBase<Boolean> saveWorkFlowUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd){
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		try {
			
			User user = new UserEntity();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(pwd);
			identityService.saveUser(user);
			return result.setReturnRightValue(true);
		} catch (Exception e) {
			logger.error("保存用户信息失败"+e.getCause());
			return result.setReturnErrorMsg("保存用户信息失败，" + e.getMessage());
		}
	}
	

	/**
	 * 用户数据查询
	 * @return
	 */
	@RequestMapping("/userQuery")
	public ModelAndView userIdentityQuery(ModelMap modelMap,@RequestParam("cpage") int cpage){
		
		int start = (cpage -1) * 20;
		
		List<User> userList = identityService.createUserQuery().orderByUserId().desc().listPage(start, 20);
		modelMap.put("userList", userList);
		
		return new ModelAndView("workflow/user/user_list");
	}
	
	
	
	
	/**
	 * 保存用户组
	 * @return
	 */
	@RequestMapping("/saveGroup")
	public ResultBase<Boolean> saveWorkFlowGroup(@RequestParam("groupName") String groupName,
			@RequestParam("type") String type){
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		
		try {
			Group group = new GroupEntity();
			group.setName(groupName);
			group.setType(type);
			identityService.saveGroup(group);
			return result.setReturnRightValue(true);
		} catch (Exception e) {
			logger.error("保存组信息失败" + e.getCause());
			return result.setReturnErrorMsg("保存组信息失败，" + e.getMessage());
		}
		
	}
	
	
	
}
