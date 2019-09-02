package com.github.mangelt.ms.all.invoices.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.mangelt.ms.all.invoices.handler.ComprobanteHandler;

@Configuration
public class ComprobanteRouter
{

	public static final String API = "/comprobante";

	@Bean
	public RouterFunction<ServerResponse> blobItem(ComprobanteHandler comprobanteHandler)
	{
		return RouterFunctions
				.route(RequestPredicates.GET(API),
						comprobanteHandler::getAll);
	}

}
