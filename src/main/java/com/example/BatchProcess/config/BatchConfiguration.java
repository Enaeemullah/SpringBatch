package com.example.BatchProcess.config;

import com.example.BatchProcess.entity.Customer;
import com.example.BatchProcess.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    // First Job
    @Bean
    public Job productJob(JobRepository jobRepository,
                            JobCompletionNotificationImpl listener,
                            Step firstStep
    ) {
        return new JobBuilder("productJob", jobRepository)
                .listener(listener)
                .start(firstStep)
                .build();
    }

    @Bean
    public Step firstStep(
            JobRepository jobRepository,
            DataSourceTransactionManager transactionManager,
            ItemReader<Product> reader,
            ItemProcessor<Product, Product> processor,
            ItemWriter<Product> writer
    ) {
        return new StepBuilder("firstJobStep", jobRepository)
                .<Product, Product>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    // Second Job
    @Bean
    public Job customerJob(JobRepository jobRepository,
                             JobCompletionNotificationImpl listener,
                             Step secondStep
    ) {
        return new JobBuilder("customerJob", jobRepository)
                .listener(listener)
                .start(secondStep)
                .build();
    }

    @Bean
    public Step secondStep(
            JobRepository jobRepository,
            DataSourceTransactionManager transactionManager,
            ItemReader<Customer> reader,
            ItemProcessor<Customer, Customer> processor,
            ItemWriter<Customer> writer
    ) {
        return new StepBuilder("secondJobStep", jobRepository)
                .<Customer, Customer>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    // Reader for the first job
    @Bean
    public FlatFileItemReader<Product> productReader() {
        return new FlatFileItemReaderBuilder<Product>()
                .name("productReader")
                .resource(new ClassPathResource("product.csv"))
                .delimited()
                .names("productId", "title", "description", "price", "discount")
                .targetType(Product.class)
                .build();
    }

    // Reader for the second job
    @Bean
    public FlatFileItemReader<Customer> customerProfileReader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("customerProfileReader")
                .resource(new ClassPathResource("customer.csv"))
                .delimited()
                .names("customerId", "name", "email", "address")
                .targetType(Customer.class)
                .build();
    }

    // Processor
    @Bean
    public ItemProcessor<Product, Product> productProcessor() {
        return new CustomProductItemProcessor();
    }

    @Bean
    public ItemProcessor<Customer, Customer> customerProfileProcessor() {
        return new CustomCustomerProfessor();
    }

    // Writer
    @Bean
    public ItemWriter<Product> productWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .sql("insert into products(product_id, title, description, price, discount, discounted_price) values (:productId, :title, :description, :price, :discount, :discountedPrice)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public ItemWriter<Customer> customerProfileWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Customer>()
                .sql("insert into customers(customer_id, name, email, address) values (:customerId, :name, :email, :address)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
}
