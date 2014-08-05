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
                     <div class="muted pull-left">发布流程定义</div>
                 </div>
                 <div class="block-content collapse in">
                     <div class="span12">
                          <form id="frmProcessUpload" class="form-horizontal" enctype="multipart/form-data" method="post" action="<%=path%>/workflow/processDef/deployeProcessByUpload.do">
                           <fieldset>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">流程部署文件</label>
                               <div class="controls">
                                 <input type="file" class="span6" id="processFile" name="processFile"  >
                               </div>
                             </div>
                             <div class="form-actions">
                               <button id="btnProcessUpload" type="submit" class="btn btn-primary">发布</button>
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
        	
        	
	    });
        	
        </script>
</body>
</html>