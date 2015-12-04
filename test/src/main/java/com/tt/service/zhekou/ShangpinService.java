//package com.tt.service.zhekou;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springside.modules.persistence.DynamicSpecifications;
//import org.springside.modules.persistence.SearchFilter;
//import org.springside.modules.persistence.SearchFilter.Operator;
//
//import com.tt.entity.Fengcheng;
//import com.tt.entity.Shangpin;
//import com.tt.repository.ShangpinDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class ShangpinService {
//	@Autowired
//	private ShangpinDao spdao;
//
//	public Page<Shangpin> getShangpin(Map<String, Object> searchParams,
//			int pageNumber, int pageSize, String sortType, String name) {
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Shangpin> spec = buildSpecification(searchParams,name);
//
//		return spdao.findAll(spec,pageRequest);
//	}
//
//	
//	private Specification<Shangpin> buildSpecification(
//			Map<String, Object> searchParams, String name) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		if(null!=name && !name.equals("")){
//			filters.put("types.name", new SearchFilter("types.name", Operator.EQ, name));
//		}
//			
//		//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Shangpin> spec = DynamicSpecifications.bySearchFilter(filters.values(), Shangpin.class);
//	
//		return spec;
//	}
//
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
//	@Transactional(readOnly = false)
//	public void save(Shangpin newshangpin) {
//		spdao.save(newshangpin);
//	}
//
//
//	public Shangpin getShangpinNoe(Long id) {
//		// TODO Auto-generated method stub
//		return spdao.findOne(id);
//	}
//
//	@Transactional(readOnly = false)
//	public void delete(Long id) {
//		spdao.delete(id);
//		
//	}
//
//	public Shangpin getShangpinw(String wid) {
//		// TODO Auto-generated method stub
//		return spdao.findByWid(wid);
//	}
//
//
//	public Shangpin findWid(String wid) {
//		// TODO Auto-generated method stub
//		return spdao.findByWid(wid);
//	}
//
//
//	public Object findName(String name) {
//		// TODO Auto-generated method stub
//		return spdao.findByName(name);
//	}
//
//}
