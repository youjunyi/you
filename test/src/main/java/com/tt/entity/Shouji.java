//package com.tt.entity;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;
//
//import com.google.common.collect.Lists;
//
//@Entity
//@Table(name = "SHOUJI")
//public class Shouji {
//	private Long id;
//	private String  jqxlh;	
//	private String jqys;	
//	private String jqrl;	
//	private String jqxh;	
//	private String dh;	
//	private String name;
//	private String emal;	
//	private String dz;	
//	private String bz;
//	private String type;
//	private Long wxcs;
//	private String sfwhmd;
//	private String bylxr;
//	private String bylxrdh;
//	private String imei;
//	private String bxjz;
//	private String jqwg;
//	private String cid;
////	private List<Wxliucheng> wlcList = Lists.newArrayList();
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_SJ_ID")
//	@javax.persistence.SequenceGenerator(name = "SEQ_SJ_ID", sequenceName ="SEQ_SJ_ID", allocationSize = 1, initialValue = 1)
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getJqxlh() {
//		return jqxlh;
//	}
//	public void setJqxlh(String jqxlh) {
//		this.jqxlh = jqxlh;
//	}
//	public String getJqys() {
//		return jqys;
//	}
//	public void setJqys(String jqys) {
//		this.jqys = jqys;
//	}
//
//	public String getJqrl() {
//		return jqrl;
//	}
//	public void setJqrl(String jqrl) {
//		this.jqrl = jqrl;
//	}
//	public String getJqxh() {
//		return jqxh;
//	}
//	public void setJqxh(String jqxh) {
//		this.jqxh = jqxh;
//	}
//	public String getDh() {
//		return dh;
//	}
//	public void setDh(String dh) {
//		this.dh = dh;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmal() {
//		return emal;
//	}
//	public void setEmal(String emal) {
//		this.emal = emal;
//	}
//	public String getDz() {
//		return dz;
//	}
//	public void setDz(String dz) {
//		this.dz = dz;
//	}
//	public String getBz() {
//		return bz;
//	}
//	public void setBz(String bz) {
//		this.bz = bz;
//	}
//	public Long getWxcs() {
//		return wxcs;
//	}
//	public void setWxcs(Long wxcs) {
//		this.wxcs = wxcs;
//	}
//	public String getSfwhmd() {
//		return sfwhmd;
//	}
//	public void setSfwhmd(String sfwhmd) {
//		this.sfwhmd = sfwhmd;
//	}
////	@OneToMany(fetch = FetchType.LAZY,mappedBy = "shouji")
////	@OrderBy("id")
////	public List<Wxliucheng> getWlcList() {
////		return wlcList;
////	}
////	public void setWlcList(List<Wxliucheng> wlcList) {
//	//	this.wlcList = wlcList;
////	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getBylxr() {
//		return bylxr;
//	}
//	public void setBylxr(String bylxr) {
//		this.bylxr = bylxr;
//	}
//	public String getBylxrdh() {
//		return bylxrdh;
//	}
//	public void setBylxrdh(String bylxrdh) {
//		this.bylxrdh = bylxrdh;
//	}
//	public String getImei() {
//		return imei;
//	}
//	public void setImei(String imei) {
//		this.imei = imei;
//	}
//
//	public String getJqwg() {
//		return jqwg;
//	}
//	public void setJqwg(String jqwg) {
//		this.jqwg = jqwg;
//	}
//	public String getBxjz() {
//		return bxjz;
//	}
//	public void setBxjz(String bxjz) {
//		this.bxjz = bxjz;
//	}
//	public String getCid() {
//		return cid;
//	}
//	public void setCid(String cid) {
//		this.cid = cid;
//	}
//
//	
//}
