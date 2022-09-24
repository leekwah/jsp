package login;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();

	public static MemberDBBean getInstance() {
		// ���� �Է¹޴� �޼ҵ�
		return instance; // BoardDBBean�� ��ü�� �Է¹���.

	}

	public static Connection getConnection() throws Exception {
		// �����۾� ����� Connection��ü �����ϴ� �޼ҵ�
		// ���θ��� ���� -> ������ ����ϱ� ���ؼ�

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	// ���� ���� �޼ҵ�
	public static int register(MemberBean member) throws Exception {
        //���� �߰��ϴ� �޼ҵ�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "";
		int re = -1;
		
		try {
			sql = "insert into user_table values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			//pstmt�� ����
			pstmt.setString(1, member.getUser_id()); //�߰� 
			pstmt.setString(2, member.getUser_pwd()); //�߰� 
			pstmt.setString(3, member.getUser_name()); //�߰� 
			pstmt.setString(4, member.getUser_phone1()); //�߰� 
			pstmt.setString(5, member.getUser_phone2()); //�߰� 
			pstmt.setString(6, member.getUser_phone3()); //�߰� 
			pstmt.setString(7, member.getUser_email()); //�߰� 
			pstmt.setString(8, member.getUser_pcode()); //�߰� 
			pstmt.setString(9, member.getUser_raddr()); //�߰� 
			pstmt.setString(10, member.getUser_jibun()); //�߰� 
			pstmt.setString(11, member.getUser_detailaddr()); //�߰� 
			pstmt.setInt(12, member.getUser_grade()); //�߰� 
			pstmt.setTimestamp(13, member.getUser_regdate()); //�߰� 
			pstmt.executeUpdate();
			System.out.println("ȸ������ ����");
			re = 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ ����");
			re=-1;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("member.getUser_id()====>>" +member.getUser_id());
		System.out.println("member.getUser_pwd()====>>" +member.getUser_pwd());
		System.out.println("member.getUser_name()====>>" +member.getUser_name());
		System.out.println("member.getUser_phone1()====>>" +member.getUser_phone1());
		System.out.println("member.getUser_phone2()====>>" +member.getUser_phone2());
		System.out.println("member.getUser_phone3()====>>" +member.getUser_phone3());
		System.out.println("member.getUser_email()====>>" +member.getUser_email());
		System.out.println("member.getUser_addr()====>>" +member.getUser_pcode());
		System.out.println("member.getUser_addr()====>>" +member.getUser_raddr());
		System.out.println("member.getUser_addr()====>>" +member.getUser_jibun());
		System.out.println("member.getUser_addr()====>>" +member.getUser_detailaddr());
		System.out.println("member.getUser_grade()====>>" +member.getUser_grade());
		System.out.println("member.getUser_regdate()====>>" +member.getUser_regdate());
		return re;
	}
	public int confirmID(String id) throws Exception{
		//�ߺ�Ȯ���� ���� �޼ҵ�
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re= -1;
		String sql = "select user_id from user_table where user_id =?";
		//�Ķ���Ͱ��� ?�� ����.
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //sql�� �����.
		
			if(rs.next()) {
				re =1;
			}
			else {
				re = -1;
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return re;
	}
	
	public MemberBean getMember(String id) throws Exception{
		//���̵� ��ġ�ϴ� ����� ������ ������ �޼ҵ�
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_table where user_id=?";
		MemberBean member = null;
		
		try {	con = getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member = new MemberBean();
			// �α����Ҷ� �Է��ϴ� ���̵� bean�� �־��� 
			member.setUser_id(rs.getString("user_id"));  
			member.setUser_pwd(rs.getString("user_pwd"));  
			member.setUser_name(rs.getString("user_name"));  
			member.setUser_phone1(rs.getString("user_phone1"));  
			member.setUser_phone2(rs.getString("user_phone2"));  
			member.setUser_phone3(rs.getString("user_phone3"));  
			member.setUser_email(rs.getString("user_email"));  
			member.setUser_pcode(rs.getString("user_pcode"));  
			member.setUser_raddr(rs.getString("user_raddr"));  
			member.setUser_jibun(rs.getString("user_jibun"));  
			member.setUser_detailaddr(rs.getString("user_detailaddr"));  
			member.setUser_grade(rs.getInt("user_grade"));  
			member.setUser_regdate(rs.getTimestamp("user_regdate"));
		}
		rs.close();
		pstmt.close();
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	 public int userCheck(String id, String pwd) throws Exception {
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  String sql = "select user_pwd from user_table where user_id = ?";
		  String db_user_pwd;
		  int re = -1;

		  try {
		   con = getConnection();
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();

		   if(rs.next()) {
		    db_user_pwd = rs.getString("user_pwd");
		    
		    if (db_user_pwd.equals(pwd))
		     re = -1;
		    else
		     re = 0;
		     
		   } else {
		    re = -1;
		   }
		  } catch(Exception e) {
		   System.out.println(e.getMessage()); 
		  }

		  rs.close();
		  pstmt.close();
		  con.close();

		  return re;
		 }
	 
	 public String findId(String user_name, String user_phone1, String user_phone2, String user_phone3)throws Exception {
					
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				
				System.out.println("user_name ====>"+user_name);
				System.out.println("user_phone1 ====>"+user_phone1);
				System.out.println("user_phone2 ====>"+user_phone2);
				System.out.println("user_phone3 ====>"+user_phone3);
				String sql = "SELECT USER_ID FROM USER_TABLE \r\n" + 
						"WHERE USER_NAME = ? and user_phone1 =? and user_phone2 =? and user_phone3 =?";
				String re="";
				try {	
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				pstmt.setString(2, user_phone1);
				pstmt.setString(3, user_phone2);
				pstmt.setString(4, user_phone3);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					re = rs.getString("user_id");
				} else {
					re = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null) rs.close(); 		
				if (pstmt!=null) pstmt.close(); 		
				if (con!=null) con.close(); 		
				
			}
			return re;
	 }
	 
	 public int updateMember(MemberBean member) throws Exception {
			int re=-1;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="UPDATE USER_TABLE SET \r\n" + 
					"                      USER_NAME=?, \r\n" + 
					"                      USER_PHONE1=?, USER_PHONE2=?, USER_PHONE3=?,\r\n" + 
					"                      USER_EMAIL=?,\r\n" + 
					"                      USER_PCODE=?, USER_RADDR=?, USER_JIBUN=?, USER_DETAILADDR=?\r\n" + 
					"                      WHERE USER_ID=? AND USER_PWD=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				System.out.println("@@@### member.getMem_name() ===>"+member.getUser_name());
				System.out.println("@@@### member.getMem_phone1() ===>"+member.getUser_phone1());
				System.out.println("@@@### member.getMem_phone2() ===>"+member.getUser_phone2());
				System.out.println("@@@### member.getMem_phone3() ===>"+member.getUser_phone3());
				System.out.println("@@@### member.getMem_email() ===>"+member.getUser_email());
				System.out.println("@@@### member.getMem_pcode() ===>"+member.getUser_pcode());
				System.out.println("@@@### member.getMem_raddr() ===>"+member.getUser_raddr());
				System.out.println("@@@### member.getMem_jibun() ===>"+member.getUser_jibun());
				System.out.println("@@@### member.getMem_detailaddr() ===>"+member.getUser_detailaddr());
				System.out.println("@@@### member.getMem_id() ===>"+member.getUser_id());
				System.out.println("@@@### member.getMem_pwd() ===>"+member.getUser_pwd());
				
				pstmt.setString(1, member.getUser_name());
				pstmt.setString(2, member.getUser_phone1());
				pstmt.setString(3, member.getUser_phone2());
				pstmt.setString(4, member.getUser_phone3());
				pstmt.setString(5, member.getUser_email());
				pstmt.setString(6, member.getUser_pcode());
				pstmt.setString(7, member.getUser_raddr());
				pstmt.setString(8, member.getUser_jibun());
				pstmt.setString(9, member.getUser_detailaddr());
				pstmt.setString(10, member.getUser_id());
				pstmt.setString(11, member.getUser_pwd());
				
				re = pstmt.executeUpdate();
				re = 1;
				System.out.println("@@@### re ===>"+re);
			}catch(SQLException ex){
				System.out.println("��������");
				ex.printStackTrace();
			}finally{
				try{
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			return re;
		}
	 
	 public String getRamdomPassword(int size) {
	        char[] charSet = new char[] {
	                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	                '!', '@', '#', '$', '%', '^', '&' };

	        StringBuffer sb = new StringBuffer();
	        SecureRandom sr = new SecureRandom();
	        sr.setSeed(new Date().getTime());

	        int idx = 0;
	        int len = charSet.length;
	        for (int i=0; i<size; i++) {
	            // idx = (int) (len * Math.random());
	            idx = sr.nextInt(len);    // ������ ������ �߻���Ű�� ���� SecureRandom�� ����Ѵ�.
	            sb.append(charSet[idx]);
	        }

	        return sb.toString();
	    }
	 
//	 public int pwUpdateMember(String user_id, String user_name, String user_email) throws Exception {
//			int re=-1;
//			Connection conn=null;
//			PreparedStatement pstmt=null;
//			String sql="UPDATE USER_TABLE SET USER_PWD=? \r\n" + 
//					"                      WHERE USER_ID =? AND USER_NAME=? AND USER_EMAIL=?";
//			
//			try {
//				conn = getConnection();
//				pstmt = conn.prepareStatement(sql);
//				System.out.println("@@@### member.getMem_name() ===>"+member.getUser_name());
//				System.out.println("@@@### member.getMem_phone1() ===>"+member.getUser_phone1());
//				System.out.println("@@@### member.getMem_phone2() ===>"+member.getUser_phone2());
//				System.out.println("@@@### member.getMem_phone3() ===>"+member.getUser_phone3());
//				System.out.println("@@@### member.getMem_email() ===>"+member.getUser_email());
//				System.out.println("@@@### member.getMem_pcode() ===>"+member.getUser_pcode());
//				System.out.println("@@@### member.getMem_raddr() ===>"+member.getUser_raddr());
//				System.out.println("@@@### member.getMem_jibun() ===>"+member.getUser_jibun());
//				System.out.println("@@@### member.getMem_detailaddr() ===>"+member.getUser_detailaddr());
//				System.out.println("@@@### member.getMem_id() ===>"+member.getUser_id());
//				System.out.println("@@@### member.getMem_pwd() ===>"+member.getUser_pwd());
//				
//				pstmt.setString(1, member.getUser_name());
//				pstmt.setString(2, member.getUser_phone1());
//				pstmt.setString(3, member.getUser_phone2());
//				pstmt.setString(4, member.getUser_phone3());
//				pstmt.setString(5, member.getUser_email());
//				pstmt.setString(6, member.getUser_pcode());
//				pstmt.setString(7, member.getUser_raddr());
//				pstmt.setString(8, member.getUser_jibun());
//				pstmt.setString(9, member.getUser_detailaddr());
//				pstmt.setString(10, member.getUser_id());
//				pstmt.setString(11, member.getUser_pwd());
//				
//				re = pstmt.executeUpdate();
//				re = 1;
//				System.out.println("@@@### re ===>"+re);
//			}catch(SQLException ex){
//				System.out.println("��������");
//				ex.printStackTrace();
//			}finally{
//				try{
//					if(pstmt != null) pstmt.close();
//					if(conn != null) conn.close();
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//			
//			return re;
//		}
	 
}
