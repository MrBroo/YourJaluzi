package byfayzullayev.jaluzi.config;

import byfayzullayev.jaluzi.filtr.JwtTokenFilter;
import byfayzullayev.jaluzi.service.ApplicationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationUserDetailService applicationUserDetailService;
    private final JwtTokenFilter jwtTokenFilter;

    @Autowired
    public SecurityConfig(ApplicationUserDetailService applicationUserDetailService, JwtTokenFilter jwtTokenFilter) {
        this.applicationUserDetailService = applicationUserDetailService;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
