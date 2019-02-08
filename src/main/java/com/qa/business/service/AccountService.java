package com.qa.business.service;

public interface AccountService {
	
	String getAllAccounts();
	String createAccount(String accountJSON);
	String updateAccount(String username, String accountJSON);
	String deleteAccount(String username);
	String getAccount(String username);
}
