package com.eazybytes.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eazybytes.accounts.entity.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

	/**
	 * @param customerId
	 * @return
	 */
	Optional<Accounts> findByCustomerId(Long customerId);

	/**
	 * @param customerId
	 * @Transactional - As below method is custom method it should be annotated by @Trasactional
	 * 					if any error occurs it will be roll backed.
	 * @Modifying - As below method is custom method it should be annotated by @Modifying
	 * 				we are telling framework this method will modify the data.
	 */
	@Transactional  
	@Modifying
	void deleteByCustomerId(Long customerId);

	
	
	
	
}
