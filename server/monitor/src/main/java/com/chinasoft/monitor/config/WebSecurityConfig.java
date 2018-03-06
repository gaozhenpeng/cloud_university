package com.chinasoft.monitor.config;

/**
 * Created by VerRan.Liu on 2017/11/21.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")////设置默认登录成功跳转页面
                .permitAll()
                /**设置登陆成功后的跳转页面**/
                .and().formLogin().successForwardUrl("/")
                .and()
                .logout()
                .permitAll()
                //配置跨域访问请求处理器
                .and().csrf().requireCsrfProtectionMatcher(csrfSecurityRequestMatcher())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

       /* 1.首先当我们要自定义Spring Security的时候我们需要继承自WebSecurityConfigurerAdapter来完成，相关配置重写对应 方法即可。
        2.我们在这里注册CustomUserService的Bean，然后通过重写configure方法添加我们自定义的认证方式。
        3.在configure(HttpSecurity http)方法中，我们设置了登录页面，而且登录页面任何人都可以访问，然后设置了登录失败地址
        ，也设置了注销请求，注销请求也是任何人都可以访问的。
        4.permitAll表示该请求任何人都可以访问，.anyRequest().authenticated(),表示其他的请求都必须要有权限认证。
        5.这里我们可以通过匹配器来匹配路径，比如antMatchers方法，假设我要管理员才可以访问admin文件夹下的内容，我可以这样来写：
        .antMatchers("/admin/**").hasRole("ROLE_ADMIN")，也可以设置admin文件夹下的文件可以有多个角色来访问，写法如下：
        .antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
        6.可以通过hasIpAddress来指定某一个ip可以访问该资源,假设只允许访问ip为210.210.210.210的请求获取admin下的资源，写法如下
        .antMatchers("/admin/**").hasIpAddress("210.210.210.210")
        */

//        .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
//                .and()
//                //开启cookie保存用户数据
//                .rememberMe()
//                //设置cookie有效期
//                .tokenValiditySeconds(60 * 60 * 24 * 7)
//                //设置cookie的私钥
//                .key("")
//                .and()
//                .logout()
//                //默认注销行为为logout，可以通过下面的方式来修改
//                .logoutUrl("/custom-logout")
//                //设置注销成功后跳转页面，默认是跳转到登录页面
//                .logoutSuccessUrl("")
//                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }


    private CsrfSecurityRequestMatcher csrfSecurityRequestMatcher(){
        CsrfSecurityRequestMatcher csrfSecurityRequestMatcher = new CsrfSecurityRequestMatcher();
        List<String> list = new ArrayList<String>();
        /**springbootAdmin 添加security 配置后 出现跨域访问问题 无法实现日志在线配置**/
        list.add("/monitor/");//针对请求包含monitor信息的url不进行csrf保护
        csrfSecurityRequestMatcher.setExecludeUrls(list);
        return csrfSecurityRequestMatcher;
    }

/*    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }*/
}