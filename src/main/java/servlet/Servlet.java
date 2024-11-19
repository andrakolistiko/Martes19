package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuración de cabecera
        resp.setContentType("text/html; charset=UTF-8");

        // Recopilación de datos de la solicitud
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        int port = req.getServerPort();
        String scheme = req.getScheme();
        String host = req.getServerName();
        String url = scheme + "://" + host + ":" + port + contextPath + servletPath;

        // Envío de la respuesta al cliente
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Cabeceros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Información del Servlet</h1>");
            out.println("<ul>");
            out.println("<li>Método HTTP utilizado: " + metodoHttp + "</li>");
            out.println("<li>Request URI: " + requestURI + "</li>");
            out.println("<li>Request URL: " + requestURL + "</li>");
            out.println("<li>Context Path: " + contextPath + "</li>");
            out.println("<li>Servlet Path: " + servletPath + "</li>");
            out.println("<li>Dirección IP del servidor: " + ip + "</li>");
            out.println("<li>Puerto del servidor: " + port + "</li>");
            out.println("<li>Esquema: " + scheme + "</li>");
            out.println("<li>Host: " + host + "</li>");
            out.println("<li>URL completa: " + url + "</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
