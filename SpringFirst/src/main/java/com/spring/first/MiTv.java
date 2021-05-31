package com.spring.first;

public class MiTv {
	private Speaker speaker;
	
	public MiTv() {
		System.out.println("MiTv 기본 생성자");
	}
	
	public MiTv(Speaker speaker) {
		System.out.println("MiTv speaker 생성자");
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp(); 
		// 만약 MiTv() 기본생성자로 객체가 생성되어 volumeUp 메서드를 호출하면 에러가 터짐.
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
