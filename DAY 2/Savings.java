package com.example;

import java.util.Scanner;

public class Savings extends Account {
	private int dailyLimit;

	public Savings(long accountNum, int balance, String ifsc, int dailyLimit) {
		super(accountNum, balance, ifsc);
		this.dailyLimit = dailyLimit;
	}

	public void display() {
		System.out.println("\n");
		super.display();
		System.out.println("Savings Daily Limit- " + dailyLimit);
	}
}
