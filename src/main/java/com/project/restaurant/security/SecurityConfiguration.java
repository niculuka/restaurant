package com.project.restaurant.security;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.security.authentication.MyUserDetailsService;
import com.project.restaurant.security.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // to avoid circular references -> write "spring.main.allow-circular-references=true"  in application.properties
    // or @Lazy on variables

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/auth/**").permitAll()

                .antMatchers( "/products/**").permitAll()
                .antMatchers("/product/**").permitAll()

                .antMatchers("/admin/products").hasRole( Role.ADMIN.name())
                .antMatchers("/admin/products/**").hasRole( Role.ADMIN.name())

                .antMatchers("/admin/orders").hasRole( Role.ADMIN.name())
                .antMatchers("/admin/orders/**").hasRole( Role.ADMIN.name())
                .antMatchers("/admin/status/**").hasRole( Role.ADMIN.name())

                .antMatchers("/admin/items").hasRole( Role.ADMIN.name())
                .antMatchers("/admin/items/**").hasRole( Role.ADMIN.name())

                .antMatchers("/admin/users").hasRole(Role.ADMIN.name())
                .antMatchers("/admin/users/**").hasRole(Role.ADMIN.name())
                .antMatchers("/admin/change/**").hasRole(Role.ADMIN.name())
                .antMatchers("/admin/replace/**").hasRole(Role.ADMIN.name())

                .antMatchers("/admin/tokens").hasRole( Role.ADMIN.name())
                .antMatchers("/admin/tokens/**").hasRole( Role.ADMIN.name())

                .anyRequest().authenticated();

        http.addFilterBefore(authorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthorizationFilter authorizationFilter() {
        return new AuthorizationFilter();
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
