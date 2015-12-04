//package com.tt.repository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//
//import com.tt.entity.Liucheng;
//
//
//
//public interface LiuchengDao  extends PagingAndSortingRepository<Liucheng, Long>, JpaSpecificationExecutor<Liucheng> {
//	
//	
//	@Query(value="select new map (sum(t.jyje) as jyje,sum(t.jysl) as jysl) from Liucheng t where t.type =?1")
//	List<Map> getTongji(Integer type);
//	@Query(value="select t from Liucheng t where t.type=?1 and t.shangpin.name like ?2 " )
//	List<Liucheng> findType(Integer type, String name);
//	
//	List<Liucheng> findByTypeAndZtAndRenyuanNameLikeAndShangpinNameLikeAndCzsjBetween(
//			Integer type, Integer zt, String rname, String sname, Date date,
//			Date date1);
//	List<Liucheng> findByTypeAndZtAndRenyuanNameLikeAndShangpinNameLike(
//			Integer type, Integer zt, String rname, String sname);
//	List<Liucheng> findByTypeAndZtAndCzsjBetween(Integer type, Integer zt,
//			Date date, Date date1);
//	
//	List<Liucheng> findByTypeAndZt(Integer type, Integer zt);
//	
//	List<Liucheng> findByTypeAndZtAndRenyuanNameLikeAndCzsjBetween(Integer type,
//			Integer zt, String rname, Date date, Date date1);
//	List<Liucheng> findByTypeAndZtAndShangpinNameLikeAndCzsjBetween(
//			Integer type, Integer zt, String sname, Date date, Date date1);
//	List<Liucheng> findByTypeAndZtAndShangpinNameLike(Integer type, Integer zt,
//			String sname);
//	List<Liucheng> findByTypeAndZtAndRenyuanNameLike(Integer type, Integer zt,
//			String rname);
//	List<Liucheng> findByRenyuanNameLikeAndTypeAndZt(String rname,
//			Integer type, Integer zt);
//	List<Liucheng> findByUserName(String name);
//	List<Liucheng> findByUserNameAndCzsjBetween(String name, Date date,
//			Date date1);
//
//}
