package com.springBatchExample.Demo.Configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.springBatchExample.Demo.Model.Person;
import com.springBatchExample.Demo.Processor.PersonProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	private final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<Person> reader() {
		logger.info("inside flatfilereader");
		FlatFileItemReader<Person> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("persons.csv"));

		DefaultLineMapper<Person> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "firstName", "lastName", "email", "age" });
		defaultLineMapper.setLineTokenizer(lineTokenizer);

		BeanWrapperFieldSetMapper<Person> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Person.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		flatFileItemReader.setLineMapper(defaultLineMapper);
		return flatFileItemReader;
	}

	@Bean
	public PersonProcessor processor() {
		return new PersonProcessor();
	}

	public JdbcBatchItemWriter<Person> writer() {
		logger.info("inside jdbcbatchItemWriter");
		JdbcBatchItemWriter<Person> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();
		jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		// jdbcBatchItemWriter.setDataSource(dataSource);
		jdbcBatchItemWriter.setSql("Insert into Person values(:firstName,:lastName,:email,:age");
		return jdbcBatchItemWriter;
	}

	@Bean
	public Job importJob() {
		logger.info("inside importJob");
		return jobBuilderFactory.get("jobPerson").incrementer(new RunIdIncrementer()).flow(getStep1()).end().build();
	}

	@Bean
	public Step getStep1() {
		logger.info("inside stepper");
		return stepBuilderFactory.get("step1").<Person, Person>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

}
