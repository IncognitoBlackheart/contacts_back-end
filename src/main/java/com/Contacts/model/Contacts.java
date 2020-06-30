package com.Contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "contactlist")
public class Contacts {
	@ApiModelProperty (value = "Unique ID for each person registered")
	@Column(name = "cpf", columnDefinition = "integer(11)", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@NotEmpty (message = "Write only the numbers on the cpf")
	private int cpf;
	
	@ApiModelProperty (value = "Name of the registered person")
	@Column(name = "namecontact", length = 50, nullable = false)
	@NotEmpty (message = "Write the contact's name")
	private String name;
	
	@ApiModelProperty (value = "Phone number")
	@Column(name = "phone", length = 15)
	@NotEmpty (message = "Write the phone number")
	private String phone;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}