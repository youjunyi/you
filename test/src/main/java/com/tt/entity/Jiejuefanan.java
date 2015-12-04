//package com.tt.entity;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.google.common.collect.Lists;
//
//@Entity
//@Table(name = "JIEJUEFANAN")
//public class Jiejuefanan {
//	private Long id;
//	private String userid;
//	private String username;
//	private String gztype;
//	private int bzfs;
//	private int wxfs;
//	private String bz;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_JJFA_ID")
//	@javax.persistence.SequenceGenerator(name = "SEQ_JJFA_ID", sequenceName ="SEQ_JJFA_ID", allocationSize = 1, initialValue = 1)
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUserid() {
//		return userid;
//	}
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getGztype() {
//		return gztype;
//	}
//	public void setGztype(String gztype) {
//		this.gztype = gztype;
//	}
//	public int getBzfs() {
//		return bzfs;
//	}
//	public void setBzfs(int bzfs) {
//		this.bzfs = bzfs;
//	}
//	public int getWxfs() {
//		return wxfs;
//	}
//	public void setWxfs(int wxfs) {
//		this.wxfs = wxfs;
//	}
//	public String getBz() {
//		return bz;
//	}
//	public void setBz(String bz) {
//		this.bz = bz;
//	}
//	
//
//	
//	
//}
