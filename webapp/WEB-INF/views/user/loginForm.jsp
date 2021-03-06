<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">
		
		
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		
		<br>
		
		<div id="loginForm">
		
			<form action="${pageContext.request.contextPath}/user/login" method="get">
			
	      		<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="textId">아이디</label></td>
		      			<td><input id="textId" type="text" name="id"></td>
		      		</tr>
		      		<tr>
		      			<td><label for="textPassword">패스워드</label> </td>
		      			<td><input id="textPassword" type="password" name="password"></td>   
		      			   			
		      		</tr> 
		      		<tr>
		      			<td colspan="2" id="tdMsg" colspan="2">
		      				<span>아이디 또는 패스워드를 확인해 주세요.</span>
		      			</td>
		      		</tr>
		      		<c:if test="${param.result == 'fail'}">
						<p>로그인에 실패하셨습니다.<br>다시 입력해 주십시오.</p>
					</c:if>
		      	</table>
		      	
	      		<div id="btnArea">
					<button class="btn" type="submit" >로그인</button>
				</div>
	      		
			</form>
		
		</div>
		
		<br><br><br><br><br>
		
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		
	</div>
	
</body>

</html>