package Naver;

public class NaverDTO {

	private String Nid;
	private String Npass;
	private String Nname;
	private String Nbir;
	private String Nsex;
	private String Nmail;
	private String Nnum;

	/// get set
	public String getNid() {
		return Nid;
	}

	public void setNid(String nid) {
		Nid = nid;
	}

	public String getNpass() {
		return Npass;
	}

	public void setNpass(String npass) {
		Npass = npass;
	}

	public String getNname() {
		return Nname;
	}

	public void setNname(String nname) {
		Nname = nname;
	}

	public String getNbir() {
		return Nbir;
	}

	public void setNbir(String nbir) {
		Nbir = nbir;
	}

	public String getNsex() {
		return Nsex;
	}

	public void setNsex(String nsex) {
		Nsex = nsex;
	}

	public String getNmail() {
		return Nmail;
	}

	public void setNmail(String nmail) {
		Nmail = nmail;
	}

	public String getNnum() {
		return Nnum;
	}

	public void setNnum(String nnum) {
		Nnum = nnum;
	}

	//

	@Override
	public String toString() {
		return "NaverDTO [Nid=" + Nid + ", Npass=" + Npass + ", Nname=" + Nname + ", Nbir=" + Nbir + ", Nsex=" + Nsex
				+ ", Nmail=" + Nmail + ", Nnum=" + Nnum + "]";
	}

	// 기본 생성자

	public NaverDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 생성자
	public NaverDTO(String nid, String npass, String nname, String nbir, String nsex, String nmail, String nnum) {
		super();
		Nid = nid;
		Npass = npass;
		Nname = nname;
		Nbir = nbir;
		Nsex = nsex;
		Nmail = nmail;
		Nnum = nnum;
	}

	// 기본 생성자

}
