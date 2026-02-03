package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HipotenusaServlet")
public class HipotenusaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado Hipotenusa</title>");
        // Referencia limpia al CSS externo
        out.println("<link rel='stylesheet' href='estilos.css'>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<h2>Resultado del Cálculo:</h2>");

        if (aParam == null || bParam == null || aParam.isEmpty() || bParam.isEmpty()) {
            out.println("<p>Error: Datos no recibidos correctamente.</p>");
            out.println("<button class='btn btn-volver' onclick=\"history.back()\">Regresar</button>");
        } else {
            double a = Double.parseDouble(aParam);
            double b = Double.parseDouble(bParam);
            double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            out.println("<table>");
            out.println("<tr><th>Cateto A</th><th>Cateto B</th><th>Hipotenusa (C)</th></tr>");
            out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + String.format("%.2f", c) + "</td></tr>");
            out.println("</table>");

            out.println("<br>");
            out.println("<button class='btn btn-volver' onclick=\"window.location.href='Hipotenusa.html'\">Volver</button>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}