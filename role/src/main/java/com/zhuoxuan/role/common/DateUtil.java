package com.zhuoxuan.role.common;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>
 *  处理时间的工具类
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年6月9日
 * @产品: Aegis(神盾-技术支撑平台)
 * @version： V1.0
 */
public class DateUtil implements Serializable{
	
	
	public static final String PT_DATE = "yyyy-MM-dd";

	/**
	 * 
	 */
	private static final long serialVersionUID = -3758536094497678451L;

	/**
	 * 获取当前系统的时间戳
	 * @return
	 */
	public static Long getCurrentTimeMillis(){
		return new Date().getTime();
	}
	
	
	public static Date getCurrentDate(){
		return new Date();
	}
	
	/**
	 * 换换成日期类型
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static Date getDate(String dateTime,String format){
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
