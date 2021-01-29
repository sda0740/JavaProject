package Naver;

import java.util.Scanner;

public class NaverMain2 {

	public static void main(String[] args) {

		// SQL 문을 실행하기위한 객체선언
		NaverDAO2 server = new NaverDAO2();

		// id 클래스
		NaverDTO naver = new NaverDTO();

		// 정보를 입력받기위한 sc 객체 선어
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int menu = 0;

		while (run) {
			System.out.println("==========================");
			System.out.println("1.DB접속                    2.DB해제");
			System.out.println("3.회원가입                   4.회원목록");
			System.out.println("5.정보수정                   6.회원탈퇴");
			System.out.println("7. 종료");
			System.out.println("==========================");
			System.out.print("항목선택 >> ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				server.connect();
				break;
			case 2:
				server.conClose();
				break;
			case 3:
				System.out.println("회원정보를 입력해 주세요");
				System.out.println("아이디 >> ");
				String nid = sc.next();
				naver.setNid(nid);
				System.out.println("비밀번호 >> ");
				String npw = sc.next();

				System.out.println("비밀번호확인 >> ");
				String npwc = sc.next();

				if (npw.equals(npwc)) {
					System.out.println("사용가능한 비밀번호");
					naver.setNpass(npw);
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}

				System.out.println("이름 >> ");
				String nname = sc.next();
				naver.setNname(nname);

				System.out.println("생년월일 ");
				System.out.println("년도 >> ");
				String nyear = sc.next();

				System.out.println("월 >> ");
				String nmon = sc.next();

				System.out.println("일 >> ");
				String nday = sc.next();

				System.out.println("생년월일 확인 : " + nyear + nmon + nday);
				naver.setNbir(nyear);

				System.out.println("성별 >>");
				String ngen = sc.next();
				naver.setNsex(ngen);

				System.out.println("이메일 >>");
				String nemail = sc.next();
				naver.setNmail(nemail);

				System.out.println("휴대전화 >>");
				String nphone = sc.next();
				naver.setNnum(nphone);

				server.memberJoin(naver);

				break;
			case 4:
				server.memberList();

				break;
			case 5:

				System.out.println("수정할 회원 아이디 >> ");
				nid = sc.next();
				naver.setNid(nid);

				System.out.println("비밀번호 >> ");
				npw = sc.next();

				System.out.println("비밀번호확인 >> ");
				npwc = sc.next();

				if (npw.equals(npwc)) {
					System.out.println("사용가능한 비밀번호");
					naver.setNpass(npw);
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}

				System.out.println("이름 >> ");
				nname = sc.next();
				naver.setNname(nname);

				System.out.println("생년월일 ");
				System.out.println("년도 >> ");
				nyear = sc.next();

				System.out.println("월 >> ");
				nmon = sc.next();

				System.out.println("일 >> ");
				nday = sc.next();

				System.out.println("생년월일 확인 : " + nyear + nmon + nday);
				naver.setNbir(nyear + nmon + nday);

				System.out.println("성별 >>");
				ngen = sc.next();
				naver.setNsex(ngen);

				System.out.println("이메일 >>");
				nemail = sc.next();
				naver.setNmail(nemail);

				System.out.println("휴대전화 >>");
				nphone = sc.next();
				naver.setNnum(nphone);

				server.memberModify(naver);

				break;
			case 6:
				System.out.println("삭제할 회원아이디 조회!");

				System.out.println("삭제할 아이디>>");
				String dId = sc.next();

				System.out.println("비밀번호 >>");
				String dPw = sc.next();

				boolean check = server.idCheck(dId, dPw);
				// boolean 타이븨 변수 check선언
				// server(NaverDAO)에서 dId와 dPw의 정보를 다은
				// boolean 타입의 메소드 idCheck

				if (check) {
					server.memberDelete(dId);
				} else {

					System.out.println("아이디와 비밀번호가 일치하지 않습니다");
				}

				break;
			case 7:
				run = false;
				break;
			default:
				System.out.println("다시 입력하세요 !");
				break;

			}// end switch

		} // end while

	}// end main

}
