<%@page import="magic.MemberDBBean"%>
<%@page import="magic.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<jsp:useBean class="magic.MemberBean" id="mb"/>
<jsp:setProperty property="*" name="mb"/>

<%	
	String uid = (String)session.getAttribute("uid");
	mb.setUSER_ID(uid);

	MemberDBBean manager = MemberDBBean.getInstance();
	
	int re = manager.updateMember(mb);
	
	if(re == 1) {
%>
	<script>
		alert("�Է��ϽŴ�� ȸ�� ������ �����Ǿ����ϴ�.");
		document.location.href="main.jsp";
	</script>
<%
	} else {
%>
	<script>
		alert("������ ���еǾ����ϴ�.");
		history.go(-1);
	</script>
<%	
	}
%>