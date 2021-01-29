package BANK;

import java.sql.Connection; // connection 에서 인포트 한것
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {

	// DB에 접속하기위한 메소드 DBConnect()
	public static Connection DBConnect() {// 인포트 커넥션 클릭

		// DB에 접속정보 저장을 위한 Connection 변수 con 선언
		Connection con = null;

		// 접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		// 접속할 DB의 계정정보
		String user = "NAMKUNG";
		String password = "1111";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 오라클 접속이름 접속하려는 프로그램에 따라 다름
			// ojdbc6라이브러리를 현재 소스에 적용

			con = DriverManager.getConnection(url, user, password);// 빨간밑줄에서 2번째꺼
			// con = DriverManager.getConnection(url"jdbc:oracle:thin:@localhost:1521:XE"
			// ,user"NAMKUNG",password"1111");이것과 같이 직접입력도 가능하지만
			// con 은 실제 DB와 java를 연결해주는 역할!

			System.out.println("DB접속성공!");

		} catch (ClassNotFoundException cne) {// 맨마지막 cne는 e에서 변경함
			cne.printStackTrace();
			System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
		} catch (SQLException se) {// 마지막 se는 e에서 변경함
			se.printStackTrace();
			System.out.println("DB접속 실패 : 계정정보 확인!");
		}
		// printStackTrace() : 에러 발생시 경로를 찾아준다.

		// DB접속이 정상적으로 되면 접속상태(con)를 리턴해준다.
		return con;
// 리턴값이 필요하기때문에 DBConnect에서 return을 불러드림 현재 리턴값을 모르기 때문에 null값으로 입력 

	}

}
