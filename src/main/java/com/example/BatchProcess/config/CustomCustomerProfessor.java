package com.example.BatchProcess.config;

import com.example.BatchProcess.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomCustomerProfessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer item) throws Exception {
        // Capitalize the title
        String capitalizedTitle = item.getName().toUpperCase();
        item.setName(capitalizedTitle);

        // Return the modified CustomerProfile
        return item;
    }
}
