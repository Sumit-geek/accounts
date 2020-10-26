package com.anz.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.anz.accounts.domain.Account;
import com.anz.accounts.domain.Transaction;
import com.anz.accounts.repository.AccountRepository;
import com.anz.accounts.repository.TransactionRepository;
import com.anz.accounts.service.AccountDaoService;
import com.anz.accounts.service.exception.AccountNotFoundException;
import com.anz.accounts.service.exception.TransactionNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountDaoServiceImpl implements AccountDaoService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TransactionRepository tranctionRepo;

	/**
	 * fetch all the account associated with the customer
	 * 
	 * @param customerID
	 *            customer ID of the customer in string format
	 * @return List<Account> list of accounts of the customer
	 */
	@Override
	public List<Account> getAccounts(String customerID, Pageable pageable) {
		Page<Account> accounts = accountRepo.findByCustNum(Long.parseLong(customerID), pageable);

		int count = accounts.getNumberOfElements();
		log.info(count + " accounts found for customer ID: " + customerID);

		if (count == 0) {
			log.info("No account found for the customer: " + customerID);
			throw new AccountNotFoundException("No account found for the customer: " + customerID);
		}

		return accounts.toList();
	}

	/**
	 * Fetch account transactions from database using repository
	 * 
	 * @param customerID
	 *            customer ID
	 * @param accountNum
	 *            account number of the customer
	 * @return List<Transaction> list of transaction for the account
	 */
	@Override
	public List<Transaction> getTransactions(String customerID, String accountNum, Pageable pageable) {
		long custID = Long.parseLong(customerID);
		long acctNum = Long.parseLong(accountNum);

		Account accounts = accountRepo.findByCustNumAndAcctNum(custID, acctNum);
		if (accounts == null) {
			log.info("Thers is no account: " + accountNum + "for the customer ID: " + customerID);
			throw new AccountNotFoundException("No account: " + accountNum + " found for the customer: " + customerID);
		}

		Page<Transaction> tnxs = tranctionRepo.findByAcctNum(acctNum, pageable);

		int count = tnxs.getNumberOfElements();
		log.info("Total " + count + " transactions found for account num: " + accountNum + ", customer ID: "
				+ customerID);

		if (count == 0) {
			throw new TransactionNotFoundException(
					"No transaction found for account: " + accountNum + " for customer: " + customerID);
		}

		return tnxs.toList();
	}

}
