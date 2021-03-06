package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.auth.handler.LoginSucessHandler;
import pe.edu.upc.serviceimplements.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JpaUserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private LoginSucessHandler sucessHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
					.antMatchers("/reputaciones/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
					.antMatchers("/tipopagos/**").access("hasRole('ROLE_ADMIN')")

					.antMatchers("/tiposubscripciones/**").access("hasRole('ROLE_ADMIN')")
					.antMatchers("/subscripciones/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")

					.antMatchers("/videojuegos/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
					.antMatchers("/insignias/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
					.antMatchers("/partidas/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
					.antMatchers("/emparejamientos/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")

					.antMatchers("/usuarios/**").permitAll()
					.and().formLogin()
					.successHandler(sucessHandler).loginPage("/login").loginProcessingUrl("/login")
					.defaultSuccessUrl("/usuarios/list").permitAll().and().logout().logoutSuccessUrl("/login")
					.permitAll().and().exceptionHandling().accessDeniedPage("/error_403");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
