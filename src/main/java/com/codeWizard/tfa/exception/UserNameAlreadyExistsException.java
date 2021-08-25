package com.codeWizard.tfa.exception;

@SuppressWarnings("serial")
public class UserNameAlreadyExistsException extends Exception{
	public UserNameAlreadyExistsException(String msg) {
		super(msg);
	}
}
