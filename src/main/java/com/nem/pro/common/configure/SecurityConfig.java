package com.nem.pro.common.configure;

import com.nem.pro.common.constant.SecurityConstant;
import com.nem.pro.common.secure.captcha.SecureCaptchaSupport;
import com.nem.pro.common.secure.process.*;
import com.nem.pro.common.secure.uutoken.SecureUserTokenSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Security 安全核心配置类
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/04/01
 * */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义登陆成功处理器
     * */
    private static SecureLoginSuccessHandler secureAuthenticationSuccessHandler;
    @Resource
    public void setSecureLoginSuccessHandler(SecureLoginSuccessHandler secureAuthenticationSuccessHandler) {
        SecurityConfig.secureAuthenticationSuccessHandler = secureAuthenticationSuccessHandler;
    }
    /**
     * 自定义登陆失败处理器
     * */
    private static SecureLoginFailureHandler secureAuthenticationFailureHandler;
    @Resource
    public void setSecureLoginFailureHandler(SecureLoginFailureHandler secureAuthenticationFailureHandler) {
        SecurityConfig.secureAuthenticationFailureHandler = secureAuthenticationFailureHandler;
    }
    /**
     * 自定义注销成功处理器
     * */
    private static SecureLogoutSuccessHandler secureLogoutSuccessHandler;
    @Resource
    public void setBSecureLogoutSuccessHandler(SecureLogoutSuccessHandler secureLogoutSuccessHandler) {
        SecurityConfig.secureLogoutSuccessHandler = secureLogoutSuccessHandler;
    }
    /**
     * 自定义暂无权限处理器
     * */
    private static SecureNoPermissionHandler secureAuthAccessDeniedHandler;
    @Resource
    public void setSecureNoPermissionHandler(SecureNoPermissionHandler secureAuthAccessDeniedHandler) {
        SecurityConfig.secureAuthAccessDeniedHandler = secureAuthAccessDeniedHandler;
    }
    /**
     * 自定义未登录的处理器
     * */
    private static SecureNoAuthenticationHandler secureAuthenticationEntryPointHandler;
    @Resource
    public void setSecureNoAuthenticationHandler(SecureNoAuthenticationHandler secureAuthenticationEntryPointHandler) {
        SecurityConfig.secureAuthenticationEntryPointHandler = secureAuthenticationEntryPointHandler;
    }

    /**
     * 密码加密方式
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Web Configure 核心配置
     * */
    @Override
    public void configure(WebSecurity web) {
        // TODO 解决静态资源被拦截的问题
        web.ignoring().antMatchers(SecurityConstant.WEB_ACT_MATCHERS.split(","));
    }

    /**
     * Http Security 核心配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //不进行权限验证的请求或资源(从配置文件中读取)
                .antMatchers(SecurityConstant.HTTP_ACT_MATCHERS.split(",")).permitAll()
                //其他的需要登陆后才能访问
                .anyRequest().authenticated()
                .and()
                //配置未登录自定义处理类
                .httpBasic().authenticationEntryPoint(secureAuthenticationEntryPointHandler)
                .and()
                //配置登录地址
                .formLogin()
                .loginProcessingUrl(SecurityConstant.LOGIN_URL)
                //配置登录成功自定义处理类
                .successHandler(secureAuthenticationSuccessHandler)
                //配置登录失败自定义处理类
                .failureHandler(secureAuthenticationFailureHandler)
                .and()
                //配置登出地址
                .logout()
                .logoutUrl(SecurityConstant.LOGOUT_URL)
                //配置用户登出自定义处理类
                .logoutSuccessHandler(secureLogoutSuccessHandler)
                .and()
                //配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(secureAuthAccessDeniedHandler)
                .and()
                // 取消跨站请求伪造防护
                .csrf()
                .disable();

        // 处理 Iframe 响应
        http.headers().frameOptions().disable();

        // 基于 Token 不需要 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Captcha / Token 过滤器
        http.addFilterBefore(new SecureUserTokenSupport(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new SecureCaptchaSupport(), UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        http.headers().cacheControl();

        // 开启 Security 跨域
        http.cors();
    }
}