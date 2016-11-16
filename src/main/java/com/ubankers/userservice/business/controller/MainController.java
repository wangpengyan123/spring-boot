package com.ubankers.userservice.business.controller;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubankers.userservice.business.domain.User;
import com.ubankers.userservice.business.service.UserService;
import com.ubankers.userservice.configuration.mq.MqSend;
import com.ubankers.userservice.configuration.mq.kafka.producer.KafkaProducer;

/**
 * spring boot mvc demo
 */
@RestController
@RequestMapping("/")
public class MainController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	UserService userService;

	@RequestMapping
	public String index() {
		return "Hello! Spring Boot~";
	}

	@RequestMapping(value = { "/user/{id}" }, method = { RequestMethod.GET })
	public String findOne(@PathVariable("id") String id) throws Exception {
		logger.info("controller findOne");
		return "sucess";
	}

	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	public String register(@RequestParam("name") String name) {
		userService.addUser(name);
		return "success";
	}

	@RequestMapping("/velocity")
	public String velocity(Model model) {
		model.addAttribute("testparam", "hi boot..");
		return "index";
	}
}
