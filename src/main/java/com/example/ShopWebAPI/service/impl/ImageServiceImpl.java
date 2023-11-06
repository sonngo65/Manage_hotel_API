package com.example.ShopWebAPI.service.impl;

import org.springframework.stereotype.Service;

import com.example.ShopWebAPI.entity.Image;
import com.example.ShopWebAPI.repository.ImageRepository;
import com.example.ShopWebAPI.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	private final ImageRepository imageRepository;
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public Image add(Image image) {
		Image savedImage = imageRepository.save(image);
		return savedImage;
	}

}
