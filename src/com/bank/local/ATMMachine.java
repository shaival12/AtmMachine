package com.bank.local;

import java.util.Scanner;

 
/**
 *
 *  Class for ATM 
 *  Functionality : deposit and withdrawal
 */
public class ATMMachine {
	
	 static String userName = "Tom Hank";
	 static String password = "1234";
     static String bankName = "Bank of Miami";
     static double userBalance ;
     static Denominations deno ;
     
     
     /**
      * withdraw money
      * @param bankScanner
      */
 	private static void withdraw(Scanner bankScanner) {
 		double withdrawAmount = bankScanner.nextDouble();
 		
 		if (withdrawAmount==0 || withdrawAmount<0 || withdrawAmount > userBalance) {
 		    System.out.println("Incorrect or insufficient funds. Please Try Again");
 		} else {
 		    userBalance -= withdrawAmount;
 		    System.out.println("You have successfully withdraw " + withdrawAmount
 		            + " \nNow your balance is " + userBalance);
 		    
 		    deno.deductNotes((int)withdrawAmount);
 		    showBalance();
 		}
 	}

     /**
      * deposit money
      * @param bankScanner
      */
 	private static void deposit(Scanner bankScanner) {
 		double depositAmount = bankScanner.nextDouble();
 		
 		if(depositAmount<0) {
 			 System.out.println("Incorrect deposit amount");
 		}else if(depositAmount==0) {
 			System.out.println("Deposit amount cannot be zero");
 		} else {
 		
 			userBalance += depositAmount;
 			System.out.println("You have successfully deposited " + depositAmount
 			        + " \nNow your balance is " + userBalance);
 			
 			deno.addNotes((int)depositAmount);
 			showBalance();
 		
 		}
 	}
 	
     
 
    public static void main(String[] args) {
 
    	initialize();
 
        Scanner bankScanner = new Scanner(System.in);
        System.out.println("Welcome to " + bankName);
        
        System.out.println("Please Enter Your PIN Number ");
        String enteredPassword = bankScanner.nextLine();
        
        if (enteredPassword.equalsIgnoreCase(password)) {
            System.out.println("Account Name Holder : " + userName);
            System.out.println("Please choose the following options ");
            
            int userChoice = 0;
            
            do {
               System.out.println("\n######################################");	
        	   System.out.println("1 - Show Balance , 2 - Deposit Amount , 3 - Withdraw Amount, 4 - Exit");
               userChoice = bankScanner.nextInt();
        	   userChoice(bankScanner, userChoice);
        	}
        	while (userChoice!=4);
        }
 
    }

    
   // initialize balance n denominations.
	private static void initialize() {
		userBalance = 1000;
		deno = new Denominations(0,0,0,50);
	}


	private static void userChoice(Scanner bankScanner, int userChoice) {
		if (userChoice == 1) {
		    showBalance();
		} else if (userChoice == 2) {
		    System.out.println("Please Enter The Amount To Deposit ");
		    deposit(bankScanner);
		} else if (userChoice == 3) {
		    System.out.println("Please Enter the Amount to Witdraw");
		    withdraw(bankScanner);
		}else if (userChoice == 4) {
		    System.out.println("You successfully logged out");
		}
	}


	private static void showBalance() {
		System.out.println( deno.toString() + " Total Balance : " + userBalance);
	}

   
 
}

 
