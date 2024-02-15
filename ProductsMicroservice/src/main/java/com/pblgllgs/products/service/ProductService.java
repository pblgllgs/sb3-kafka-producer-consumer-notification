package com.pblgllgs.products.service;

import com.pblgllgs.products.rest.CreateProductRestModel;

public interface ProductService {
	
	String createProduct(CreateProductRestModel model) throws Exception;
}
