package com.tt.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tt.entity.CosmeticType;
import com.tt.entity.ZiXun;

public  interface ZhiXunDao extends PagingAndSortingRepository<ZiXun, Long>, JpaSpecificationExecutor<ZiXun>  {



}

