<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<div id="center-content">
		
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>

		<div>
		
			<br>
			
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join/${authUser.id}">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id"></td>
		      			<td>
		      				<button id="btnIdCheck" type="button">아이디체크</button>
		      				<input type="hidden" name="idDuplication" value="idUncheck">
		      			</td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password" value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName" value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
		      	
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
			<br><br><br><br><br>
			
		</div>
		
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		
	</div>

</body>

<script type="text/javascript">

	//아이디 중복 체크 (아이디 중복일 때 = 0 , 중복이 아닐 때 = 1 )
	var idcheck = 0;
	var ick = false;
	
	//idCheck 버튼을 클릭했을 때 
	$("#joinForm").on("submit", function() {
	    
		var joinId =  $("#txtId").val();
		var joinPw =  $("#txtPassword").val();
		var joinName =  $("#txtUserName").val();
		var joinAgree = $("#chkAgree").is(":checked");
		
		
		if (joinId == "" || joinId == null) { //아이디
		    alert("아이디를 입력해 주세요.");
		    return false;
		}else if (ick == false) { //중복 확인
		    alert("아이디 중복 확인해 주세요.");
		    return false;
		}else if (joinPw == "" || joinPw == null) { //패스워드   
		    alert("패스워드를 입력해 주세요.");
		    return false;
		}else if (joinName == "" || joinName == null) { //이름	    
		    alert("이름을 입력해 주세요.");
		    return false;
		}else if(joinAgree == false) { //약관동의	
			alert("약관에 동의해 주세요.");
		    return false;
		}else {
			
		}
		
	});
	
	$("#btnIdCheck").on("click", function() {
		
		var id = $("[name=id]").val();
		
		var userVo = {
			id : id
		};
		
		$.ajax({
			 
			//보낼 때
			url : "${pageContext.request.contextPath}/user/joinCheck",
			type : "post",
			//contentType: "application/json",
			data: userVo,
			 
			//받을 때
			//dataType : "json",
			success : function(result) {
				
				if (id == null || id == "") {
				    
					$("#tdMsg").text("아이디를 입력해 주세요.");

				}else if (result == "fail") {
					 $("#tdMsg").text("이미 존재하는 아이디입니다. 다른 아이디를 입력해 주세요.");
				}else {
					
					 $("#tdMsg").text("사용 가능한 아이디입니다.");
				    
				    //아이디가 중복되지 않으면  idcheck = 1 
				    idcheck = 1;
				    ick = true;
				    
				}
			       
			},
			 error : function(error) { 
			     alert("error : " + error);
			}
		     
		});return result;
		
	});

</script>

</html>