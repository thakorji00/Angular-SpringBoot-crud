package com.ciright.cirightcrudxample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "employee")
public class CirightEmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String empName;
	private String empCity;
	private String empDesination;
	private Integer isActive;
	
	
	public CirightEmployeeModel() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpCity() {
		return empCity;
	}


	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}


	public String getEmpDesination() {
		return empDesination;
	}


	public void setEmpDesination(String empDesination) {
		this.empDesination = empDesination;
	}


	public Integer getIsActive() {
		return isActive;
	}


	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}


	public CirightEmployeeModel(Integer id, String empName, String empCity, String empDesination, Integer isActive) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCity = empCity;
		this.empDesination = empDesination;
		this.isActive = isActive;
	}
	
	
	
}
