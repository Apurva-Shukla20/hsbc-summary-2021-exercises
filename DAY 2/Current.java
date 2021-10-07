package com.example;

import java.util.Scanner;

public class Current extends Account {
	private String nomineeName;

	public Current(long accountNum, int balance, String ifsc, String nomineeName) {
		super(accountNum, balance, ifsc);
		this.nomineeName = nomineeName;
	}

	public void display() {
		System.out.println("\n");
		super.display();
		System.out.println("Nominee Name-" + nomineeName);

	}
}
