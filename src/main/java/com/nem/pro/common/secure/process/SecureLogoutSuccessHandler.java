package com.nem.pro.common.secure.process;


import com.nem.pro.common.constant.TokenConstant;
import com.nem.pro.common.secure.uutoken.SecureUserTokenService;
import com.nem.pro.common.tools.core.ServletUtil;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.common.web.domain.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import com.nem.pro.common.context.BaseContext;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security 注销成功处理类
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Component
public class SecureLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private BaseContext context;

    @Autowired
    private SecureUserTokenService customUserDetailsTokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        String token = httpServletRequest.getHeader(TokenConstant.TOKEN_HEADER).replaceFirst(TokenConstant.TOKEN_PREFIX, "");
        customUserDetailsTokenService.destroyToken(token);
        ServletUtil.writeJson(Result.success(ResultCode.LOGOUT_SUCCESS));
    }
}
