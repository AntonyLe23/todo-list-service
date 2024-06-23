package com.lifung.todolistservice.configuration;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.MediaType;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.lifung.todolistservice.elasticsearch")
@RequiredArgsConstructor
public class ESConfiguration {

  @Bean
  public RestClient getRestClient() {
    return RestClient.builder(
            new HttpHost("localhost", 9200, "http")
        )
        .setHttpClientConfigCallback(httpAsyncClientBuilder -> {
          httpAsyncClientBuilder.setDefaultHeaders(List.of(new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));
          httpAsyncClientBuilder.addInterceptorLast(
              (HttpResponseInterceptor)
                  (response, context) ->
                      response.addHeader("X-Elastic-Product", "Elasticsearch"));
          return httpAsyncClientBuilder;
        })
        .build();
  }

  @Bean
  public ElasticsearchTransport getElasticsearchTransport() {
    return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
  }

  @Bean
  public ElasticsearchClient getElasticsearchClient() {
    return new ElasticsearchClient(getElasticsearchTransport());
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchTemplate(getElasticsearchClient());
  }
}
