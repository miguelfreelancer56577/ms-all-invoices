package com.github.mangelt.ms.all.invoices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableWebFlux
@Slf4j
@EnableDiscoveryClient
public class App
{
	public static void main( String[] args )
	{
		log.info("Starting ms-all-invoices spring boot application.");
		SpringApplication.run(App.class, args);
	}
}
