//package com.tt.service.zhekou;
//
//import java.util.ArrayList;
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
//import org.springside.modules.persistence.SearchFilter.Operator;
//
//import com.google.common.collect.Lists;
//import com.tt.entity.Task;
//import com.tt.entity.Zhekou;
//import com.tt.repository.ZhekouDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class ZhekouService {
//	
//	private ZhekouDao zkdao;
//	@Transactional(readOnly = false)
//	public void savezhekou(Zhekou newZhekou) {
//		System.out.println("s"+newZhekou.getBz());
//		zkdao.save(newZhekou);
//		
//	}
//	public ZhekouDao getZkdao() {
//		return zkdao;
//	}
//
//	public Page<Zhekou> getUserZhekou(Long userId,
//			Map<String, Object> searchParams, int pageNumber, int pageSize,
//			String sortType) {
//		System.out.print(userId);
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Zhekou> spec = buildSpecification(searchParams);
//
//		return zkdao.findAll(spec,pageRequest);
//	}
//	/**
//	 * 
//	 * 搜索
//	 * */
//	private Specification<Zhekou> buildSpecification(
//			Map<String, Object> searchParams) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Zhekou> spec = DynamicSpecifications.bySearchFilter(filters.values(), Zhekou.class);
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
//	@Autowired
//	public void setZkdao(ZhekouDao zkdao) {
//		this.zkdao = zkdao;
//	}
//	public Zhekou getZhekou(Long id) {
//		// TODO Auto-generated method stub
//		return zkdao.findOne(id);
//	}
//	@Transactional(readOnly = false)
//	public void delete(Long id) {
//		zkdao.delete(id);
//		
//	}
//	public List<Zhekou> getZkall() {
//		// TODO Auto-generated method stub
//		return Lists.newArrayList(zkdao.findAll());
//	}
//}
