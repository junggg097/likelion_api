package com.example.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Configuration
public class WebClientConfig {
    @Bean
    // WebClient.Builder를 활용해 전체 서비스에서 사용할
    // 기본 설정을 갖춘 WebClient Bean으로 등록 가능
    public WebClient defaultWebClient() {
        // 그냥 새로 생성해서 사용할수도 있음
        // WebClient webClient = WebClient.create();

        // RestTemplate에 비해 선언형 (함수형) 구조를 가진다.
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader("test0", "foo")
                .defaultRequest(request ->
                        request.header("test1", "bar"))
                .defaultStatusHandler(
                        HttpStatusCode::isError, response
                                -> {throw new ResponseStatusException(response.statusCode());}
                )
                .build();
    }
}
