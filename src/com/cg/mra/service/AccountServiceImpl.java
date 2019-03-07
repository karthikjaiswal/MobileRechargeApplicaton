package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccoutService{

	AccountDao accountDao=new AccountDaoImpl();

	public Account getAccountDetails(String mobileno) {
		//calling AccountDao class method	
		Account account=accountDao.getAccountDetails(mobileno);
		return account;
	}

	
	@Override
	public int rechargeAccount(String mobileno,double rechargeAmount) {
		
		
		return accountDao.rechargeAccount(mobileno, rechargeAmount);
	}

}
