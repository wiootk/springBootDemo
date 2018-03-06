package tk.wioo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import tk.wioo.biz.sys.CustomUserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }
    //注册CustomUserService的Bean，通过重写configure方法添加我们自定义的认证方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html");
    }




    //设置了登录页面，登录失败地址，设置注销请求,permitAll:任何人都可以访问
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().logoutSuccessUrl("/login").permitAll().and();
////        http.authorizeRequests()
////                //.anyRequest().authenticated(),其他的请求都必须要有权限认证
////                .anyRequest().authenticated()
////                //管理员才可以访问admin文件夹下的内容
////                .antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
////                //只允许访问ip为210.210.210.210的请求获取admin下的资源
////                .antMatchers("/admin/**").hasIpAddress("210.210.210.210")
////                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index").failureUrl("/login?error").permitAll().and()
////                //开启cookie保存用户数据
////                .rememberMe()
////                //设置cookie有效期
////                .tokenValiditySeconds(60 * 60 * 24 * 7)
////                //设置cookie的私钥
////                .key("test").and()
////                //修改默认注销行为(logout),注销成功后跳转页面(默认:登录页面)
////                .logout().logoutUrl("/custom-logout").logoutSuccessUrl("/index").permitAll() ;
    }
}