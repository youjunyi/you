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
//import com.google.common.collect.Lists;
//import com.tt.entity.Fengcheng;
//import com.tt.entity.Type;
//import com.tt.repository.TypeDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class TypeService {
//	@Autowired
//	private TypeDao typeDao;
//	@Transactional(readOnly = false)	
//	public void save(Type newType) {
//		// TODO Auto-generated method stub
//		typeDao.save(newType);
//	}
//	public Page<Type> getTypeList(Map<String, Object> searchParams,
//			int pageNumber, int pageSize, String sortType) {
//		
//		
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Type> spec = buildSpecification(searchParams);
//		return typeDao.findAll(spec,pageRequest);
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
//	
//	private Specification<Type> buildSpecification(
//			Map<String, Object> searchParams) {
//		 
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Type> spec = DynamicSpecifications.bySearchFilter(filters.values(), Type.class);
//	
//		return spec;
//	}
//	public Type getTypeid(Long id) {
//		// TODO Auto-generated method stub
//		return typeDao.findOne(id);
//	}
//	@Transactional(readOnly = false)	
//	public void delete(Long id) {
//		typeDao.delete(id);		
//	}
	//public List<Type> getAll() {
		// TODO Auto-generated method stub
		//return Lists.newArrayList(typeDao.findAll());
	//}
//
//}
