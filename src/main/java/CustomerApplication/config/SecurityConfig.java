package CustomerApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService userDetailsService() {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder::encode);

        UserDetails userDetails = userBuilder
                .username("Srikanth")
                .password("Srikanth")
                .roles("USER")
                .build();
        UserDetails userDetails1 = userBuilder
                .username("RAM")
                .password("RAM")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }
}
