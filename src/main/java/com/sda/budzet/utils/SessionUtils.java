package com.sda.budzet.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionUtils {
    public void checkSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cookie cookieSessionTime = null;
        if (request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (cookie.getName().equals(StaticValues.SESSION_TIME_KEY)){
                    cookieSessionTime = cookie;
                    break;
                }
            }
        }
        if (session.getAttribute(StaticValues.SESSION_USER_KEY) == null){
            if (cookieSessionTime != null){
                cookieSessionTime.setMaxAge(900);
                response.addCookie(cookieSessionTime);
            }
            if (!request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/register")){
                response.sendRedirect("./login?error=session_expired");
            }
            return;
        }else{
            if (cookieSessionTime == null){
                session.invalidate();
                response.sendRedirect("./login?error=session_expired");
            }
        }
    }
}
