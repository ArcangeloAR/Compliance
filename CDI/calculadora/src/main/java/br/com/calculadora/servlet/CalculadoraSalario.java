package br.com.calculadora.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.calculadora.model.CalculadoraDeSalarios;

@WebServlet("/calcular-salario")
public class CalculadoraSalario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CalculadoraDeSalarios calculadoraDeSalarios;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getOutputStream().print("Calculadora: " + calculadoraDeSalarios.getClass());
	}
}
