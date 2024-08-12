package com.learn.micro.config;

//import com.learn.micro.client.EmployeClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
//
//    @Autowired
//    private LoadBalancedExchangeFilterFunction filterFunction;
//
//    @Bean
//    public WebClient employeWebClient(){
//
//        return WebClient.builder()
//                .baseUrl("http://employee-service/")
//                .filter(filterFunction)
//                .build();
//    }
//
//    @Bean
//    public EmployeClient employeClient(){
//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(employeWebClient())).build();
//        return  httpServiceProxyFactory.createClient(EmployeClient.class);
//    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
