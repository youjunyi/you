//package com.tt.service.zhekou;
//
//import java.util.List;
//import java.util.Map;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springside.modules.persistence.DynamicSpecifications;
//import org.springside.modules.persistence.SearchFilter;
//
//import com.google.common.collect.Lists;
//import com.tt.entity.Renyuan;
//
//import com.tt.repository.RenyuanDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class RenyuanService {
//	@Autowired
//	private RenyuanDao rydao;
//
//	
//	
//	public Page<Renyuan> getRenyuan(
//			Map<String, Object> searchParams, int pageNumber, int pageSize,
//			String sortType) {
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Renyuan> spec = buildSpecification(searchParams);
//
//		return rydao.findAll(spec, pageRequest);
//	}
//
//	private Specification<Renyuan> buildSpecification(
//			Map<String, Object> searchParams) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		Specification<Renyuan> spec = DynamicSpecifications.bySearchFilter(filters.values(), Renyuan.class);
//		return spec;
//	}
//	/**
//	 * 分页，排序
//	 * */
//	private PageRequest buildPageRequest(int pageNumber, int pageSize,
//			String sortType) {
//		Sort sort = null;
//		if ("auto".equals(sortType)) {
//			sort = new Sort(Direction.DESC, "id");
//		} else if ("name".equals(sortType)) {
//			sort = new Sort(Direction.ASC, "name");
//		}
//		return new PageRequest(pageNumber - 1, pageSize, sort);
//	}
//	@Transactional(readOnly = false)
//	public void save(Renyuan newRenyuan) {
//		
//		rydao.save(newRenyuan);
//	}
//
//	public Renyuan getRenyuanNoe(Long id) {
//		
//		return rydao.findOne(id);
//	}
//	@Transactional(readOnly = false)
//	public void delete(Long id) {
//		rydao.delete(id);
//		
//	}
//
//	public List<Renyuan> getRenAll() {
//		// TODO Auto-generated method stub
//		return Lists.newArrayList(rydao.findAll());
//	}
//
//	
//	
//	
//}
