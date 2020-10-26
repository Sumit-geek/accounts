package com.anz.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.accounts.domain.Account;
import com.anz.accounts.domain.Transaction;
import com.anz.accounts.service.AccountDaoService;

@RestController
@RequestMapping("/customers")
public class AccountsController {

	@Autowired
	AccountDaoService accountSvc;

	@GetMapping(path = "/{customerID}/accounts")
	public List<Account> accounts(@PathVariable @NumberFormat(style = Style.NUMBER) String customerID,
			Pageable pageable) {
		return accountSvc.getAccounts(customerID, pageable);
	}

	@GetMapping(path = "/{customerID}/accounts/{accountNum}/transactions")
	public List<Transaction> accountTransactions(@PathVariable @NumberFormat(style = Style.NUMBER) String customerID,
			@PathVariable @NumberFormat(style = Style.NUMBER) String accountNum, Pageable pageable) {
		return accountSvc.getTransactions(customerID, accountNum, pageable);
	}
}
