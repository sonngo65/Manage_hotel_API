package com.example.ShopWebAPI.entity;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String fullname;
	private String idCard;
	private String gender;
	private String phoneNumber;
	private String address;
	private Date birthDay;
	private String note;
	private boolean isDelete;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private Set<RoomOrder> order;

}
