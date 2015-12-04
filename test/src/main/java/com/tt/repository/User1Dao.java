package com.tt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tt.entity.User1;

public interface User1Dao extends PagingAndSortingRepository<User1, Long>{
	//User1 findByUsername(String username);

	User1 findByLoginName(String loginName);
}
