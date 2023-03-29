package com.geddit.geddit;

import com.geddit.geddit.model.Post;
import com.geddit.geddit.repo.PostRepo;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GedditApplication {

  public static void main(String[] args) {
    SpringApplication.run(GedditApplication.class, args);
  }

  @Bean
  CommandLineRunner run(PostRepo postRepo) {
    return args -> {
      postRepo.save(
        new Post(
          null,
          "Dancing",
          "Maciek",
          "I was on a dancing yesterday, It was great!"
        )
      );
      postRepo.save(
        new Post(
          null,
          "Football game",
          "Michal",
          "I was playing a game yesterday, It was great!"
        )
      );
      postRepo.save(
        new Post(
          null,
          "School",
          "Konrad",
          "I was in school yesterday, It was great!"
        )
      );
      postRepo.save(
        new Post(
          null,
          "Party",
          "Kacper",
          "I will throw a party tomorrow, It will be great!"
        )
      );
    };
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedOrigins(
      Arrays.asList("https://localhost:3000", "http://localhost:4200")
    );
    corsConfiguration.setAllowedHeaders(
      Arrays.asList(
        "Origin",
        "Access-Control-Allow-Origin",
        "Content-type",
        "Accept",
        "Jwt Token",
        "Authorization",
        "Origin, Accept",
        "X-Requested-With",
        "Access-Control-Request-Method",
        "Access-Control-Request-Headers"
      )
    );
    corsConfiguration.setExposedHeaders(
      Arrays.asList(
        "Origin",
        "Content-type",
        "Accept",
        "Jwt-Token",
        "Authorization",
        "Access-Control-Allow-Origin",
        "Access-Control-Access-Origin",
        "Access-Control-Allow-Credentials",
        "Filename"
      )
    );
    corsConfiguration.setAllowedMethods(
      Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
    );
    urlBasedCorsConfigurationSource.registerCorsConfiguration(
      "/**",
      corsConfiguration
    );
    return new CorsFilter(urlBasedCorsConfigurationSource);
  }
}
