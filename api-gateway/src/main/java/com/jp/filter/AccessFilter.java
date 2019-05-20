package com.jp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/20 14:29
 */
public class AccessFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);


    /**
     * filterType 过滤器的类型
     * pre 代表请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder 过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter 过滤器是否需要被执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * ZuulException 过滤器的具体执行逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken  = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("access token is mepty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }else {
            logger.info("access token ok");
        }

        return null;
    }
}
