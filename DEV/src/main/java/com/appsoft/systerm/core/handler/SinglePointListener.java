package com.appsoft.systerm.core.handler;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appsoft.systerm.core.yh.LoginUser;

/**
 * 
 * 单点登录
 * 
 * 监控session中属性user的变化
 * 
 * HttpSessionAttributeListener 监听session范围内属性变化
 * 
 * @author maybe
 *
 * 
 * 
 */

@WebListener
public class SinglePointListener implements HttpSessionAttributeListener {

	// key:username value:session，用于存放已经登录的用户的session
	private final Logger log = LoggerFactory.getLogger(SessionListener.class);
	public static Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	/**
	 * 
	 * 当属性增加时，触发该方法
	 * 
	 */

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

		LoginUser user = (LoginUser) httpSessionBindingEvent.getSession().getAttribute("userid");

		if (user != null) {// 登录时需要把user信息放入session以供后续使用。session其他值得变化，不在本方法考虑范围内，

			if (SinglePointListener.map != null) {

				if (SinglePointListener.map.containsKey(user.getUserId())) { // 存在key，把之前的session失效，

					log.info("map中存在key={},取出sessionOld清空数据，并设置属性forcedout强制下线");

					HttpSession sessionOld = SinglePointListener.map.get(user.getUserId());

					if (sessionOld != null) {

						Enumeration<?> e = sessionOld.getAttributeNames();

						while (e.hasMoreElements()) {

							String sessionKeyName = (String) e.nextElement();

							sessionOld.removeAttribute(sessionKeyName);

						}

						sessionOld.setAttribute("forcedout", "yes");

					}

				}

			}

			SinglePointListener.map.put(user.getUserId(), httpSessionBindingEvent.getSession());// 最后把这次的user和session放入map以供后续比对。

		}

	}

	@Override

	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	@Override

	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
