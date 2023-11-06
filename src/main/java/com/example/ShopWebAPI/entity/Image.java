package com.example.ShopWebAPI.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String imageLink;
	private boolean isDelete;
	
	@OneToOne(mappedBy = "image")
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Hotel hotel;
	
	@OneToOne(mappedBy = "image")
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Province province;
	
	
	@OneToOne(mappedBy="image")
	@JsonBackReference
	private Employee employee;
//	
	
	public Image(String originalFilename) {
		this.imageLink = originalFilename;
	}
}
