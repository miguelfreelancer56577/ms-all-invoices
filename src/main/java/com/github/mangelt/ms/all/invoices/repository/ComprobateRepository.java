package com.github.mangelt.ms.all.invoices.repository;

import org.springframework.stereotype.Component;

import com.github.mangelt.sat.services.model.Comprobante;
import com.github.mangelt.sat.services.repository.CosmosRepository;

@Component
public class ComprobateRepository extends CosmosRepository<Comprobante, String> {

}
