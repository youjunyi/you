package com.tt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tt.entity.Cosmetics;

public interface CosmeticsDao extends PagingAndSortingRepository<Cosmetics, Long>, JpaSpecificationExecutor<Cosmetics>   {
	//public List<Cosmetics> findByCosmeticType(Long typeid);
}
