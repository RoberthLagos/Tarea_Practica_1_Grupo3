package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletConversionBinarios")
public class ServletConversionBinarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String entradaBinario = request.getParameter("entradaBinario");
        String entradaDecimal = request.getParameter("entradaDecimal");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado Conversión</title>");
        out.println("<link rel='stylesheet' href='estilos.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Resultado de la Conversión</h1>");

        if (entradaBinario != null && !entradaBinario.isEmpty()) {
            String binario = entradaBinario;
            int decimal = 0;
            for (int i = 0; i < binario.length(); i++) {
                if (binario.charAt(i) == '1') {
                    decimal += Math.pow(2, binario.length() - 1 - i);
                }
            }
            out.println("<p><b>Operación:</b> Binario a Decimal</p>");
            out.println("<table><tr><th>Entrada (Binario)</th><th>Resultado (Decimal)</th></tr>");
            out.println("<tr><td>" + binario + "</td><td>" + decimal + "</td></tr></table>");

        } else if (entradaDecimal != null && !entradaDecimal.isEmpty()) {
            int decimal = Integer.parseInt(entradaDecimal);
            String binario = Integer.toBinaryString(decimal);
            
            out.println("<p><b>Operación:</b> Decimal a Binario</p>");
            out.println("<table><tr><th>Entrada (Decimal)</th><th>Resultado (Binario)</th></tr>");
            out.println("<tr><td>" + decimal + "</td><td>" + binario + "</td></tr></table>");
        }

        out.println("<br>");
        out.println("<button class='btn btn-volver' onclick=\"window.location.href='Binarios.html'\">Volver</button>");
        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
