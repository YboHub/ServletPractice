<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectstu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
  	<a href="addstu">添加</a>
    <%
    	String msg1 = (String)request.getAttribute("msg1");
    	if (msg1==null) {
    		msg1 = "";
    	}
    	String msg2 = (String)request.getAttribute("msg2");
    	if (msg2==null) {
    		msg2 = "";
    	}
    	String msg3 = (String)request.getAttribute("msg3");
    	if (msg3==null) {
    		msg3 = "";
    	}
    %>
    <%=msg1 %>
    <%=msg2 %>
    <%=msg3 %>
    <form action="addstu" method="post">
     <table border="1px">
     	<%List tableList = (List)request.getAttribute("list");
     		for(int i=0;i<tableList.size();i++){%>
     	 <tr>
     		<%List trList = (List)tableList.get(i);
     			for(int j=0;j<trList.size();j++){%>
     		<td><%=trList.get(j)%></td>
     		<%}%>
     		<td>
     			<input type="button" value="删除" onclick="del(<%=trList.get(0)%>)"/>
     			<input type="button" value="更改" onclick="edi(<%=trList.get(0)%>)"/>
     		</td>		
     	 </tr>
     	<%} %>
     </table>
     <script type="text/javascript">
     	function del(id){
     		if (confirm("确认操作？")) {
				location.href="<%=path%>/deletestu?id="+id;
			}
     	}
     	function edi(id){
     		if (confirm("确认操作？")) {
				location.href="<%=path%>/editstu?id="+id;
			}
     	}
     </script>
     </form>
  </body>
</html>
