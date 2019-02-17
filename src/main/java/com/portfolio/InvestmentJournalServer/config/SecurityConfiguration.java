package com.portfolio.InvestmentJournalServer.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Value(value = "${auth0.apiAudience}")
	private String apiAudience;
	@Value(value ="${auth0.issuer}")
	private String issuer;
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/positions/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/positions/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/positions/buy/**", "/api/positions/sell/**").hasAuthority("read:history");
                ;
    }
	
    //test
//    curl -H ${"Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik1ERkJPRGxETkRNeFJqRTVSak01UXpBME9UUkRSVFl6TmpoRVFUWkdSalJFTWpsRFJEZzJNZyJ9.eyJpc3MiOiJodHRwczovL2h1Z29rZXVuZy5ldS5hdXRoMC5jb20vIiwic3ViIjoiMERSaHhUREFrd0RxaHhnc3l4bHVVc3RDWHI3ZGZYR3lAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9hcGkiLCJpYXQiOjE1NDg0NjU4MDAsImV4cCI6MTU0ODU1MjIwMCwiYXpwIjoiMERSaHhUREFrd0RxaHhnc3l4bHVVc3RDWHI3ZGZYR3kiLCJzY29wZSI6InJlYWQ6aGlzdG9yeSIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyJ9.a1CL-GnUfloOeW2-pgsW0-9DI3oItWy8D6x1OOR2I9qfBCImKFNBgoyaAZ1pMcaxWe9X5OOLrMJ9Hk1QtjnOpHC0blljMQiIxFAXHqXtYFBtG2-2MakpNfqfZwWfEoU50Xv3CMwuctgqlFt53Fn4dc-83_ITkUPse2Dm0318dD0qyeltfNsqxwsb6egdNJXBEi6xZp4BO_N4qtuIJHNGG2MGlAwoAd-M6OIebAfJA_sgBGw_M-YoCuMZGfDV8SADnF4rBMqAWBM9mhPi2z7hV_Edo6uzln3mCIdMDEJ0IbuNtW24jcJSxIhZU-dNSIu6R24877xQ6NSHh3Umwut8xg"} http://localhost:8080/api/positions/current
//	
	
//
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		JwtWebSecurityConfigurer
//		.forRS256(apiAudience, issuer)
//		.configure(http)
//		.authorizeRequests()
//		.antMatchers(HttpMethod.POST,"/api/positions/current").permitAll()
//		//.antMatchers(HttpMethod.GET, "/api/positions/**").permitAll()
//	//	.antMatchers(HttpMethod.GET,"/api/positions/all").hasAuthority("view:registrations")
//		//.antMatchers(HttpMethod.GET,"/api/positions/sell").hasAuthority("view:registration")
//		.anyRequest().authenticated();
//	}
}
