package com.kangmin.algo.special;

class User {
	String userName;

	@Override
	public String toString() {
		return "User's userName is: " + this.userName;
	}
}

class Admin extends User{
	String role;
	int adminId;

	@Override
	public String toString() {
		return "Admin's userName is: " + this.userName + "; adminId is: " + this.adminId;
	}
}

public class TestOuterClass {

	public static void main(String[] args) {
		User u = new User();
		u.userName = "Zhang F";
		System.out.println(u);

		User ad = new Admin();
		ad.userName = "Huang";

		Admin x = (Admin) ad;
		x.adminId = 10;
		System.out.println(x);

	}

}
