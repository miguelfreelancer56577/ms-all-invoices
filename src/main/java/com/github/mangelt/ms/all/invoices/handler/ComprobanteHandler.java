package com.github.mangelt.ms.all.invoices.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.mangelt.ms.all.invoices.repository.ComprobateRepository;
import com.github.mangelt.sat.services.model.Comprobante;

import reactor.core.publisher.Mono;

@Component
public class ComprobanteHandler
{

	@Autowired
	ComprobateRepository repo;

	public Mono<ServerResponse> getAll(ServerRequest rq){
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(this.repo.getAll(), Comprobante.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}

}
