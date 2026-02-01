package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalcularNumeroMayor")
public class CalcularNumeroMayor extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Obtener parámetros
        String n1Param = request.getParameter("N1");
        String n2Param = request.getParameter("N2");
        String n3Param = request.getParameter("N3");

        // Conversión de String a int
        int num1 = Integer.parseInt(n1Param);
        int num2 = Integer.parseInt(n2Param);
        int num3 = Integer.parseInt(n3Param);

        // --- LÓGICA DE COMPARACIÓN ---
        
        // Encontrar el Mayor
        int nmayor = num1;
        if (num2 > nmayor) nmayor = num2;
        if (num3 > nmayor) nmayor = num3;

        // Encontrar el Menor
        int nmenor = num1;
        if (num2 < nmenor) nmenor = num2;
        if (num3 < nmenor) nmenor = num3;

        // Lógica de Repetidos mejorada
        String repetido = "No hay repetidos";
        if (num1 == num2 && num1 == num3) {
            repetido = "Todos son iguales (" + num1 + ")";
        } else if (num1 == num2 || num1 == num3) {
            repetido = String.valueOf(num1);
        } else if (num2 == num3) {
            repetido = String.valueOf(num2);
        }

        // --- HTML DE RESPUESTA ---
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado - Mayor, Menor y Repetido</title>");
        // Referencia limpia al CSS externo
        out.println("<link rel='stylesheet' href='estilos.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<h2>Resultado del Análisis:</h2>");
        out.println("<p>Datos de entrada: <b>" + num1 + ", " + num2 + ", " + num3 + "</b></p>");

        out.println("<div class='result-box'>");
        out.println("<h5>Número Mayor: " + nmayor + "</h5>");
        out.println("<h5>Número Menor: " + nmenor + "</h5>");
        out.println("<h5>Valor Repetido: " + repetido + "</h5>");
        out.println("</div>");

        out.println("<button class='btn-volver' onclick=\"window.location.href='NMayor.html'\">Volver</button>");

        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}