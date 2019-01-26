package com.qa.persistance.repository;

public interface AccountRepository {
	
	String getAllAccounts();
	String createAccount(String accountJSON);
	String updateAccount(String username, String accountJSON);
	String deleteAccount(String username);

}
