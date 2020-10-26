package com.anz.accounts.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.anz.accounts.domain.Account;
import com.anz.accounts.domain.Transaction;

public interface AccountDaoService {
	List<Account> getAccounts(String customerID, Pageable pageable);

	List<Transaction> getTransactions(String customerID, String accountNum, Pageable pageable);
}
