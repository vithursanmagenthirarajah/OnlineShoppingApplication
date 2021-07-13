package com.DeliveryService.Delivery.Controller;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class DeliveryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "delivery_address")
	private String address;

	@Column(name = "delivery_city")
	private String city;
	
	@Column(name = "zip")
	private int zipcode;
	
	
	

	public DeliveryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryDetail(long id, String address, String city, int zipcode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	

	

}
