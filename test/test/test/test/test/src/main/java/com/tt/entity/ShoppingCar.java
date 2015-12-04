package com.tt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopping_car")
public class ShoppingCar {
	
	private int id;
	private int buy_count;
	private int comstics_count;
	private String state;
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
	public int getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(int buy_count) {
		this.buy_count = buy_count;
	}
	public int getComstics_count() {
		return comstics_count;
	}
	public void setComstics_count(int comstics_count) {
		this.comstics_count = comstics_count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
