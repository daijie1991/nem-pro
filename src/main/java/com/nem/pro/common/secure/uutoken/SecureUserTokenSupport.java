package com.nem.pro.common.secure.uutoken;

import com.nem.pro.common.constant.SecurityConstant;
import com.nem.pro.common.constant.TokenConstant;
import com.nem.pro.common.context.BeanContext;
import com.nem.pro.common.secure.services.SecureUser;
import com.nem.pro.common.tools.core.PatternUtil;
import com.nem.pro.common.tools.core.ServletUtil;
import com.nem.pro.common.web.auth.token.TokenExpiredException;
import com.nem.pro.common.web.auth.token.TokenValidationException;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.common.web.domain.ResultCode;
import com.nem.pro.modules.sys.domain.SysUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Token Filter 主要增加 Token 的验证
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/27
 * */
public class SecureUserTokenSupport extends OncePerRequestFilter {

    @Resource
    private BeanContext beanContext;

    private SecureUserTokenService customUserDetailsTokenService;

    public SecureUserTokenSupport(){
        // Secure Details
        this.customUserDetailsTokenService = beanContext.getBean("secureUserTokenService", SecureUserTokenService.class);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(TokenConstant.TOKEN_HEADER);
        String tokenHeaderKey = request.getHeader(TokenConstant.TOKEN_HEADER_KEY);
        // token param verify empty
        if (tokenHeader == null) { ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_MISSION)); return;}
        // token verify
        SysUser sysUser;
        try {
            SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenHeaderKey,tokenHeader.replaceFirst(TokenConstant.TOKEN_PREFIX, ""));
            sysUser = userToken.getSysUser();
        }catch (TokenValidationException e){
            ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_INVALID)); return;
        }catch (TokenExpiredException e){
            ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_EXPIRED)); return;
        }
        // return UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(sysUser, sysUser.getId(), sysUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }


    // TODO 修正匹配策略
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        List<String> pattern = Arrays.asList(SecurityConstant.HTTP_ACT_MATCHERS.split(","));
        return PatternUtil.matches(pattern, ServletUtil.getRequestURI());
    }
}
