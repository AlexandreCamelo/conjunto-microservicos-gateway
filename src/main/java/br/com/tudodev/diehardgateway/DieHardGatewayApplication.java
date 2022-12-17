package br.com.tudodev.diehardgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DieHardGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DieHardGatewayApplication.class, args);
	}

		@Bean
		public RouteLocator routes(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(r-> r.path("/clientes/**").uri("lb://diehardmsclientes"))
					.route(r-> r.path("/email/**").uri("lb://diehardmsemail"))
					.build();
		}

}
