package com.zhuoxuan.vote.dao;

import com.zhuoxuan.vote.entity.OptionDO;

/**
 * 
 * <p>
 * 	问卷选项数据处理接口
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月2日
 * @version： V1.0
 */
public interface OptionDao {
	
	/**
	 * 添加一个选项
	 * @param optionDO
	 * @return
	 */
	boolean addOption(OptionDO optionDO);

}
