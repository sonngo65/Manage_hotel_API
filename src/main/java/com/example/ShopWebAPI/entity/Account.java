package com.example.ShopWebAPI.entity;

import java.sql.Date;
import java.util.Set;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String username;
	private String password;
	private boolean isDelete;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "employee_id",referencedColumnName  = "id")
	@JsonManagedReference
	private Employee employee;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
	@JsonIgnore
	private Set<Role> roles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "position_id", referencedColumnName = "id")
	@JsonIgnore
	private Position position;

	@OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.LAZY, mappedBy = "accounts")
	@JsonIgnore
	private Set<RoomOrder> order;

	@OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY,mappedBy = "account")
	@JsonIgnore
	private Set<Transaction> transactions;
}
