package com.example;

import java.util.Scanner;
import com.example.Account;
import com.example.Current;
import com.example.Savings;

public class AccountsMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account number -");
		long accountNum = sc.nextLong();
		System.out.println("Enter balance-");
		int balance = sc.nextInt();
		System.out.println("Enter IFSC Code-");
		String ifsc = sc.next();
		System.out.println("Enter Nominee Name-");
		String nomineeName = sc.next();
		System.out.println("Enter Daily Limit-");
		int dailyLimit = sc.nextInt();

		Account acc = new Account(accountNum, balance, ifsc);
		Savings sav = new Savings(accountNum, balance, ifsc, dailyLimit);
		Current curr = new Current(accountNum, balance, ifsc, nomineeName);
		acc.display();
		sav.display();
		curr.display();

		Account acc1 = new Savings(accountNum, balance, ifsc, dailyLimit);
		Account acc2 = new Current(accountNum, balance, ifsc, nomineeName);
		Savings sav1 = (Savings) acc1;
		Current curr1 = (Current) acc2;

		getDisplay(sav1, curr1);
	}

	public static void getDisplay(Savings s, Current c) {
		Savings save = s;
		Current cur = c;
		save.display();
		cur.display();
	}
}