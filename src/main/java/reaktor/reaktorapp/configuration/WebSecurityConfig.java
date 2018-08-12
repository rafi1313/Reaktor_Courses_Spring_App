package reaktor.reaktorapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/studentsListPage").hasAnyAuthority("ADMIN")
                .antMatchers("/addEditionPage").hasAnyAuthority("ADMIN")
                .antMatchers("/editStudentsPage").hasAnyAuthority("ADMIN")
                .antMatchers("/userProfile").hasAnyAuthority("ADMIN","USER")
        .anyRequest().permitAll()
        .and()
        .csrf().disable()
        .formLogin()
        .loginPage("/login")
        .usernameParameter("email")
        .passwordParameter("password")
        .loginProcessingUrl("/login-process")
        .failureUrl("/errorLogin")
        .defaultSuccessUrl("/")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, u.active FROM user u WHERE u.email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, u.role FROM user u WHERE u.email = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
