package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Productos;
import servicios.ProductoService;
import servicios.ProductosServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/producto.xls","/productohmtl"})
public class Controlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService servicios =new ProductosServiceImplement();
            List<Productos> productos =servicios.listar();
            //obtener el servlet path
        String servletpath = req.getServletPath();
        boolean xls = servletpath.equals(".xls");
        if(xls){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-disposition", "attachment; filename=producto.xls");


        }
            PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Cabeceros</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Información del Servlet</h1>");
        out.println("<table border=1>");
        out.println("<thead><td>id</td><td>nombre</td><td>categoria</td><td>precio</td></thead>");

        productos.forEach(productos1 -> {
            out.println("<tr>");
            out.println("<td>"+ productos1.getIdProducto()+"</td>");
            out.println("<td>"+ productos1.getNombre()+"</td>");
            out.println("<td>"+ productos1.getCategoria()+"</td>");
            out.println("<td>"+ productos1.getPrecio()+"</td>");
            out.println("</tr>");


        });

        out.println("</table>");
        out.println("<a href=\"index.html\">Volver</a>");
        out.println("<p><a href=\"" +req.getContextPath() +"/producto.xls"+"\">Descargar Excel"+"</a></p>");

        out.println("</body>");
        out.println("</html>");


    }
}
