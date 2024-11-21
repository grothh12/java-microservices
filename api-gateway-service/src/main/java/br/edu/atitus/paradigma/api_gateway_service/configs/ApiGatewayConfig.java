package br.edu.atitus.paradigma.api_gateway_service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ApiGatewayConfig {

	@Bean
	RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(rota -> rota
						.path("/get")
						.filters(f -> f
								.addRequestHeader("Usuario", "Ricardo Groth da Silva")
								.addResponseHeader("Teste", "ResponseHeader"))
						.uri("http://httpbin.org"))
					.route(rota -> rota
						.path("/cambio-service/**")
						.filters(f -> f
								.addRequestHeader("Usuario", "Ricardo Groth da Silva")
								.addResponseHeader("Teste", "ResponseHeader"))
						.uri("lb://cambio-service"))
					.route(rota -> rota
							.path("/produto-service/**")
							.filters(f -> f
									.addRequestHeader("Usuario", "Ricardo Groth da Silva")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("lb://produto-service"))
					.route(rota -> rota
							.path("/saudacao-service/**")
							.filters(f -> f
									.addRequestHeader("Usuario", "Ricardo Groth da Silva")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("lb://saudacao-service"))

				.build();
	}
}