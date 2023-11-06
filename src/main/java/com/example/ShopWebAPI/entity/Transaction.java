package com.example.ShopWebAPI.entity;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private int quantity;
	private Date buyTime;	
	
	@OneToOne
	@JoinColumn(name =  "order_id", referencedColumnName = "id")
	private RoomOrder order;
	
	@ManyToOne
	@JoinColumn(name = "account_id",nullable = false)
	private Account account;
	
	@ManyToMany 
	@JoinTable(
			name = "transaction_service",
			joinColumns = @JoinColumn(name= "transaction_id",nullable = false),
			inverseJoinColumns = @JoinColumn(name = "service_id",nullable = false)
			)
	private Set<Service> services;
}
