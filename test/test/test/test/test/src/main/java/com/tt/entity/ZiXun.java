package com.tt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zixun")
public class ZiXun {
	private Long zixun_type_id;
	private String title;
	private String content;
	private String img_url;
	private int  zixun_type;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getZixun_type_id() {
		return zixun_type_id;
	}
	public void setZixun_type_id(Long zixun_type_id) {
		this.zixun_type_id = zixun_type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getZixun_type() {
		return zixun_type;
	}
	public void setZixun_type(int zixun_type) {
		this.zixun_type = zixun_type;
	}
	
}
