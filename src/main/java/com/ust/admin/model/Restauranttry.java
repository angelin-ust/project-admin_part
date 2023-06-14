package com.ust.admin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restauranttry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String restName;
	String restAddress;
	String restContact;
	String restPic;
	
	@OneToMany(targetEntity=Menu.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY,
			orphanRemoval=true
			)
	@JoinColumn(referencedColumnName = "id",name="rest_id")
	List<Menu> menu;
	
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public String getRestPic() {
		return restPic;
	}
	public void setRestPic(String restPic) {
		this.restPic = restPic;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestAddress() {
		return restAddress;
	}
	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	public String getRestContact() {
		return restContact;
	}
	public void setRestContact(String restContact) {
		this.restContact = restContact;
	}
	public Restauranttry() {
		// TODO Auto-generated constructor stub
	}
	public Restauranttry(Long id, String restName, String restAddress, String restContact,String restPic,List<Menu> menu) {
		//super();
		this.id = id;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restContact = restContact;
		this.restPic = restPic;
		this.menu = menu;
	}
	
}
