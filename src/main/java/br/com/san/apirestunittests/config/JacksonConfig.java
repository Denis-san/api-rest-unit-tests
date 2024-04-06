package br.com.san.apirestunittests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.san.apirestunittests.domain.PaymentWithCard;
import br.com.san.apirestunittests.domain.PaymentWithTicket;

@Configuration
public class JacksonConfig {
	@Bean
	Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PaymentWithCard.class);
				objectMapper.registerSubtypes(PaymentWithTicket.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
