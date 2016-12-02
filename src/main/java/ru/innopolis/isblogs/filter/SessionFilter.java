package ru.innopolis.isblogs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pavel Krohin
 * Класс-фильтр. Запрещает доступ на страницы не авторизованным пользователям.
 */
public class SessionFilter implements Filter {

    private FilterConfig config;

    public SessionFilter() {}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        ServletContext context = config.getServletContext();

        Object u = session.getAttribute("id");
        if (u != null){
            chain.doFilter(request, response);
        }
        else{
            ((HttpServletResponse) response).sendRedirect(((HttpServletResponse) response).encodeRedirectURL("/login"));
        }
    }

    @Override
    public void destroy() {

    }

}
