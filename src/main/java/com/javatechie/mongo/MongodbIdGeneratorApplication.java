package com.javatechie.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/order")
public class MongodbIdGeneratorApplication {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
    	order.setId(sequenceGeneratorService.generateSequence(order.SEQUENCE_NAME));
        return orderRepository.save(order);
    }

    public static void main(String[] args) {
        SpringApplication.run(MongodbIdGeneratorApplication.class, args);
    }

}
