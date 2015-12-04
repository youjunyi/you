//package com.tt.service.zhekou;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
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
//import com.tt.entity.Liucheng;
//import com.tt.entity.Renyuan;
//import com.tt.entity.Shangpin;
//import com.tt.entity.User;
//import com.tt.repository.LiuchengDao;
//
//@Component
////默认将类中的所有public函数纳入事务管理.
//@Transactional(readOnly = true)
//public class LiuchengService {
//	@Autowired
//	private LiuchengDao lcdao;
//	
//	@Transactional(readOnly = false)
//	public void save(Liucheng newliucheng) {
//		lcdao.save(newliucheng);
//		
//	}
//
//	public List<Liucheng> getLiuchengall(Integer type, Map<String, Object> searchParams,
//			Integer zt) throws ParseException {
//			Date date = null;
//			Date date1 = null;
//			String rname =null;
//			String sname =null;
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			if(searchParams.get("LIKE_renyuanNname")!=null&&!searchParams.get("LIKE_renyuanNname").equals("")&&!searchParams.get("LIKE_shangpinName").equals("")&&searchParams.get("LIKE_shangpinName")!=null && !searchParams.get("GTE_czsj").equals("") && searchParams.get("GTE_czsj")!=null &&!searchParams.get("LTE_czsj").equals("") && searchParams.get("LTE_czsj")!=null){
//			 rname = searchParams.get("LIKE_renyuanNname").toString();
//			sname = searchParams.get("LIKE_shangpinName").toString();
//			
//			date = sdf.parse(searchParams.get("GTE_czsj").toString());
//			date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//			return lcdao.findByTypeAndZtAndRenyuanNameLikeAndShangpinNameLikeAndCzsjBetween(type,zt,rname,sname,date,date1);
//			}else if(null !=searchParams.get("LIKE_renyuanNname")&&!searchParams.get("LIKE_renyuanNname").equals("")&& !searchParams.get("LIKE_shangpinName").equals("")&&searchParams.get("LIKE_shangpinName")!=null){
//				 rname = searchParams.get("LIKE_renyuanNname").toString();
//				sname = searchParams.get("LIKE_shangpinName").toString();
//				return lcdao.findByTypeAndZtAndRenyuanNameLikeAndShangpinNameLike(type,zt,rname,sname);
//			}else if(null != searchParams.get("GTE_czsj") &&!searchParams.get("GTE_czsj").equals("") && !searchParams.get("LTE_czsj").equals("") && searchParams.get("LTE_czsj")!=null){
//				date = sdf.parse(searchParams.get("GTE_czsj").toString());
//				date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//				return lcdao.findByTypeAndZtAndCzsjBetween(type,zt,date,date1);
//			}else if( null !=searchParams.get("LIKE_renyuanNname")&&!searchParams.get("LIKE_renyuanNname").equals("")&&null != searchParams.get("GTE_czsj") &&!searchParams.get("GTE_czsj").equals("") && !searchParams.get("LTE_czsj").equals("") && searchParams.get("LTE_czsj")!=null){
//				rname = searchParams.get("LIKE_renyuanNname").toString();
//				date = sdf.parse(searchParams.get("GTE_czsj").toString());
//				date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//				return lcdao.findByTypeAndZtAndRenyuanNameLikeAndCzsjBetween(type,zt,rname,date,date1);
//			}else if( null !=searchParams.get("LIKE_shangpinName")&&!searchParams.get("LIKE_shangpinName").equals("")&&null != searchParams.get("GTE_czsj") &&!searchParams.get("GTE_czsj").equals("") && !searchParams.get("LTE_czsj").equals("") && searchParams.get("LTE_czsj")!=null){
//				sname = searchParams.get("LIKE_shangpin.name").toString();
//				date = sdf.parse(searchParams.get("GTE_czsj").toString());
//				date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//				return lcdao.findByTypeAndZtAndShangpinNameLikeAndCzsjBetween(type,zt,sname,date,date1);
//			}else if(null !=searchParams.get("LIKE_shangpinName")&&!searchParams.get("LIKE_shangpinName").equals("")){
//				sname = searchParams.get("LIKE_shangpinName").toString();
//				return lcdao.findByTypeAndZtAndShangpinNameLike(type,zt,sname);
//
//			}else if(null !=searchParams.get("LIKE_renyuanNname")&&!searchParams.get("LIKE_renyuanNname").equals("")){
//				 rname = searchParams.get("LIKE_renyuanNname").toString();
//				 System.out.println(rname);
//					return lcdao.findByRenyuanNameLikeAndTypeAndZt(rname,type,zt);
//
//			}
//				return  lcdao.findByTypeAndZt(type,zt);
//			}
//
//	private Specification<Liucheng> buildSpecification(
//			Map<String, Object> searchParams, Integer type, Integer zt) throws ParseException {
//		Date date = null;
//		Date date1 = null;
//		if(null != searchParams.get("GTE_czsj")&& !searchParams.get("GTE_czsj").equals("")&&null!=searchParams.get("LTE_czsj")&&!searchParams.get("LTE_czsj").equals("")){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			 date = sdf.parse(searchParams.get("GTE_czsj").toString());
//			searchParams.remove("GTE_czsj");
//			date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//			searchParams.remove("LTE_czsj");
//		}
//		
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("type", new SearchFilter("type", Operator.EQ, type));
//		if(null!=zt){
//		filters.put("zt", new SearchFilter("zt", Operator.EQ, zt));
//		}
//		if(date !=null&&date != null){
//		filters.put("czsj", new SearchFilter("czsj", Operator.GT, date));
//		filters.put("czsj", new SearchFilter("czsj", Operator.LT, date1));
//
//		}
//		Specification<Liucheng> spec = DynamicSpecifications.bySearchFilter(filters.values(), Liucheng.class);
//		return spec;
//
//	}
//
//	private PageRequest buildPageRequest(int pageNumber, int pageSize,
//			String sortType) {
//		Sort sort = null;
//		if ("auto".equals(sortType)) {
//			sort = new Sort(Direction.DESC, "id");
//		} else if ("czsj".equals(sortType)) {
//			sort = new Sort(Direction.ASC, "czsj");
//		}
//		return new PageRequest(pageNumber - 1, pageSize, sort);
//	}
//
//	public List<Liucheng> getLiuchenList(Integer type, Map<String, Object> searchParams) {
//	//	Specification<Liucheng> spec = buildSpecification(searchParams);
//		String name ="";
//		if(searchParams.size()==0){
//			
//		}else{
//		name =  searchParams.get("name").toString();
//		}
//		return lcdao.findType(type,name);
//	}
//
//	
//
//	public  List<Map> getTongji(Integer type) {
//		// TODO Auto-generated method stub
//		return lcdao.getTongji(type);
//	}
//
//	public Liucheng getLiuchengno(Long id) {
//		
//		return lcdao.findOne(id);
//	}
//
//	public Page<Liucheng> getLiuchengall1(Integer type,
//			Map<String, Object> searchParams, int pageNumber, int pageSize,
//			String sortType, Integer zt) throws ParseException {
//		// TODO Auto-generated method stub
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Liucheng> spec = buildSpecification(searchParams,type,zt);
//
//		return lcdao.findAll(spec,pageRequest);
//	}
//
//	public Page<Liucheng> getLiuchengr(String sortType,
//			Map<String, Object> searchParams, int pageNumber, int pageSize, User user) throws ParseException {
//		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
//		Specification<Liucheng> spec = buildSpecificationyeji(searchParams,user);
//
//		return lcdao.findAll(spec, pageRequest);
//	}
//
//	private Specification<Liucheng> buildSpecificationyeji(
//			Map<String, Object> searchParams, User user) throws ParseException {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		
//		Date date = null;
//		Date date1 = null;
//		if(null != searchParams.get("GTE_czsj")&& !searchParams.get("GTE_czsj").equals("")&&null!=searchParams.get("LTE_czsj")&&!searchParams.get("LTE_czsj").equals("")){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			 date = sdf.parse(searchParams.get("GTE_czsj").toString());
//			searchParams.remove("GTE_czsj");
//			date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//			searchParams.remove("LTE_czsj");
//		}
//		if(date !=null&&date1 != null){
//			filters.put("czsj", new SearchFilter("czsj", Operator.GT, date));
//			filters.put("czsj", new SearchFilter("czsj", Operator.LT, date1));
//
//			}
//		
//		if(null!=user && !user.equals("")){
//			String name = user.getName();
//			filters.put("user.name", new SearchFilter("user.name", Operator.EQ, name));
//		}
//			
//		//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Liucheng> spec = DynamicSpecifications.bySearchFilter(filters.values(), Liucheng.class);
//	
//		return spec;
//	}
//
//	public List<Liucheng> getLiuchengalldan(Map<String, Object> searchParams, User user) throws ParseException {
//		Date date = null;
//		Date date1 = null;
//		String name = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		if(searchParams.size()!=0&&!searchParams.get("GTE_czsj").equals("")&&!searchParams.get("LTE_czsj").equals("")){
//			date = sdf.parse(searchParams.get("GTE_czsj").toString());
//			date1 = sdf.parse(searchParams.get("LTE_czsj").toString());
//			name = user.getName();
//			System.out.println("ssss");
//			return lcdao.findByUserNameAndCzsjBetween(name,date,date1);
//		}else{
//			name = user.getName();
//			return lcdao.findByUserName(name);
//		}
//		
//		
//		
//	}
//
//}
