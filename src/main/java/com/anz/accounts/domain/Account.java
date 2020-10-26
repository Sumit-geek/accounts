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
public class Account {
	@Id
	@GeneratedValue
	private long acctNum;

	@JsonIgnore
	private long custNum;

	private String name;

	@Enumerated(EnumType.STRING)
	private AccountType type;

	private Date balanceDate;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private double balance;
}
