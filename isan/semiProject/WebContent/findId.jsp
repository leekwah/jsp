<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="findinfo.js" charset="utf-8"></script>
</head>
<body>
	<form name="i_frm" method="post" action="findIdResult.jsp">
			<div class = "search-title">
				<h3>�޴��� ����Ȯ��</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>�̸�</label>
				<input type="text" name="user_name" class = "btn-name" placeholder = "����� �̸�">
			<br>
			</div>
			<div class = "find-phone">
				<label>��ȣ</label>
				<input type="text" name="user_phone" class = "btn-phone" placeholder = "�޴�����ȣ�� '-'���� �Է�">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="button" name="enter" value="ã��"  onClick="id_search()">
		<input type="button" name="cancle" value="���" onClick="history.back()">
 	</div>
 </form>
</body>
</html>