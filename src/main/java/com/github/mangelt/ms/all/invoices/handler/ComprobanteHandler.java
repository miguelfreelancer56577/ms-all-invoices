package com.github.mangelt.ms.all.invoices.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.mangelt.ms.all.invoices.repository.ComprobateRepository;
import com.github.mangelt.sat.services.model.Comprobante;
import com.microsoft.applicationinsights.TelemetryClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ComprobanteHandler
{

	@Autowired
	ComprobateRepository repo;
	
	@Autowired
    TelemetryClient telemetryClient;

	public Mono<ServerResponse> getAll(ServerRequest rq){
		String logMessage = "Get all records from cosmos db";
		telemetryClient.trackEvent(logMessage);
		log.info(logMessage);
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(this.repo.getAll(), Comprobante.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}

}
