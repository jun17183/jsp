package com.koreait.board4.board;

public class BoardVO {
	private String title;
	private String ctnt;
	private int iboard;
	private String regdt;
	private int iuser;
	
	private String unm;	// selectBoardList 때문에 어쩔 수 없이 만들어줌. 나중에는 VO 하나 말고 여러 개를 만들거기에 이런 일 없음ㄴ
	
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	
	
}
