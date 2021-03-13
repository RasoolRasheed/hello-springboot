package com.rasool.test.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PasswordService {
	private final String encryptKey = "medicare@bit";
	
	//encryption
	public String encrypt(String pw) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword(encryptKey);
		return encryptor.encrypt(pw);
	}
	//decryption
	public String decrypt(String enpw) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword(encryptKey);
		return encryptor.decrypt(enpw);
	}
}
