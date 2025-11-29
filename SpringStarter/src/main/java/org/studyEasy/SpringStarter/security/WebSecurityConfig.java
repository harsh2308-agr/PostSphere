package org.studyEasy.SpringStarter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.studyEasy.SpringStarter.util.constant.Privillages;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

        private static final String[] WHITELIST = {
                        "/",
                        "/login",
                        "/register",
                        "/db-console/**",
                        "/css/**",
                        "/fonts/**",
                        "/images/**",
                        "/js/**",
                        "/change-password/**"
        };

        // IMPORTANT: Prevent Spring from auto-creating the default "user" login
        // @Bean
        // public UserDetailsService userDetailsService() {
        // return username -> null; // disables authentication completely
        // }

        @Bean
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(auth -> auth
                .requestMatchers(WHITELIST).permitAll()
                .requestMatchers("/forgot-password", "/reset-password").permitAll()
                .requestMatchers("/profile/**").authenticated()
                .requestMatchers("/editor/**")
                .hasAnyRole("ADMIN", "EDITOR")
                .requestMatchers("/admin/**")
                .hasAuthority(Privillages.ACCESS_ANY_ADMIN_PANEL.getPrivillage())
                .anyRequest().authenticated())
        .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error")
                .permitAll())
        .rememberMe(remember -> remember
                .key("harshSecretKey123")   // Use a strong secret key
                .tokenValiditySeconds(7 * 24 * 60 * 60) // 7 days
                .rememberMeParameter("remember-me"))   // name of checkbox in login form
        .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me"))
        .csrf(csrf -> csrf.disable())
        .headers(headers -> headers.frameOptions(frame -> frame.disable()));

    return http.build();
}


}
