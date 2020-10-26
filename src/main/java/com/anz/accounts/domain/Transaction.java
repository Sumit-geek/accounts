package com.anz.accounts.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private enum DebitCredit {
		Debit, Credit
	}

	@JsonIgnore
	@Id
	@GeneratedValue
	private long transactionId;

	private long acctNum;

	@Enumerated(EnumType.STRING)
	private AccountType acctType;

	private Date valueDate;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private double debitAmt;

	private double creditAmt;

	@Enumerated(EnumType.STRING)
	private DebitCredit debitCredit;

	private String narrative;
}
