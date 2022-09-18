<%@page import="login.UserDBBean"%>
<%@page import="login.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	// login.jsp 에서 input의 name값을 받아옴
	
	UserDBBean manager = UserDBBean.getInstance();
	// getInstance() 메서드를 통해서 manager 객체 생성

	int check = manager.userCheck(id, pwd);
	UserBean ur = manager.getUser(id);
	// 아이디가 일치하는 멤버의 정보를 mb객체에 저장
	
	if(ur == null) {
%>
	<script>
		alert("존재하지 않는 회원");
		history.go(-1);
	</script>
<%
	} else {
		// ur객체의 name을 받아서, String name으로 대입한다. 
		String name = ur.getUser_name();
		
		if(check == 1) {
			// session 을 넘겨서, main에서 출력한다.
			// main.jsp 로 이동하기 전에, session에 추가한다.
			session.setAttribute("user_id", id);
			session.setAttribute("user_name", name);
			session.setAttribute("user", "yes");
			// 임의로 user일 경우 "yes"값을 준다. URL로만 로그인하는 것을 막기 위해서이다.
			response.sendRedirect("main.jsp");			
		}else if(check == 0){
%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
<%
		}else{
%>
		<script>
			alert("아이디가 맞지 않습니다.");
			history.go(-1);
		</script>	
<%
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOK</title>
</head>
<body>

</body>
</html>