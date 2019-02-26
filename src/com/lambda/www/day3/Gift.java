package com.lambda.www.day3;

public class Gift {
	private User user;
	private Superise giftLevel;
	
	public Gift(User user,Superise giftLevel) {
		this.user = user;
		this.giftLevel = giftLevel;
	}
	
	public  enum Superise{
		SUPER,MIDDEL,NORMAL
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Superise getGiftLevel() {
		return giftLevel;
	}

	public void setGiftLevel(Superise giftLevel) {
		this.giftLevel = giftLevel;
	}
	
	
}
