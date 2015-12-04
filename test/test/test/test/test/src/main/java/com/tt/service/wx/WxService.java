//package com.tt.service.wx;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tt.entity.Jiejuefanan;
//import com.tt.entity.Liucheng;
//import com.tt.entity.Shouji;
//import com.tt.entity.Wxliucheng;
//import com.tt.repository.JjfananDao;
//import com.tt.repository.ShoujiDao;
//import com.tt.repository.WxBatis;
//import com.tt.repository.WxDao;
//
//@Component
//@Transactional(readOnly = false)
//public class WxService {
//	@Autowired
//	private WxDao wxdao;
//	@Autowired
//	private ShoujiDao sjdao;
//	@Autowired
//	private JjfananDao jjdao;
//	@Autowired
//	private WxBatis wxb;
//	@Transactional(readOnly = false)
//	public void save(Shouji shouji, Wxliucheng lc) {
//		lc.setShouji(shouji);
//		lc.setBiaozhi("受理");
//		lc.setKssj(new Date());
//		sjdao.save(shouji);
//		wxdao.save(lc);
//		
//	}
//
//	public List<Map<String,String>> querywx(Map<String, Object> searchParams,
//			int pageNumber, int pageSize, String sortType,Long userid) {
//		List<Map<String,String>> list = wxb.list(userid);
//		return list;
//	}
//
//	public Wxliucheng getlc(Long id) {
//		return wxdao.findOne(id);
//		
//	}
//	@Transactional(readOnly = false)
//	public void save2(Jiejuefanan jj, Long id) {
//		Wxliucheng lc = wxdao.findOne(id);
//		lc.setJjfa(jj);
//		lc.setBiaozhi("取机");
//		wxdao.save(lc);
//		jjdao.save(jj);
//		
//	}
//	@Transactional(readOnly = false)
//	public void save3(Wxliucheng lc) {
//		// TODO Auto-generated method stub
//		wxdao.save(lc);
//	}
//
//	public Shouji getsj(Long id) {
//		// TODO Auto-generated method stub
//		return sjdao.findOne(id);
//	}
//
//	public List<Map<String, String>> querysywx(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return wxb.querysywx(map);
//	}
//
//	public void delete(Long id) {
//		wxdao.delete(id);
//		
//	}
//	
//}
