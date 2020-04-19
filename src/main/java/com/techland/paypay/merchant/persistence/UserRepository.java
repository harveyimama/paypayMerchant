package com.techland.paypay.merchant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

	List<User> findAllByMerchant(Merchant merchant);

}
