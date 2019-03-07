package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.CannotRechargeException;

public class AccountDaoImpl implements AccountDao{

	Map<String,Account> accountEntry;
	
	public AccountDaoImpl()
	{
		accountEntry=new HashMap<>();
		accountEntry.put("9010210131", new Account("prepaid","Vaishali",200));
		accountEntry.put("9823920123", new Account("prepaid","Megha",453));
		accountEntry.put("9932012345", new Account("prepaid","Vikas",631));
		accountEntry.put("9010210131", new Account("prepaid","Anju",521));
		accountEntry.put("9010210131", new Account("prepaid","Tushar",632));
		
		
	}

	Account account=null;
	@Override
	public Account getAccountDetails(String mobileno) {
		
	int count=0;
	
	//Traversing the hashmap to check if mobile number already exists
		for(Map.Entry<String,Account> m :accountEntry.entrySet())
		{
			
			if(mobileno.equals(m.getKey()))
			{
				//if mobile number exists get the value of the key in Account object
				account= m.getValue();
				count++;
				return account;
			}
		}
		if(count==0)
			return null;
		else	//return the account object of the matching mobile number
		return account;
	}

	@Override
	public int rechargeAccount(String mobileno, double rechargeAmount) {
		
		int count=0;
		
		//Traversing the hashmap to check if mobile number already exists
		for(Map.Entry<String,Account> m :accountEntry.entrySet())
		{
			
			if(mobileno.equals(m.getKey()))
			{
				count++;
				//if mobile number exists get the value of the key in Account object
				account= m.getValue();
				
				//update the balance by adding the recharge amount to existing balance
				account.setAccountBalance(account.getAccountBalance()+rechargeAmount);
				break;
			}
		}
		
		if(count==0)
		{
			try {
				throw new CannotRechargeException();
			} catch (CannotRechargeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		else
		{
		return (int)account.getAccountBalance();
		}
	}

	
	
}
