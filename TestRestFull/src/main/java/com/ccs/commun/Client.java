package com.ccs.commun;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"age", "address", "name", "phone"})
public class Client implements Comparable<Client>{

	@XmlElement(required = true)
	private String name;
	@XmlElement(required = true)
	private String age;
	@XmlElement(required = true)
	private String address;
	@XmlElement(required = false)
	private String phone;
	private Integer dni;
	private String profession;	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Client() {
		
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Client o) {
		int ret = 1;
		if (o.getDni().equals(this.getDni()))
			ret = 0;
		
		return ret;
		
	}
	
	
	
	
}
