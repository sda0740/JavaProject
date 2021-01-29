package Naver;

import java.util.Scanner;

public class NaverMain {
	// 프론트엔드, 나중에 웹페이지로 대체
	public static void main(String[] args) {

		// SQL 문을 실행하기위한 객체선언
		NaverDAO sql = new NaverDAO();

		// id 클래스
		NaverDTO id = new NaverDTO();

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
				sql.connect();

				break;
			case 2:
				sql.conClose();
				break;
			case 3:
				System.out.println("회원정보를 입력해 주세요!");

				System.out.println("ID >>");
				String Nid = sc.next();

				System.out.println("비밀번호 >>");
				String Npass = sc.next();

				System.out.println("이름 >>");
				String Nname = sc.next();

				System.out.println("생년월일 >>");
				String Nbir = sc.next();

				System.out.println("성별 >>");
				String Nsex = sc.next();

				System.out.println("이메일 >>");
				String Nmail = sc.next();

				System.out.println("휴대전화 >>");
				String Nnum = sc.next();

				id.setNid(Nid);
				id.setNpass(Npass);
				id.setNname(Nname);
				id.setNbir(Nbir);
				id.setNsex(Nsex);
				id.setNmail(Nmail);
				id.setNnum(Nnum);

				sql.insert(id);
				break;
			case 4:
				sql.select();

				break;
			case 5:
				System.out.println("수정할 ID를 입력해 주세요!");

				System.out.println("수정할 ID >>");
				Nid = sc.next();

				System.out.println("변경할 부분을 선택해 주세요");
				System.out.println("==========================");
				System.out.println("1.비밀번호            2.이름");
				System.out.println("3.생일                 4.성별");
				System.out.println("5.메일                 6.전화번호");
				System.out.println("7.ID");
				System.out.println("==========================");
				System.out.println("항목선택 >> ");
				int menu1;
				menu1 = sc.nextInt();
				switch (menu1) {
				case 1:
					System.out.println("비밀번호 >>");
					String idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update(id);
					break;
				case 2:
					System.out.println("이름 >>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update2(id);
					break;
				case 3:
					System.out.println("생일 >>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update3(id);
					break;
				case 4:
					System.out.println("성별 (2글자 까지 허용)>>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update4(id);
					break;
				case 5:
					System.out.println("메일 >>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update5(id);
					break;
				case 6:
					System.out.println("전화번호 >>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update6(id);
					break;
				case 7:
					System.out.println("ID>>");
					idNpass = sc.next();
					id.setNid(Nid);
					id.setNpass(idNpass);
					sql.update7(id);
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}

				break;
			case 6:
				System.out.println("삭제할 회원정보를 입력해 주세요!");

				System.out.println("삭제할 회원 ID >>");
				String NID = sc.next();

				sql.delete(NID);

				break;
			case 7:
				run = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다!");
				System.out.println("다시 입력해 주세요.");
				break;
			}
		}
		System.out.println("종료되었습니다");

	}

}
