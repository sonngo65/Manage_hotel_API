package com.example.ShopWebAPI.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String provinceCode;
	private String name;
	private String note;
	private boolean isDelete;
	@OneToOne(mappedBy = "province")
	private Hotel hotel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id",referencedColumnName = "id")
	private Image image; 
	
}
