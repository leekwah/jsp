<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	GoodsDBBean db = GoodsDBBean.getInstance();
	ArrayList<GoodsBean> orderList = db.listOrder(pageNum);
	
	count�����Ͽ� �� 8���� ���� ����
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="1250">
		<tr>
			<td>�ֹ���ȸ<hr></td>
		</tr>
		<tr>
			<td><a href="#">�ֹ�������ȸ(0)</a> | <a href="#">���/��ǰ/��ȯ ����(0)</a><hr></td>
			<!-- 0 �κп� ��ǰ���� (count?) �޾ƿ;��� -->
		</tr>
		<tr>
			<td>�ֹ� ��ǰ ����</td>
		</tr>
	</table>
	<table border="1" align="center">
		<tr height="60" align="center">
			<td width="150">�ֹ�����<br>[�ֹ���ȣ]</td>
			<td width="150">�̹���</td>
			<td width="500">��ǰ����</td>
			<td width="50">����</td>
			<td width="100">��ǰ���űݾ�</td>
			<td width="100">�ֹ�ó������</td>
			<td width="150">���/��ȯ/��ǰ</td>
		</tr>
		<%
//			�����ͺ��̽��� �ִ� ������ ��������
			for(int i=0; i<�ֹ�����Ʈ.size(); i++){
//				������ ����---------------------------------------------------
				OrderBean order = orderList.get(i);
				order_number = order.getOrder_number();
				... 7���� ����
		%>
				<tr height="150" align="center">
					<td><%= order_number %>�����ҷ�����</td>
					<td>�����ҷ�����</td>
					<td>�����ҷ�����</td>
					<td>�����ҷ�����</td>
					<td>�����ҷ�����</td>
					<td>�����ҷ�����</td>
					<td>�����ҷ�����</td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>