package com.nem.pro.common.secure.process;

import com.nem.pro.common.context.BaseContext;
import com.nem.pro.common.aop.enums.Action;
import com.nem.pro.common.secure.services.SecureUser;
import com.nem.pro.common.secure.uutoken.SecureUserToken;
import com.nem.pro.common.secure.uutoken.SecureUserTokenService;
import com.nem.pro.common.tools.core.ServletUtil;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.common.web.domain.ResultCode;
import com.nem.pro.modules.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Describe: Security 登陆成功处理类
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Component
public class SecureLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private BaseContext context;

    @Autowired
    private SecureUserTokenService customUserDetailsTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
            SysUser sysUser = (SysUser) authentication.getPrincipal();

            SecureUserToken userToken = customUserDetailsTokenService.createToken(sysUser);
            String tokenKey = customUserDetailsTokenService.saveToken(userToken);
            String tokenValue = userToken.getToken();

            // 登 录 日 志
            context.record("登录","登录成功", Action.AUTH, true, "","");

            ServletUtil.writeJson(Result.success(ResultCode.LOGIN_SUCCESS,tokenKey,tokenValue));
    }
}
