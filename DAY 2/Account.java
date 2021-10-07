package com.example;

import java.util.Scanner;

public class Account {
	private long accountNum;
	private int balance;
	private String ifsc;

	public Account(long accountNum, int balance, String ifsc) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.ifsc = ifsc;
	}

	public void display() {
		System.out.println("Account Number- " + accountNum + "\n" + "Balance- " + balance + "\n" + "IFSC Code-" + ifsc);
	}
}