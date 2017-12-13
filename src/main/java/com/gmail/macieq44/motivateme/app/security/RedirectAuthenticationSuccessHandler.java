package com.gmail.macieq44.motivateme.app.security;

import com.gmail.macieq44.motivateme.app.MotivateMeApplication;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringComponent
@ApplicationScope
public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    private final String location;

    @Autowired
    private VaadinServlet servlet;

    public RedirectAuthenticationSuccessHandler() {
        location = MotivateMeApplication.MAIN_URL;
    }

    private String getAbsoluteUrl(String url) {
        final String relativeUrl;
        if (url.startsWith("/")) {
            relativeUrl = url.substring(1);
        } else {
            relativeUrl = url;
        }
        return servlet.getServletContext().getContextPath() + "/" + relativeUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(getAbsoluteUrl(location));
    }
}
