<%@page import="java.io.File"%>
<%@page import="semiProject.uploadProduct.ProductBean"%>
<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pageNum = request.getParameter("pageNum");

	int product_number = Integer.parseInt(request.getParameter("product_number"));
	System.out.print("num===============>"+product_number);
	ProductDBBean updb = ProductDBBean.getInstance();
	ProductBean upbd = updb.getImg(product_number);
	String fname = upbd.getStored_file_name();
	
	String file_folder = "C:\\jsp_project\\semiProject\\WebContent\\img";
	
	int re = updb.deleteProduct(product_number);
	System.out.print("re ======= >"+re);
	
	if(re == 1) {
		response.sendRedirect("myUploadProduct_List.jsp?pageNum="+pageNum);
	%>
		<script type="text/javascript">
			alert("�����ƽ��ϴ�.");
		</script>
	<%		
		if(fname != null) {//���ε� ���� ����
			File file = new File(file_folder+fname);  //������ �Ű�����: �������+�����̸�
			file.delete();//���� �����ϴ� �ڵ�
		}
	}
%>