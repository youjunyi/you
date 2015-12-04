package com.tt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"myorder","shoppingcar"})

@Table(name = "user")
public class User {
	private int user_id;
	private String username;
	private String password;
	private String face;
	private List<ShoppingCar> shoppingcar;
	private List<Myorder> myorder;
	private List<Advice> advice;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
	public List<ShoppingCar> getShoppingcar() {
		return shoppingcar;
	}
	public void setShoppingcar(List<ShoppingCar> shoppingcar) {
		this.shoppingcar = shoppingcar;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
	public List<Myorder> getMyorder() {
		return myorder;
	}
	public void setMyorder(List<Myorder> myorder) {
		this.myorder = myorder;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
	public List<Advice> getAdvice() {
		return advice;
	}
	public void setAdvice(List<Advice> advice) {
		this.advice = advice;
	}
	

}
