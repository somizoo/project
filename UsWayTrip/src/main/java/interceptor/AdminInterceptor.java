package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import common.RedirectPath;
import common.ScriptUtil;

public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Integer no = (Integer)request.getSession().getAttribute("login");
		Integer member_role = (Integer)request.getSession().getAttribute("role");
		
		//로그인이 안됐을 때 로그인페이지로 이동
		if(no == null) {
			ScriptUtil.alertAndMovePage(response, "로그인 후 이용가능합니다.", RedirectPath.U_MEMBER + "loginForm");
			return false;
		}
		
		//관리자가 아닐 시 이전페이지로 이동
		if(member_role > 2) {
			ScriptUtil.alertAndBackPage(response, "관리자만 이용가능합니다.");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
	
}
