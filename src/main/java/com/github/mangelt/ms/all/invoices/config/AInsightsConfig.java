package com.github.mangelt.ms.all.invoices.config;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;

@Configuration
public class AInsightsConfig {
	
	@Value("${azure.application-insights.instrumentation-key:#{null}}")
	public String instrumentationKey;
	
	public static final TelemetryConfiguration configuration = TelemetryConfiguration.createDefault();

	@Bean
	public TelemetryClient telemetryClient() {
		TelemetryClient telemetryClient = null;
		
		if(Objects.isNull(instrumentationKey))
			return null;
		else{
			configuration.setInstrumentationKey(instrumentationKey);
			telemetryClient = new TelemetryClient(configuration);
		}
		return telemetryClient;
	}
	
}
