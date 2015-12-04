package com.tt.service.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.tt.entity.Advice;
import com.tt.entity.CosmeticType;
import com.tt.entity.Cosmetics;
import com.tt.entity.MyorderBen;
import com.tt.entity.User;
import com.tt.repository.AdviceDao;
import com.tt.repository.CosmeticTypeDao;
import com.tt.repository.CosmeticsDao;
import com.tt.repository.UserDao;
import com.tt.repository.WxBatis;



@Component
@Transactional(readOnly = true)
public class  MptService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private CosmeticTypeDao ctd;
	@Autowired
	private CosmeticsDao cod;
	@Autowired
	private WxBatis wxb;
	@Autowired
	private AdviceDao  adao;
	public User getuser(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(user.getUsername());
	}

	public void saveuser(User user) {
		userDao.save(user);
		
	}

	public List<CosmeticType> getAll() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(ctd.findAll());
	}

	

	public Cosmetics getCos(Long id) {
		// TODO Auto-generated method stub
		return cod.findOne(id);
	}

	public List<Map<String, String>> queryCosmeticsbytype(Long typeid) {
		// TODO Auto-generated method stub
		return wxb.queryCosmeticsbytype(typeid);
	}

	public List<Map<String, String>> querycospp(String name) {
		// TODO Auto-generated method stub
		return wxb.querycospp(name);
	}

	public List<Map<String, String>> queryzhuye(String type) {
		// TODO Auto-generated method stub
		return wxb.queryzhuye(type);
	}

	public List<Cosmetics> queryCos() {
		// TODO Auto-generated method stub
		return (List<Cosmetics>) cod.findAll();
	}

	public void updatemm(Long userid, String password) {
		wxb.updatemm(userid,password);
		
	}


	public void savecar(Long cosmetics_id, Integer buy_count,
			Integer comstics_count, Long user_id) {
		Map<String,Object> map  =  wxb.querycar(user_id);
		if(null ==map ){
		wxb.savecar(cosmetics_id,buy_count,comstics_count,user_id);
			map  =  wxb.querycar(user_id);
		}
		
		wxb.savecarsho(cosmetics_id,(Integer) map.get("id"),buy_count,comstics_count);
	}

	public List<Map<String, String>> querycar(Long user_id) {
		
		
		return wxb.querycarall(user_id);
		// TODO Auto-generated method stub
		
	}

	public void deletecar(String shoppid) {
		wxb.deletecar(shoppid);
	}

	public void deletecarsp(String shoppid, String cosid) {
		wxb.deletecarsp(shoppid,cosid);
		
	}

	public void savedt(MyorderBen myorder) {
		wxb.savedt(myorder);
		wxb.updateshoopcar(myorder.getCosmetics_id());
		
	}

	public List<Map<String, String>> querydtall(int user_id) {
		// TODO Auto-generated method stub
		return wxb.querydtall(user_id);
	}

	public List<Map<String, String>> queryzixun(Long type) {
		// TODO Auto-generated method stub
		return wxb.queryzixun(type);
	}

	public List<Map<String, String>> getmyorder() {
		
		return wxb.getmyorder();
	}

	public void updatemyorder(Long id) {
		wxb.updatemyorder(id);
		
	}

	public void saveadvice(Advice advice) {
		adao.save(advice);
	}

	public List<Map<String, String>> typetj() {
		// TODO Auto-generated method stub
		return wxb.typetj();
	}

	public List<Map<String, String>> typetjxx(Long id) {
		// TODO Auto-generated method stub
		return wxb.typetjxx(id);
	}

	public User getuserid(Long userid) {
		// TODO Auto-generated method stub
		return userDao.findOne(userid);
	}
	
	
}
