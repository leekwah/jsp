<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<section class="mypage_content">
		<div class="my_main_title_box">
			<h2 class="tit">ȸ��Ż��</h2>
		</div>
			<hr>
		<div class="my_top_comment">
			���Բ��� ȸ�� Ż�� ���ϽŴٴ� ���� ���񽺰� ���� �����ϰ� �����߳� ���ϴ�.<br>
			�����ϼ̴� ���̳� �Ҹ������� �˷��ֽø� ���� �ݿ��ؼ� ������ �������� �ذ��� �帮���� ����ϰڽ��ϴ�.<br>
			�ƿ﷯ ȸ�� Ż����� �Ʒ� ������ �����Ͻñ� �ٶ��ϴ�.<br><br>
		
			ȸ�� Ż�� �� ������ ������ ��ǰ ��ǰ �� A/S�� ���� ���ڻ�ŷ� ����� �Һ��� ��ȣ�� ���� ������ �ǰ��� 4xr ������ ��ȣ��å������ ���� �˴ϴ�.<br>
			Ż�� �� ���Բ��� �����ϼ̴� ���ϸ����� ��� �����Ǹ�, �ѹ� Ż���� ���̵�� �ٽ� ��� �Ұ����մϴ�.<br><br>
			ȸ�� Ż�� �� Ż�� �� ���� �簡���� �Ұ����մϴ�.
		</div>
		<hr>
		<form name="outform" id="outform" action="/mypage/memout.php" method="post">
			<input type="hidden" name="mode" value="w">
			<input type="hidden" name="memid" value="lhs1000j">
			<input type="hidden" name="is_social_id" value="N">
			<input type="hidden" name="check1" value="1663305350">
			<input type="hidden" name="check2" value="f7160b0caa3f7e15f5ee5a4e0d6ef9a8">
	<section class="mem_table">
		<table cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="260px">
				<col>
			</colgroup>
		<tbody>
			<tr>
				<th scope="row" class="top"><strong>�����ߴ� ���� �����ּ��� (����)</strong></th>
				<td class="field2">
					<textarea name="memo" style="height:200px;" placeholder="������ �Է����ּ���"></textarea>
				</td>
			</tr>
			<tr>
				<th scope="row" class="top"><strong>��й�ȣ �Է�</strong></th>
				<td class="field2">
					<input style="width:296px;" type="password" value="" name="passwd" maxlength="20" onkeyup="check_pwd_length(this, 'passwd');">
					<input type="hidden" name="passwd_enc" value="">
				</td>
			</tr>
			<tr>
				<th scope="row" class="top"><strong>��й�ȣ Ȯ��</strong></th>
				<td class="field2">
				<input style="width:296px;" type="password" value="" name="repasswd" maxlength="20" onkeyup="check_pwd_length(this, 'repasswd');">
				</td>
			</tr>
		</tbody>
	</table>
	</section>
			<div class="withdrawal_btn_box"><hr>
				<div class="agree">
					<label class="checkbox style_01 size"><input type="checkbox" name="is_memout_agreement">
						<span>
							�ȳ������� ��� Ȯ���Ͽ�����, �̿� �����մϴ�.
						</span>
					</label>
				</div>
					<a href="main.jsp" class="btn_ty1">���</a>
					<a href="main.jsp" class="btn_ty2" id="btn_memout_confirm">ȸ�� Ż��</a>
			</div>
		</form>
	</section>
</body>
</html>