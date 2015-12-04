package com.tt.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tt.entity.Advice;

public interface AdviceDao extends PagingAndSortingRepository<Advice, Long>, JpaSpecificationExecutor<Advice>   {

}
