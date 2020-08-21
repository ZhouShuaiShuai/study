package com.zhouyf.learn.config;

import com.zhouyf.learn.utils.ResponseUtils;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Session过期处理策略
 *
 * @author Logan
 * @createDate 2019-02-13
 * @version 1.0.0
 *
 */
public class SessionInformationExpiredStrategyImpl implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

        ResponseUtils.write(event.getResponse(), "你的账号在另一地点被登录");
    }

}
