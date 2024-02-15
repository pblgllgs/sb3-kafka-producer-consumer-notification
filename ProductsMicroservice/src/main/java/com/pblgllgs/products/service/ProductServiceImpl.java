package com.pblgllgs.products.service;

import com.pblgllgs.core.ProductCreatedEvent;
import com.pblgllgs.products.rest.CreateProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

	public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public String createProduct(CreateProductRestModel model) throws Exception{
		String productId = UUID.randomUUID().toString();
		ProductCreatedEvent productCreatedEvent =  new ProductCreatedEvent(
				productId,
				model.getTitle(),
				model.getPrice(),
				model.getQuantity()
		);
		
		LOGGER.info("Before publishing a ProductCreatedEvent");
		
		SendResult<String,ProductCreatedEvent> result = 
				kafkaTemplate.send("product-created-events-topic",productId,productCreatedEvent).get();
		
		LOGGER.info("Partition: " +result.getRecordMetadata().partition());
		LOGGER.info("Topic: "+ result.getRecordMetadata().topic());
		LOGGER.info("Offset: "+ result.getRecordMetadata().offset());
		
		LOGGER.info("Returning product id");
		
		return productId;
	}
	
}
