package com.anz.accounts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anz.accounts.domain.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

	public Page<Account> findByCustNum(long custNum, Pageable pageable);

	public Account findByCustNumAndAcctNum(long custNum, long acctNum);

}
