package com.example.BatchProcess.config;

import com.example.BatchProcess.entity.CustomerProfile;
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
    public Job firstJobBean(JobRepository jobRepository,
                            JobCompletionNotificationImpl listener,
                            Step firstStep
    ) {
        return new JobBuilder("firstJob", jobRepository)
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
    public Job secondJobBean(JobRepository jobRepository,
                             JobCompletionNotificationImpl listener,
                             Step secondStep
    ) {
        return new JobBuilder("secondJob", jobRepository)
                .listener(listener)
                .start(secondStep)
                .build();
    }

    @Bean
    public Step secondStep(
            JobRepository jobRepository,
            DataSourceTransactionManager transactionManager,
            ItemReader<CustomerProfile> reader,
            ItemProcessor<CustomerProfile, CustomerProfile> processor,
            ItemWriter<CustomerProfile> writer
    ) {
        return new StepBuilder("secondJobStep", jobRepository)
                .<CustomerProfile, CustomerProfile>chunk(5, transactionManager)
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
    public FlatFileItemReader<CustomerProfile> customerProfileReader() {
        return new FlatFileItemReaderBuilder<CustomerProfile>()
                .name("customerProfileReader")
                .resource(new ClassPathResource("customer.csv"))
                .delimited()
                .names("userID", "title", "professional", "age")
                .targetType(CustomerProfile.class)
                .build();
    }

    // Processor
    @Bean
    public ItemProcessor<Product, Product> productProcessor() {
        return new CustomProductItemProcessor();
    }

    @Bean
    public ItemProcessor<CustomerProfile, CustomerProfile> customerProfileProcessor() {
        return new CustomCustomerProfessor();
    }

    // Writer
    @Bean
    public ItemWriter<Product> productWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .sql("insert into mg_products(product_id, title, description, price, discount) values (:productId, :title, :description, :price, :discount)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public ItemWriter<CustomerProfile> customerProfileWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CustomerProfile>()
                .sql("insert into mg_customers(user_id, title, professional, age) values (:userId, :title, :professional, :age)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
}
