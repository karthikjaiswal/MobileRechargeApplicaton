package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.InvalidMobileNumber;
import com.cg.mra.exceptions.UserDoesNotExist;
import com.cg.mra.service.AccountServiceImpl;
import com.cg.mra.service.AccoutService;

public class MainUI {

	Scanner sc=new Scanner(System.in);
	static MainUI m=new MainUI();
	AccoutService accoutService=new AccountServiceImpl();
	public static void main(String[] args) {
		
		
		m.choice();

	}

	public void choice() {
		
		System.out.println("=========Welcome to Customer service=======");
		System.out.println("1. Account balance enquiry \n2. Recharge amount \n3. Exit");
		
		
		int n=sc.nextInt();
		
		switch(n)
		{
		case 1:
				System.out.println("Enter mobile number");
				String mobileno=sc.next();
				
				//check whether the given number is 10 digit or not
				if(mobileno.length()==10)
				{
					//call AccountServiceImpl class method
					//returns Account object and store it in object
					Account account=accoutService.getAccountDetails(mobileno);
			
					//Check the object if not null display balance
					if(account!=null)
					System.out.println("Account balance is:"+account.getAccountBalance());
					
					//if account object is null throw an exception UserDoesNotExist
					else {
					try {
						throw new UserDoesNotExist();
						} catch (UserDoesNotExist e) {
						
						e.printStackTrace();
						}
					}
				}
				//If number is not 10 digit throw an exception
				else
				{
					try {
						throw new InvalidMobileNumber();
					} catch (InvalidMobileNumber e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				m.choice();
				break;
		case 2:
				System.out.println("Enter mobile no");
				String mobileNo=sc.next();
				
				//check whether the given number is 10 digit or not
				if(mobileNo.length()==10)
				{
					//call AccountServiceImpl class method
					//returns Account object and store it in object
					Account account=accoutService.getAccountDetails(mobileNo);
					
					System.out.println("Enter recharge amount");
					Double rechargeAmount=sc.nextDouble();
					
					//call recharge amount method of AccountServiceImpl
					//add recharge amount to existing balance and update value
					int updated_balance=accoutService.rechargeAccount(mobileNo,rechargeAmount);
					
					System.out.println("Recharge Done Successfully \nhello "+account.getCustomerName()+" updated balance is:"+updated_balance);
				}
				//If number is not 10 digit throw an exception
				else
				{
					try {
					throw new InvalidMobileNumber();
					}catch (InvalidMobileNumber e) {
							e.printStackTrace();
						}
				
				}
				m.choice();
				break;
			case 3:
				System.exit(0);
					
	}
		
}
}


