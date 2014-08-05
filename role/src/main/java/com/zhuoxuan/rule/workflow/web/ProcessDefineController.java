package com.zhuoxuan.rule.workflow.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>
 *  处理流程定义的请求
 *  1、上传文件，定义流程
 *  2、查询所有的流程定义
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月4日
 * @version： V1.0
 */
@Controller
@RequestMapping("/workflow/processDef")
public class ProcessDefineController {
	
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * 上传文件部署 流程
	 * @return
	 */
	@RequestMapping("/deployeProcessByUpload")
	public ModelAndView deployeProcessByUpload(ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response){
		try {
			//获取 MultipartHttpServletRequest 对象
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multiRequest.getFile("processFile");// 文件对象
			
			InputStream inputStream = multipartFile.getInputStream();
			ZipInputStream processInputStream = new ZipInputStream(inputStream);
			Deployment deployment = repositoryService.createDeployment().addZipInputStream(processInputStream).deploy();
			if(deployment == null){
				modelMap.put("errorMsg", "发布流程定义失败。");
			}
		} catch (IOException e) {
			modelMap.put("errorMsg", "发布流程定义失败。");
		}
		return new ModelAndView("");
	}
	
	
	
	/**
	 * 查询流程定义
	 * @return
	 */
	@RequestMapping("/processDefineQuery")
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
