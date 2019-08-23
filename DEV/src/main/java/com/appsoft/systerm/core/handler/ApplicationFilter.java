package com.appsoft.systerm.core.handler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 单点登录拦截器，只拦截.do的访问
 * 并如果session被销毁，使其返回异常页面
 * @author maybe
 * 
 */

@WebFilter(filterName = "ApplicationFilter")
public class ApplicationFilter implements Filter {

	private final Logger log = LoggerFactory.getLogger(ApplicationFilter.class);
	private static final String ERRORURL = "/html/index.html";

	/**
	 * 
	 * 拦截器处理方法
	 * 
	 */

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();

		if (!uri.equals(ERRORURL)) {

			log.info("进入判断是否只有单点登录");

			String forcedout = (String) request.getSession().getAttribute("forcedout");

			if (null != forcedout && !"".equals(forcedout)) {

				if (forcedout.equals("yes")) {

					log.info("该用户已经在异地重新登录，进入异常提示！");

					response.sendRedirect(ERRORURL);

					return;

				}

			}

		}

		fc.doFilter(req, resp);

	}

	/**
	 * 
	 * 在系统启动时初始化拦截器
	 * 
	 */

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info("系统正在启动----------------");
	}

	/**
	 * 
	 * 在系统停止时销毁拦截器
	 * 
	 */

	@Override

	public void destroy() {
		
	}

}
