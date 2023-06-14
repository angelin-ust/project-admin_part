package com.ust.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long mid;
    String mname;
    String mprice;
    public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(Long mid, String mname, String mprice) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
}
