package com.touchme.agentpay.common.configuration.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: SecurityConfig
 * @description: 自定义安全管理配置
 * @author: chen qing shan
 * @create: 2019/12/4 15:54
 */
@Configuration
@EnableWebSecurity
/**
 * 启用 Spring Security 全局方法
 * prePostEnabled :确定 Spring Security 前置注释 [@PreAuthorize,@PostAuthorize,..] 是否应该启用；
 * secureEnabled : 确定 Spring Security 安全注释 [@Secured] 是否应该启用；
 * jsr250Enabled : 确定 JSR-250注释 [@RolesAllowed..] 是否应该启用；
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/druid/**").permitAll()  //需要忽略的请求链接
                .anyRequest().authenticated();

      /*  http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/druid/**").permitAll()  //需要忽略的请求链接
                .anyRequest().authenticated();*/
    }
}
