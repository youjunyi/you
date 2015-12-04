//package com.tt.service.zhekou;
//
//import java.util.List;
//import java.util.Map;
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
//
//import com.google.common.collect.Lists;
//import com.tt.entity.Fengcheng;
//import com.tt.entity.Zhekou;
//
//import com.tt.repository.FengchengDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class FengchengService {
//	@Autowired
//	private FengchengDao fcdao;
//	@Transactional(readOnly = false)
//	public void save(Fengcheng newFengcheng) {
//		fcdao.save(newFengcheng);
//		
//	}
//	public Page<Fengcheng> getFengcheng(Map<String, Object> searchParams,
//			int pageNumber, int pageSize, String sortType) {
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Fengcheng> spec = buildSpecification(searchParams);
//
//		return fcdao.findAll(spec, pageRequest);
//	}
//	private Specification<Fengcheng> buildSpecification(
//			Map<String, Object> searchParams) {
//		 
//			Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//			//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//			Specification<Fengcheng> spec = DynamicSpecifications.bySearchFilter(filters.values(), Fengcheng.class);
//		
//		return spec;
//	}
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
//	public Fengcheng getFengcheng(Long id) {
//		// TODO Auto-generated method stub
//		return fcdao.findOne(id);
//	}
//	@Transactional(readOnly = false)
//	public void delete(Long id) {
//		fcdao.delete(id);
//		
//	}
//	public List<Fengcheng> getAll() {
//		
//		return Lists.newArrayList(fcdao.findAll());
//	}
//	
//	public Fengcheng getFengchenglx(Integer lx) {
//		// TODO Auto-generated method stub
//		return fcdao.findByLx(lx);
//	}
//
//}
