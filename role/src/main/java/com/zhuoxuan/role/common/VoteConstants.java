package com.zhuoxuan.role.common;

/**
 * 
 * <p>
 * 调查常量
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月2日
 * @version： V1.0
 */
public class VoteConstants {

	//组
	public enum VoteGroup {
		
		PRO_TALK(1, "proreq", "战略项目"),
		SY_DEV(2, "dev", "技术开发"),
		ACT(3, "act", "内部活动"), 
		CASE(4, "case", "调研方案");

		private VoteGroup(Integer groupId, String groupCode, String groupDesc) {
			this.groupId = groupId;
			this.groupCode = groupCode;
			this.groupDesc = groupDesc;
		}

		private Integer groupId;
		private String groupCode;
		private String groupDesc;

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}

		public String getGroupCode() {
			return groupCode;
		}

		public void setGroupCode(String groupCode) {
			this.groupCode = groupCode;
		}

		public String getGroupDesc() {
			return groupDesc;
		}

		public void setGroupDesc(String groupDesc) {
			this.groupDesc = groupDesc;
		}

	}

}
