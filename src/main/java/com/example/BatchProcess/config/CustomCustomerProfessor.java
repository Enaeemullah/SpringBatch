package com.example.BatchProcess.config;

import com.example.BatchProcess.entity.CustomerProfile;
import org.springframework.batch.item.ItemProcessor;

public class CustomCustomerProfessor implements ItemProcessor<CustomerProfile, CustomerProfile> {
    @Override
    public CustomerProfile process(CustomerProfile item) throws Exception {
        return item;
    }
}
