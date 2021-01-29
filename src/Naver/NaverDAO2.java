package Naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NaverDAO2 {
	// DAO (Data Access Object) : 데이터 접근 객체
	// - 백엔드 서버,Object를 사용하여 SQL을 사용할수있다.

	// DB접속을 위한 변수 con 선언
	// conn은 DB연결상태 를 뜻한다.
	Connection conn = null;

	// 쿼리문 전송을 위한 변수 pstmt 선언
	PreparedStatement pstmt = null;

	// 조회(select) 결과를 저장하기위한 변수 rs선언
	ResultSet rs = null;

	// 항목1. DB접속 메소드 connect()
	public void connect() {
		conn = DBCon.DBConnect();
		// DBCon클래스의 DBConnect()메소드의 리턴값을 저장한다.

	}

	// 항목 2. DB접속 해제메소드 conClose()
	public void conClose() {
		try {
			conn.close();
			// Connection클래스의 내장 메소드
			// close().를 사용하여 접속을 해제한다.
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	// 항목3. 회원가입 메소드 memberJoin()

	public void memberJoin(NaverDTO naver) {
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naver.getNid());
			pstmt.setString(2, naver.getNpass());
			pstmt.setString(3, naver.getNname());
			pstmt.setString(4, naver.getNbir());
			pstmt.setString(5, naver.getNsex());
			pstmt.setString(6, naver.getNmail());
			pstmt.setString(7, naver.getNnum());

			// 7개의 정보를 다 입력한 후 데이터베이스 실행
			// pstmt.executeUpdate();

			// 1. int result
			// int result = pstmt.executeUpdate();
			// int 일때에는 pstmt.executeUpdate();를 사용
			// if(result > 0) {
			// System.out.println("회원가입 성공!");
			// }else {
			// System.out.println("회원가입 실패...");
			// }

			// 2. boolean result2
			boolean result2 = pstmt.execute();
			// boolean을 사용할때에는pstmt.execute();을 사용
			System.out.println("성공여부 : " + result2);
			if (!result2) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패..");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

	}

	// 항목 4. 회원정보 조회
	public void memberList() {
		String sql = "SELECT * FROM NAVER";
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// execute, > boolean 타입으로 반환
			// executUpdate, > int 타입으로 반환
			// executeQuery > ResultSet타입 반환

			int i = 1;
			while (rs.next()) {
				System.out.println(i + "번째 회원");
				System.out.println("아이디 :" + rs.getString(1));
				System.out.println("비밀번호 :" + rs.getString(2));
				System.out.println("이름 :" + rs.getString(3));
				System.out.println("생년월일 :" + rs.getString(4));
				System.out.println("성별 :" + rs.getString(5));
				System.out.println("이메일 :" + rs.getString(6));
				System.out.println("휴대전화 :" + rs.getString(7));
				System.out.println();
				i++;
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void memberModify(NaverDTO naver) {
		String sql = "UPDATE NAVER SET NPASS=?, NNAME=?," + "NBIR=?, NSEX=?, NMAIL=?, NNUM=?" + "WHERE NID=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, naver.getNpass());
			pstmt.setString(2, naver.getNname());
			pstmt.setString(3, naver.getNbir());
			pstmt.setString(4, naver.getNsex());
			pstmt.setString(5, naver.getNmail());
			pstmt.setString(6, naver.getNnum());
			pstmt.setString(7, naver.getNid());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("회원정보 수정 성공");
			} else {
				System.out.println("회원정보 수정 실패....");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

	}

	// 항목 6-1 회원정보를 삭제하기위해
	// 아이디와 비밀번호를 검사하는메소드 idCheck()
	public boolean idCheck(String dId, String dPw) {
		String sql = "SELECT NID FROM NAVER " + "WHERE NID=? AND NPASS=?";

		boolean checkResult = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dId);
			pstmt.setString(2, dPw);

			rs = pstmt.executeQuery();

			// while(rs.next())
			// rs의 결과값이 1개 이기때문에 while이 아닌 if 를 사용
			if (rs.next()) {
				checkResult = true;
			} else {
				checkResult = false;
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

		return checkResult;
	}

	// 항목 6 회원정보를 삭제하는 메소드 memberDelete()
	public void memberDelete(String dId) {
		String sql = "DELETE NAVER WHERE NID=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dId);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원정보 삭제 성공");
			} else {
				System.out.println("회원정보 삭제 실페.....");
			}

		} catch (SQLException se) {

			se.printStackTrace();
		}

	}

	// 항목 4. 회원정보 조회

}
