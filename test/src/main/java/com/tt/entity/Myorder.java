package com.tt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="myorder")
public class Myorder {
	private int id;
	private String state;
	private int post_money;
	private int total_money;
	private Date time;
	private User user;
	private Cosmetics cosmetics;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPost_money() {
		return post_money;
	}
	public void setPost_money(int post_money) {
		this.post_money = post_money;
	}
	public int getTotal_money() {
		return total_money;
	}
	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "cosmetics_id")
	public Cosmetics getCosmetics() {
		return cosmetics;
	}
	public void setCosmetics(Cosmetics cosmetics) {
		this.cosmetics = cosmetics;
	}
	
	
}
