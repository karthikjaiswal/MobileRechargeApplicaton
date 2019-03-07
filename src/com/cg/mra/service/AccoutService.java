package com.cg.mra.service;

import com.cg.mra.beans.Account;

public interface AccoutService {

	Account getAccountDetails(String mobileno);

	int rechargeAccount(String mobileno,double rechargeAmount);
	
}
