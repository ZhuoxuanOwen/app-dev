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
</head>
<body>
      <jsp:include page="/common/head.jsp" />
	  <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">运行中得流程监控</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group" style="padding-bottom: 20px;">
                                      </div>
                                      <div class="btn-group pull-right">
                                      </div>
                                   </div>
                                    
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                        <thead>
                                            <tr>
                                                <th>名称</th>
                                                <th>版本</th>
                                                <th>Key</th>
<!--                                                 <th>命名空间</th> -->
                                                <th>描述</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach items="${processInstanceList }" var="pd">
                                           	 <tr class="odd gradeX">
                                                <td>${pd.processDefinitionId }</td>
                                                <td>${pd.name }</td>
                                                <td>
                                                	<button class="btn btn-success startProcess" data-key="${pd.processDefinitionId }">申请</button>
                                                	
                                                	
                                                </td>
                                            </tr>
                                           </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
     </div>
     
     <script src="<%=path %>/vendors/jquery-1.9.1.min.js"></script>
     <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
     <script src="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
     <script src="<%=path %>/assets/scripts.js"></script>
     <script src="<%=path %>/vendors/datatables/js/jquery.dataTables.min.js"></script>
     <script type="text/javascript">
     
       
 	
     </script>
     
</body>
</html>