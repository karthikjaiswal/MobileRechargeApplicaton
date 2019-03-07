package com.cg.mra.exceptions;

public class CannotRechargeException extends Exception {

	public CannotRechargeException()
	{
		System.err.println("ERROR: Cannot Recahrge Account as Given MObile No Does Not Exists");
	}
}
