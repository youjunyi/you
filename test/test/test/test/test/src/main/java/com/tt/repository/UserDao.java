package com.tt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.tt.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);
	}
