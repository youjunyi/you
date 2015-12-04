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
@JsonIgnoreProperties(value={"cosmetics"})
@Table(name = "cosmetic_type")
public class CosmeticType {
	private Long type_id;
	private String type_name;
	private List<Cosmetics> cosmetics;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cosmeticstype")
	@OrderBy("type_id")
	public List<Cosmetics> getCosmetics() {
		return cosmetics;
	}
	public void setCosmetics(List<Cosmetics> cosmetics) {
		this.cosmetics = cosmetics;
	}
	
	
}
