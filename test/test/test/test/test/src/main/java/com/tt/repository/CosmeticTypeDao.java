package com.tt.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tt.entity.CosmeticType;
import com.tt.entity.User;

public interface CosmeticTypeDao extends PagingAndSortingRepository<CosmeticType, Long>, JpaSpecificationExecutor<CosmeticType>  {

}
