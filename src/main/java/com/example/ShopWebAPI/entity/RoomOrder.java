package com.example.ShopWebAPI.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoomOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Date checkInTime;
	private Date checkOutTime;
	private double total;
	private double feeToPay;
	private boolean status;
	
	@ManyToOne 
	@JoinColumn(name = "customer_id",nullable = false)
	private Customer customers;
	@ManyToOne
	@JoinColumn(name = "room_id",nullable = false)
	private Room rooms;
	@ManyToOne	
	@JoinColumn(name = "account_id",nullable= false)
	private Account accounts;
	
	@OneToOne(mappedBy = "order")
	private Transaction transaction;
}
