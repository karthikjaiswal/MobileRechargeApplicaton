package com.cg.mra.dao;

import com.cg.mra.beans.Account;

public interface AccountDao {

	Account getAccountDetails(String mobileno);
	int rechargeAccount(String mobileno, double rechargeAmount);
}
