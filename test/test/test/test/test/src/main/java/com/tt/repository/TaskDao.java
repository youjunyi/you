package com.tt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.tt.entity.Task;

public interface TaskDao extends PagingAndSortingRepository<Task, Long>, JpaSpecificationExecutor<Task> {

	Page<Task> findByUser1Id(Long id, Pageable pageRequest);

	@Modifying
	@Query("delete from Task task where task.user1.id=?1")
	void deleteByUser1Id(Long id);
}
