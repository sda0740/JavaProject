package BANK;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {

		// BankDTO의 정보를 담는 client객체 선언
		BankDTO client = new BankDTO();

		// BankDAO의 정보를 담는 server객체 선언
		BankDAO server = new BankDAO();

		// 입력을 위한 sc 객체 선언
		Scanner sc = new Scanner(System.in);

		// 프로그램 실행을 위한 변수run 선언
		boolean run = true;

		// 항목을 선택할 때 필요한 변수 menu 선언
		int menu = 0;

		System.out.println("ICIA은행에 오신것을 환영합니다!");
		System.out.println("원하시는 메뉴를 선택해주세요");
		// while문을 사용하여 프로그램 실행
		while (run) {
			System.out.println("=========================");
			System.out.println("1.계좌생성         2.입금");
			System.out.println("3.출금              4.잔액조회");
			System.out.println("5.송금              6.종료");
			System.out.println("=========================");
			System.out.println("메뉴선택");
			menu = sc.nextInt();
			server.connect();
			switch (menu) {
			case 1:
				int clientNumber = server.clientNumber() + 1;

				System.out.println("회원정보를 입력해 주세요!");
				System.out.println("회원이름 >>");
				String cName = sc.next();

				System.out.println("계좌번호>>");
				String accountNumber = sc.next();

				System.out.println("초기 입금액 >>");
				int balance = sc.nextInt();

				client = new BankDTO(clientNumber, cName, accountNumber, balance);

				server.insertClient(client);

				break;
			case 2:
				System.out.println("계좌번호>>");
				accountNumber = sc.next();

				System.out.println("입금액 >>");
				balance = sc.nextInt();

				// client에 입력한 정보 저장하기
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);

				// (1) BankDTO(client)정보를 모두 넘긴다
				server.deposit(client);

				// (2) accountNumber(계좌번호)와balance(입금액)정보만 넘긴다.
				// server.deposit(accountNumber,balance);

				break;
			case 3:

				// 잔액조회를 사용해서
				// 출금액이 잔액보다 많을경우 출금하지 못하도록
				System.out.println("계좌번호>>");
				accountNumber = sc.next();

				System.out.println("출금액 >>");
				balance = sc.nextInt();

				// (1) BankDTO(client)정보를 모두 넘긴다
				// server.withdraw(client);
				// client에 입력한 정보 저장하기
				// client.setAccountNumber(accountNumber);
				// client.setBalance(balance);

				// (2) accountNumber(계좌번호)와balance(입금액)정보만 넘긴다.

				/*
				 * if (balance > server.checkBalance(accountNumber)) {
				 * System.out.println("잔액이 부족합니다 "); System.out.println("확인후 다시 입력해 주세요");
				 * break; }else { server.withdraw(accountNumber,balance);
				 * 
				 * }
				 */
				int cBalance = server.checkBalance(accountNumber);
				// cBalance는 현재 출금하고자 하는 계좌의 잔액

				if (cBalance >= balance) {
					server.withdraw(accountNumber, balance);
				} else {
					System.out.println("출금액이" + (balance - cBalance) + "원 부족합니다");
					System.out.println("현재잔액은 " + balance + "원" + "출금요청금액은 " + cBalance + "원입니다.");
				}

				break;
			case 4:
				System.out.println("계좌번호>>");
				accountNumber = sc.next();

				balance = server.checkBalance(accountNumber);

				System.out.println("잔액 조회" + balance + "원 ");

				break;
			case 5:
				// 송금할 계좌의 잔액이 송금액보다 많은지?
				// 송금받을 계좌가 있는지?

				// send account
				System.out.println("송금할 계좌번호를 입력해 주세요>>");
				String sAccountNumber = sc.next();

				// receive account
				System.out.println("송금 받을 계좌번호를 입력해 주세요>>");
				String rAccountNumber = sc.next();

				System.out.println("송금할 금액을 입력해 주세요 ");
				balance = sc.nextInt();

				// 계좌가 존재하면 true, 존재하지않으면 false
				boolean sAccount = server.checkAccount(sAccountNumber);
				boolean rAccount = server.checkAccount(rAccountNumber);

				// 송금할 계좌의 잔액이 송금액보다 많은지?
				int sBalance = server.checkBalance(sAccountNumber);

				// 1. 보내는사람계좌번호
				if (sAccount) {
					// 2.받는사람 계좌번호
					if (rAccount) {
						// 3.잔액이 송금보다 많아야된다
						if (sBalance >= balance) {
							// server 메소드실행
							server.send(sAccountNumber, rAccountNumber, balance);
						} else {
							System.out.println("송금액이" + (balance - sBalance) + "원 부족합니다");
							System.out.println("현재잔액은 " + balance + "원" + "송금요청금액은 " + sBalance + "원입니다.");
						}

					} else {
						System.out.println("받으실 분의 계좌를 확인해 주세요");
					}
				} else {
					System.out.println("보내실 분의 계좌를 확인해 주세요");
				}

				break;
			case 6:
				run = false;
				System.out.println("이용해주셔서 감사합니다.");
				break;

			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println("다시 입력해 주세요.");
				break;
			}// end switch
			server.conClose();

		} // end while

	}

}
