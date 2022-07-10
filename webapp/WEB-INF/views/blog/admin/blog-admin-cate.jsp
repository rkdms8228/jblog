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
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">

	/* 페이지 준비 */
	$(document).ready(function() {
		
		console.log("페이지 준비");
		
		/* 리스트 그리기 */
		fetchList();
		
	});
	
	/* 카테고리 리스트 요청 */
	function fetchList() {
		
		$.ajax({
			
			//보낼 때
			url : "${pageContext.request.contextPath}/${authUser.id}/admin/categoryList",
			type : "post",
			//contentType : "application/json",
			//data : {name: "홍길동"},
			
			//받을 때
			dataType : "json",
			success : function(cateList){
				
				/*성공시 처리해야 될 코드 작성*/
				console.log(cateList);
				
				//화면 data + html 그린다
				for(var i=0; i<cateList.length; i++) {
					render(cateList[i]);
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
			
		});
		
	};
	
	/* 리스트 1개씩 그리기 */
	function render(categoryVo) {
		
		console.log("render");
		
		var str = "";
		str += "<tr id='cate"+categoryVo.cateNo+"'>";
		str += "	<td>"+categoryVo.cateNo+"</td>";
		str += "	<td>"+categoryVo.cateName+"</td>";
		str += "	<td>"+categoryVo.postCnt+"</td>";
		str += "	<td>"+categoryVo.description+"</td>";
		str += "	<td class='text-center'>";
		str += "		<img data-no='"+categoryVo.cateNo+"' data-postcnt='"+categoryVo.postCnt+"' class='btnCateDel' src='${pageContext.request.contextPath}/assets/images/delete.jpg'>";
		str += "	</td>";
		str += "</tr>";
		
		$("#cateList").prepend(str);
		
	};
	
	/* 카테고리 추가 버튼 클릭했을 때 */
	$("#btnAddCate").on("click", function() {
		
		console.log("카테고리 추가");
		
		var id = "${authUser.id}";
		var cateName = $("[name=name]").val();
		var desc = $("[name=desc]").val();
		
		var categoryVo = {
			id: id
			, cateName: cateName
			, description: desc
		}
		
		$.ajax({
			
			//보낼 때
			url : "${pageContext.request.contextPath }/${authUser.id}/admin/categoryAdd",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(categoryVo),
			
			//받을 때
			dataType : "json",
			success : function(categoryVo){
				
				/*성공시 처리해야될 코드 작성*/
				console.log(categoryVo);
				render(categoryVo);
				
				$("[name=name]").val("");
				$("[name=desc]").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	/* 카테고리 삭제 버튼 클릭했을 때 */
	$("#cateList").on("click", ".btnCateDel", function() {
		
		console.log("삭제버튼");
		
		var $this = $(this);
		var no = $this.data("no");
		var postCnt = $this.data("postcnt");
		
		var categoryVo = {
				cateNo: no
				, postCnt: postCnt
		}
		
		$.ajax({
			
			//보낼 때
			url : "${pageContext.request.contextPath }/${authUser.id}/admin/categoryDelete",
			type : "post",
			//contentType : "application/json",
			data : categoryVo,
			
			//받을 때
			//dataType : "json",
			success : function(result){
				
				/*성공시 처리해야될 코드 작성*/
				console.log(result);
				
				if(result == "success") {
					$("#cate"+no).remove();
				} else {
					alert('삭제할 수 없습니다.');
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
			
		});
		
	});
	
</script>

</html>