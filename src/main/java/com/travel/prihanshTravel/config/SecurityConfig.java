package com.travel.prihanshTravel.config;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.travel.prihanshTravel.service.SecurityCustomUserDetailService;

//@Configuration
public class SecurityConfig {

    // configure spring security for user authentication and authorization and
    // getting user details from database

    // @Autowired
    // SecurityCustomUserDetailService userDetailsService;
       

    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

    //     // set the user details service
    //     provider.setUserDetailsService(userDetailsService);
    //     provider.setPasswordEncoder(passwordEncoder());

    //     return provider;
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    //     httpSecurity.authorizeHttpRequests(authorise ->{
    //         // authorise.requestMatchers("/admin/home","/admin/register").permitAll();
    //         authorise.requestMatchers("/admin/login", "/css/**", "/js/**").permitAll()    
    //         .requestMatchers("/admin/**").hasRole("ADMIN");
    //         authorise.anyRequest().authenticated();
    //     });


    //    // httpSecurity.formLogin(Customizer.withDefaults());
    //    httpSecurity.csrf(csrf -> csrf.disable());
      

    //     httpSecurity.formLogin(formLogin -> {
    //         formLogin
    //             .loginPage("/admin/login")
    //             //.loginProcessingUrl("/admin/user/process-login")
    //             .defaultSuccessUrl("/admin/home", true)
    //             .successForwardUrl("/admin/home")
    //             .failureUrl("/admin/login?error=true")
    //             .usernameParameter("email")
    //             .passwordParameter("password");

    //     });

        
    //     return httpSecurity.build();
    // }   

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
