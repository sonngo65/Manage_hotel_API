package com.example.ShopWebAPI.entity;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy =  GenerationType.UUID)
	private UUID id;
	
	private String name;
	private String phoneNumber;
	private Date birthDay;
	private String address;
	private String codeCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id",referencedColumnName = "id")
	@JsonManagedReference
	private Image image;
	
	@OneToOne(mappedBy = "employee")
	@JsonBackReference
	private Account account;
	
}
