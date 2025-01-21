package com.cashdeskmodule.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomHeaderHandlerInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getHeader("FIB-X-AUTH") == null || !request.getHeader("FIB-X-AUTH").equals("f9Uie8nNf112hx8s")) {

			response.getWriter().write("You are not authorized to access this endpoint!");
			response.setStatus(401);

			return false;
		}

		return true;
	}
}
