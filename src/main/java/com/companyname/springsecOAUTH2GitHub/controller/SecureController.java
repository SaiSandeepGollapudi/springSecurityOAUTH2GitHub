package com.companyname.springsecOAUTH2GitHub.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sound.sampled.Port;

@Controller
public class SecureController {
    //This is a simple MVC controller.This is not REST API.
@GetMapping("/")// This is an springMVC path with the path"/" like if someone is trying to access my local host with the Port 8080, this is the path that will get invoked
    public String main(OAuth2AuthenticationToken token){//inside this token we'll have all the details of the end user that I received from the GitHubAUTH server.
        System.out.println(token.getPrincipal());
        return "secure.html";
// if he wants to access this he won't directly get the secure.html.He will be redirected to the GitHub login page. Once he entered his actual credentials, then only he will
// be able to access this secure.html.

}



}
