package com.example.ShopWebAPI.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private String Location;
	private String state;
	private double price;
	private boolean isActive;
	private boolean isDelete;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomType_id",nullable = false)
	private RoomType roomType;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "rooms")
	private Set<RoomOrder> order;
}
