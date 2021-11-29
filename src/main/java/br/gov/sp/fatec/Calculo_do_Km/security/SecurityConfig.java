package br.gov.sp.fatec.Calculo_do_Km.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) /* habilita seguranca por anotacao*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired /* Pega o contexto de configuracao do SegurançaService devido o extends*/
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() /* desabilita metodo de segurança por token gerenciado pelo proprio spring (gerando as paginas html)*/
        .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // entre uma requição e outra não utilizar a mesma area de memoria (sem reaproveitar cache)
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { /* como o spring realiza a autenticacao/login */
        auth.userDetailsService(userDetailsService);
    } 

    @Bean /*disponibliza para o spring, usar o @Autowired (usar em outros lugares) devido ser um classe gerenciada pelo proprio Spring*/
    public PasswordEncoder passwordEncoderBean() { 
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override /* Por padrao o spting nao deixa disponivel, por isso a anotacao @bean */
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }
}
