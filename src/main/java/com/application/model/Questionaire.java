package com.application.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel( description = "Représente les infos de l'adresse" )
public class Questionaire implements Serializable {

	private static final long serialVersionUID = -1722746145500599537L;

	@JsonProperty( "age" )
	@Size( min = 1, max = 3 )
	private int age;

	@JsonProperty( "toux" )
	private Boolean toux;

	@JsonProperty( "fievre" )
	private Boolean fievre;
	
	@JsonProperty( "diabete" )
	private Boolean diabete;
	
	@JsonProperty( "contact" )
	private Boolean contact;
	

	public void setAge(int age) {
		this.age = age;
	}
	public void setContact(Boolean contact) {
		this.contact = contact;
	}
	public void setDiabete(Boolean diabete) {
		this.diabete = diabete;
	}
	public void setFievre(Boolean fievre) {
		this.fievre = fievre;
	}
	public void setToux(Boolean toux) {
		this.toux = toux;
	}
	public int getAge() {
		return age;
	}
	public Boolean getContact() {
		return contact;
	}
	public Boolean getDiabete() {
		return diabete;
	}
	public Boolean getFievre() {
		return fievre;
	}
	public Boolean getToux() {
		return toux;
	}
}