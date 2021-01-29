package BANK;

import java.sql.*; //java.sql.*Connection;Connection부분을 *로 변경하면 나머지 import

import jdbc0120.DBCon;

public class BankDAO {

	// DB접속을 위한 변수 선언
	Connection conn = null;

	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;

	// 조회결과를 저장하기위한 변수 선언
	ResultSet rs = null;

	// DB 접속을 위한 메소드
	public void connect() {
		conn = DBCon.DBConnect();

	}

	// DB 종료를 위한 메소드
	public void conClose() {
		try {
			conn.close();
			System.out.println("DB접속 해제!");
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 고객번호를 생성하기위한 메소드 clientNumber()
	public int clientNumber() {

		String sql = "SELECT COUNT(*) FROM BANK";
		int cNumber = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cNumber = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cNumber;
	}

	// 고객정보를 저장하기 위한 메소드insertClient()
	public void insertClient(BankDTO client) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, client.getClientNumber());
			pstmt.setString(2, client.getcName());
			pstmt.setString(3, client.getAccountNumber());
			pstmt.setInt(4, client.getBalance());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("고객 등록 성공!");
			} else {
				System.out.println("고객 등록 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 입금메소드 deposit()
	public void deposit(BankDTO client) {

		String sql = "UPDATE BANK SET BALANCE = BALANCE " + "+? WHERE ACCOUNTNUMBER = ?  ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getBalance());
			pstmt.setString(2, client.getAccountNumber());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("입금성공");
			} else {
				System.out.println("입금실패..");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void withdraw(String accountNumber, int balance) {

		String sql = "UPDATE BANK SET BALANCE = BALANCE " + "-? WHERE ACCOUNTNUMBER = ?  ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("출금성공");
			} else {
				System.out.println("출금실패..");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// TODO Auto-generated method stub
	public int checkBalance(String accountNumber) {
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNUMBER = ?";

		int balance = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				balance = rs.getInt(1);// 첫번째 컬럼을 가지고 오겠다.
				// balance = rs.getInt("balance"); // 벨런스컬럼을 가지고 오겠다.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}

	// 계좌 조회를 하는 메소드checkAccount()

	// accountNumber = sAccountNumber;
	// accountNumber = rAccountNumber;
	public boolean checkAccount(String accountNumber) {
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER=?";
		boolean cAccount = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery();// SELECT 문이 들어가면 rs가 필요하다.

			if (rs.next()) {
				cAccount = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cAccount;
	}

	// 송금메소드 send()
	// 보내는사람 계좌번호, 받는사람 계좌번호, 송금액의 정보를 매개변수로 담아서 넘어옴
	public void send(String sAccountNumber, String rAccountNumber, int balance) {
		// 받는사람은 돈이 + :입금
		// 보내는사람은 돈이-:출금
		withdraw1(sAccountNumber, balance);
		deposit1(rAccountNumber, balance);
		System.out.println("송금 성공!");

	}

	public void withdraw1(String accountNumber, int balance) {

		String sql = "UPDATE BANK SET BALANCE = BALANCE -? WHERE ACCOUNTNUMBER = ?  ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void deposit1(String accountNumber, int balance) {

		String sql = "UPDATE BANK SET BALANCE = BALANCE +? WHERE ACCOUNTNUMBER = ?  ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	
	
	
}
