package Naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc0120.DBCon;

public class NaverDAO {

	// DB접속을 위한 변수 con 선언
	Connection con = null;

	// 쿼리문 전송을 위한 변수 선언
	Statement stmt = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : ?를 문자로 인식!

	// 조회(select) 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;

	// DB 접속을 위한 메소드
	public void connect() {
		con = DBCon.DBConnect();
		// DBCon클래스의 DBConncet()메소드의 리턴값(con)을
		// con 에 담겠다.
	}

	// DB접속 해제 : con.close(); 생성후 try carch문 생성
	public void conClose() {
		try {
			con.close();
			System.out.println("DB접속 해제!");
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void insert(NaverDTO id) {
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";
		System.out.println("아이디 정보 : " + id);
		System.out.println("DB연결 : " + con);

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id.getNid());
			pstmt.setString(2, id.getNpass());
			pstmt.setString(3, id.getNname());
			pstmt.setString(4, id.getNbir());
			pstmt.setString(5, id.getNsex());
			pstmt.setString(6, id.getNmail());
			pstmt.setString(7, id.getNnum());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("정보입력 성공 ");
			} else {
				System.out.println("정보입력 실패 ");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}

	}

	public void select() {
		String sql = "SELECT * FROM NAVER";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i = 1;
			while (rs.next()) {// 조회된 데이터의 갯수만큼 반복문 실행
				// Cardinality(Tuple,Record) 데이터의 수
				System.out.println(i + "번째 회원 정보 ");
				System.out.println("아이디 : " + rs.getString(1)); // 타입에따라 String
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 :" + rs.getString(3));
				System.out.println("생일 :" + rs.getString(4));
				System.out.println("성별 :" + rs.getString(5));
				System.out.println("메일 :" + rs.getString(6));
				System.out.println("전화번호 :" + rs.getString(7));// 타입에따라 int
				System.out.println();
				i++;
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}

	}

	public void update(NaverDTO id) {
		
		String sql = "UPDATE NAVER SET NPASS=? WHERE NID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id.getNpass());
			pstmt.setString(2, id.getNid());
			
			System.out.println("ID :" +  id.getNid()); // ID가 들어갔는지 확인
			System.out.println("PW :" + id.getNpass() ); // 비밀번호가 들어갔는지 확인
			
			int count = pstmt.executeUpdate();
			
			System.out.println("COUNT : "  + count); // 카운트에 숫자가 들어갔는지 확인
			
			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update2(NaverDTO id2) {
		String sql = "UPDATE NAVER SET NNAME=?  WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id2.getNpass());
			pstmt.setString(2, id2.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update3(NaverDTO id3) {
		String sql = "UPDATE NAVER SET NBIR=? " + "WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id3.getNpass());
			pstmt.setString(2, id3.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update4(NaverDTO id4) {
		String sql = "UPDATE NAVER SET NSEX=? " + "WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id4.getNpass());
			pstmt.setString(2, id4.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update5(NaverDTO id5) {
		String sql = "UPDATE NAVER SET NMAIL=? " + "WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id5.getNpass());
			pstmt.setString(2, id5.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update6(NaverDTO id6) {
		String sql = "UPDATE NAVER SET NNUM=? " + "WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id6.getNpass());
			pstmt.setString(2, id6.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	public void update7(NaverDTO id7) {
		String sql = "UPDATE NAVER SET NID=? " + "WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id7.getNpass());
			pstmt.setString(2, id7.getNid());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("회원정보 수정성공 ");
			} else {
				System.out.println("회원정보 수정실패 ");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	
	public void delete(String nID) {
		String sql = "DELETE NAVER WHERE NID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nID);

			int count = pstmt.executeUpdate();

			System.out.println("count 결과 :" + count);

			if (count > 0) {
				System.out.println(count + "회원정보 삭제 성공");
			} else {
				System.out.println("회원정보 삭제 실패");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}

	}

}
