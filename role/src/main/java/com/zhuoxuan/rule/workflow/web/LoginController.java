package com.zhuoxuan.rule.workflow.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuoxuan.role.common.ResultBase;
import com.zhuoxuan.role.common.RoleConstants;

/**
 * 
 * <p>
 *  处理登录的请求
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月5日
 * @version： V1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private IdentityService identityService;
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 用户登录
	 * @param email
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public ResultBase<Boolean> workflowUserLogin(HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd){
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		try {
			//查询用户是否存在
			User user = identityService.createUserQuery().userEmail(email).singleResult();
			if(user == null){
				return result.setReturnErrorMsg("该用户不存在。");
			}
			//验证密码是否正确
			boolean checkPwd = identityService.checkPassword(user.getId(), pwd);
			if(!checkPwd){
				return result.setReturnErrorMsg("用户密码不正确。");
			}
			
			//将登录用户放入Session中
			request.getSession().setAttribute(RoleConstants.LoginUser, user);
			
			return result.setReturnRightValue(true);
		} catch (Exception e) {
			logger.error("用户登录信息失败"+e.getCause());
			return result.setReturnErrorMsg("用户登录失败，" + e.getMessage());
		}
	}
	
}
