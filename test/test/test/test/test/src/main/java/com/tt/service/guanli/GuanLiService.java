package com.tt.service.guanli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tt.entity.Advice;
import com.tt.entity.CosmeticType;
import com.tt.entity.Cosmetics;
import com.tt.entity.ZiXun;
import com.tt.repository.AdviceDao;
import com.tt.repository.CosmeticTypeDao;
import com.tt.repository.CosmeticsDao;
import com.tt.repository.ZhiXunDao;

@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class GuanLiService {
	@Autowired
	private ZhiXunDao zxd;
	@Autowired 
	private  CosmeticTypeDao costypedao;
	@Autowired
	private CosmeticsDao cosdao;
	@Autowired
	private AdviceDao  adao;
	public Page<ZiXun> getFengcheng(int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		return zxd.findAll(pageRequest);
	}

	private PageRequest buildPageRequest(int pageNumber, int pageSize) {
		
		return new PageRequest(pageNumber - 1, pageSize);
	}
	@Transactional(readOnly = false)
	public void deletezx(Long id) {
		zxd.delete(id);
	}

	public ZiXun getzixun(Long id) {
		// TODO Auto-generated method stub
		return zxd.findOne(id);
	}
	@Transactional(readOnly = false)
	public void savezx(ZiXun zixun) {
		zxd.save(zixun);
		
	}

	public Page<CosmeticType> getpagecostype(int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		return costypedao.findAll(pageRequest);
	}
	@Transactional(readOnly = false)
	public void deletetype(Long id) {
		costypedao.delete(id);
		
	}

	public CosmeticType getcostype(Long id) {
		// TODO Auto-generated method stub
		return costypedao.findOne(id);
	}
	@Transactional(readOnly = false)
	public void savetype(CosmeticType cosmeticType) {
		costypedao.save(cosmeticType);
		
	}

	public Page<Cosmetics> getlistcos(int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		return cosdao.findAll(pageRequest);
	}
	@Transactional(readOnly = false)
	public void deletecos(Long id) {
		cosdao.delete(id);
	}
	public Cosmetics getcos(Long id) {
		// TODO Auto-generated method stub
		return cosdao.findOne(id);
	}

	public List<CosmeticType> getcostypeList() {
		// TODO Auto-generated method stub
		return (List<CosmeticType>) costypedao.findAll();
	}
	@Transactional(readOnly = false)
	public void savecos(Cosmetics cosmetics) {
		cosdao.save(cosmetics);
	}

	public Page<Advice> getAdvice(int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		return adao.findAll(pageRequest);
	}

	public void deleteadvice(Long id) {
		adao.delete(id);
		
	}
}
