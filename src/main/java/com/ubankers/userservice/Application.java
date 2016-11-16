package com.ubankers.userservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.integration.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;


/**
 * 启动方法
 * 
 * @author yuanxiang 20151102
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath*:/spring/*.xml")
@EnableConfigurationProperties
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(
				Application.class);
		application.addListeners(
				new ApplicationPidFileWriter("app.pid"));
		application.run(args);

	}	
	
}
