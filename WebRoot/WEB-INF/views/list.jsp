<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="static/jq.js"></script>
	<script type="text/javascript">
		$(function(){
			$('.del').click(function(){
				$('form').attr('action',$(this).attr('href')).submit();
				return false;
			});
		});
	</script>
	

  </head>
  
  <body>
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>  
	
  	<table>
    <c:forEach items="${list }" var="l" >
    	<tr>
    		<td>${l.id }</td>
    		<td>${l.name }</td>
    		<td>${l.remark }</td>
    		<td><a class="del" href="delete/${l.id}">delete</a></td>
    	</tr>
    </c:forEach>
    </table>
  </body>
</html>
