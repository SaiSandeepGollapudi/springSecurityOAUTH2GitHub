package com.companyname.springsecOAUTH2GitHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import javax.swing.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecOAUTH2GitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests)->requests.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());//any request that comes towards my Spring Boot application has to be authenticated.
        // And this time I don't want to use form login or HTTP basic.  I want to use the OAUTH2 style of login.
        return http.build();
    }
//    @Bean
//    public ClientRegistrationRepository clientRepository(){//inside my Spring Boot application, my application is going to act as a client application inside the OAUTH2 grand flow.
//        // But here my client application does not know what is a clientID, client secret values. For the same, we need to create a bean of type client registration repository.
//        ClientRegistration clientRegistration= clientRegistration();
//        return new InMemoryClientRegistrationRepository(clientRegistration);// I'm returning back so that my spring security framework knows where I have stored my client details.
//        // So, as of now, we are storing the client details inside the memory.
//    }
//    private ClientRegistration clientRegistration() {//So the output from this method is an object of client registration, which we can pass to the above in-memory client registration
//        // repository.
//return CommonOAuth2Provider//I'm leveraging one of the enum class available inside the spring security framework
////This enum class is CommonOAuth2Provider. Inside this CommonOAuth2Provider there are multiple enum values, like if you want to use Google, similarly we also have GitHub etc.
////  for GitHub also, it is populating all the scope details, authorization URL, token URL, and the same for Facebook and OKTA. If I don't have these enum class  inside the spring
////  security framework. I have to pass all these details manually.
//        .GITHUB.getBuilder("github")//we want to use the github server so invoke this getBuilder method, and to this getBuilder method we have  to pass a value
//        // github and post that.  We need to invoke these methods  like clientid and clientsecret to pass these values which we have received during the registration process
//
//        .clientId("8cf67ab304dc500092e3")// we should not hard code these values directly here. We should try to read them from certain property files, by following the production
//        // standards. But for now, since this is a simple web application, that should be fine.
//        .clientSecret("6e6f91851c864684af2f91eaa08fb5041162768e").build();//So, this is one of the lengthy process that you can follow but we don't have to follow this lengthy process.
//        //There is also another short approach which we can leverage using application.properties
//}
}
