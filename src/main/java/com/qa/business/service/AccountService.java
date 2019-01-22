package com.qa.business.service;

public interface AccountService {
	
	String getAllAccounts();
	String createAccount(String accountJSON);
	String updateAccount(Long id, String accountJSON);
	String deleteAccount(Long id);
}
