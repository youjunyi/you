package com.tt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"shoppingCar","myorder"})
@Table(name="cosmetics")
public class Cosmetics {
	private Long cosmetics_id;
	private String cosmetics_name;
	private int cosmetics_count;
	private int cosmetics_sale_price;
	private int cosmetics_sale_count;
	private int cosmetics_market_price;
	private String cosmetics_detail;
	private String  cosmetics_img;
	private CosmeticType cosmeticstype;
	private List<ShoppingCar> shoppingCar;
	private List<Myorder> myorder;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCosmetics_id() {
		return cosmetics_id;
	}
	public void setCosmetics_id(Long cosmetics_id) {
		this.cosmetics_id = cosmetics_id;
	}
	public String getCosmetics_name() {
		return cosmetics_name;
	}
	public void setCosmetics_name(String cosmetics_name) {
		this.cosmetics_name = cosmetics_name;
	}
	public int getCosmetics_count() {
		return cosmetics_count;
	}
	public void setCosmetics_count(int cosmetics_count) {
		this.cosmetics_count = cosmetics_count;
	}
	public int getCosmetics_sale_price() {
		return cosmetics_sale_price;
	}
	public void setCosmetics_sale_price(int cosmetics_sale_price) {
		this.cosmetics_sale_price = cosmetics_sale_price;
	}
	public int getCosmetics_sale_count() {
		return cosmetics_sale_count;
	}
	public void setCosmetics_sale_count(int cosmetics_sale_count) {
		this.cosmetics_sale_count = cosmetics_sale_count;
	}
	public int getCosmetics_market_price() {
		return cosmetics_market_price;
	}
	public void setCosmetics_market_price(int cosmetics_market_price) {
		this.cosmetics_market_price = cosmetics_market_price;
	}
	public String getCosmetics_detail() {
		return cosmetics_detail;
	}
	public void setCosmetics_detail(String cosmetics_detail) {
		this.cosmetics_detail = cosmetics_detail;
	}
	public String getCosmetics_img() {
		return cosmetics_img;
	}
	public void setCosmetics_img(String cosmetics_img) {
		this.cosmetics_img = cosmetics_img;
	}
	@ManyToOne
	@JoinColumn(name = "type_id")
	public CosmeticType getCosmeticstype() {
		return cosmeticstype;
	}
	public void setCosmeticstype(CosmeticType cosmeticstype) {
		this.cosmeticstype = cosmeticstype;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cosmetics")
	public List<ShoppingCar> getShoppingCar() {
		return shoppingCar;
	}
	public void setShoppingCar(List<ShoppingCar> shoppingCar) {
		this.shoppingCar = shoppingCar;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cosmetics")
	public List<Myorder> getMyorder() {
		return myorder;
	}
	public void setMyorder(List<Myorder> myorder) {
		this.myorder = myorder;
	}

	
	
	
}
