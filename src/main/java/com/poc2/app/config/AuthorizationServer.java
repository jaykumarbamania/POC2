package com.poc2.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	@Autowired
	public AuthorizationServer(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		// TODO Auto-generated method stub
//		security.checkTokenAccess("isAuthenticated()");
//	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("jaykumar")
				.authorizedGrantTypes("client_credentials")
				.authorities("ADMIN","USER")
				.accessTokenValiditySeconds(5000)
				.resourceIds("oauth2-resource")
				.secret(passwordEncoder.encode("jaykumar-secretkey"))
				.scopes("resource-server-read", "resource-server-write");
	}
}