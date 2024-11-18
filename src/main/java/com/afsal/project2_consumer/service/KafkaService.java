package com.afsal.project2_consumer.service;


import com.afsal.project2_consumer.dao.ProductDao;
import com.afsal.project2_consumer.dto.ProductDto;
import com.afsal.project2_consumer.entity.Product;
import com.afsal.project2_consumer.util.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    Logger logger;

    @KafkaListener(topics = "project2-kafka-1", groupId = "project2-group", id = "MyListenerId")
    public void consume(ProductDto productDto){
        logger.info("Consumed {}",String.valueOf(productDto));

        Product product = ProductMapper.toEntity(productDto);
        productDao.save(product);

        String str = ProductMapper.toString(product);

        Boolean flag = redisTemplate.opsForHash().putIfAbsent("PRODUCT", "" + product.getId(), str);
        if (!flag) {
            logger.info("Product got updated");
            redisTemplate.opsForHash().put("PRODUCT", "" + product.getId(), str);
        } else logger.info("Product got created");
    }

}
