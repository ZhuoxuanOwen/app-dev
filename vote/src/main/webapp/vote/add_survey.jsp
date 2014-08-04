<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="<%=path %>/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
<link href="<%=path %>/assets/styles.css" rel="stylesheet" media="screen">
<link href="<%=path %>/vendors/datepicker.css" rel="stylesheet" media="screen">

</head>
<body>
	  <jsp:include page="/common/head.jsp" />
	  <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">添加一个调查问题</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form id="frmSaveSurvey" class="form-horizontal">
                                      <fieldset>
                                      	<div class="control-group">
                                          <label class="control-label" for="focusedInput">选择所属组</label>
                                          <div class="controls">
                                          	<c:forEach var="group" items="${voteGroupList }">
                                          		<input type="radio" name="groupId" id="groupId" data-provide="typeahead"  value="${group.groupId }"/> ${group.groupDesc } &nbsp;&nbsp;
                                          	</c:forEach>
                                            
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">标题</label>
                                          <div class="controls">
                                            <input type="text" class="span6" id="title" name="title" data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label">选择类型</label>
                                          <div class="controls">
                                            <input type="radio" name="type" id="type" data-provide="typeahead"  value="1" checked="checked"/> 单选 &nbsp;&nbsp;
                                             <input type="radio" name="type" id="type" data-provide="typeahead"  value="2" /> 复选 &nbsp;&nbsp;
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="disabledInput">开始时间</label>
                                          <div class="controls">
                                            <input name="startTime"  type="text" class="span3 datepicker " id="date01" value="">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="optionsCheckbox2">结束时间</label>
                                          <div class="controls">
                                            <label>
                                              <input name="endTime" type="text" class="span3 datepicker" id="date01" value="">
                                            </label>
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="optionsCheckbox2">调查选项</label>
                                          <div class="controls">
                                            <label>
                                              <textarea name="options" class="span6" rows="10" cols="120" placeholder="选项之间以英文;相隔开"></textarea>
                                            </label>
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">创建人</label>
                                          <div class="controls">
                                            <input type="text" class="span6" id="creator" name="creator" data-provide="typeahead" data-items="4" value="卓轩" >
                                          </div>
                                        </div>
                                        <div class="form-actions">
                                          <button id="btnSaveSurvey" type="button" class="btn btn-primary">保存</button>
                                          <button type="reset" class="btn">取消</button>
                                        </div>
                                      </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
        </div>
        <script src="<%=path %>/vendors/jquery-1.9.1.min.js"></script>
        <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="<%=path %>/assets/scripts.js"></script>
        <script src="<%=path %>/vendors/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
        
        jQuery(function() {
        	//时间控件
        	$('.datepicker').datepicker({
        		  format: 'yyyy-mm-dd',
    		      weekStart: 1,
    		      autoclose: true,
    		      todayBtn: 'linked',
    		      language: 'zh-CN'
        	});
        	
        	
        	//添加测试用例
			$("#btnSaveSurvey").click(function (){
				//do some check
				var title = $("#title").val();
				if(title == ""){
					alert("请输入用例标题。");
					return;
				}
				var options = $("options").val();
				if(options == ""){
					alert("请输入调查选项。");
					return;
				}
				//send ajax request to save testcase
				alert("要保存了");
				var param = $("#frmSaveSurvey").serialize();
				$.ajax({
						type : 'post',
						url : '<%=path%>/survey/saveSurvey.do',
						data : param,
						dataType : 'json',
						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
						success : function(data) {
							if (data.success) {
								alert("添加测试用例成功！");
								location.href="<%=path%>/index.jsp";
							} else {
								alert(data.errorMsg);
							}
						},
						error : function(XMLHttpRequest,textStatus, errorThrown) {
							alert(textStatus);
						}
					});
				 });
		  });
        	
        </script>
</body>
</html>