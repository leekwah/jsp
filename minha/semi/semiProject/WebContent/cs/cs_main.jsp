<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean class="cs.QnABoardBean" id="qBoard"></jsp:useBean>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>���񽺼���</h2>
	<nav>
		<ul>
			<li><a href="../qna/write.jsp">Q&A ����</a></li>
			<li><a href="../FAQ/FAQ.jsp">FAQ</a></li>
			<li><a href="../notice/listNotice.jsp">��������</a></li>
		</ul>
	</nav>
	<jsp:include page="../FAQ/FAQ.jsp"></jsp:include>
</body>
</html>