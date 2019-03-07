package com.cg.mra.exceptions;

public class UserDoesNotExist extends Exception {

	public UserDoesNotExist()
	{
		System.err.println("ERROR: Mobile No Does Not Exists");
	}

}
