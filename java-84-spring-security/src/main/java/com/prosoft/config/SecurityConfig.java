package com.prosoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/welcome").permitAll()
                .antMatchers("/cars.jpg").permitAll()
                .antMatchers("/cars").hasAnyRole("USER")
                .antMatchers("/car").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    /**
     * Бин passwordEncoder() задает процедуру проверки паролей, если useBcrypt = true, то пароль в БД должен быть
     * захеширован через https://bcrypt.online/
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        boolean useBcrypt = false;
        if (useBcrypt) {
            // Сравнение паролей будет производиться с использованием bcrypt — адаптивной криптографической хеш-функции
            return new BCryptPasswordEncoder();
        } else {
            // Сравнение паролей будет производиться как сравнение простых текстовых строк
            return NoOpPasswordEncoder.getInstance();
        }

    }

}
