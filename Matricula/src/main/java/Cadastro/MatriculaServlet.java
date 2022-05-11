package Cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatriculaServlet
 */
@WebServlet("/MatriculaServlet")
public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String matricula = request.getParameter("id");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Cadastro de Aluno </title>");
		out.println("<body>");
		out.println("<h3>Matricula: "+ matricula +"</h3>");
		out.println("<h3>Nome: "+ nome +"</h3>");
		out.println("<h3>Idade: "+ idade +"</h3>");
		out.println("<h3>E-mail: "+ email +"</h3>");
		out.println("<h3>Senha: "+ senha +"</h3>");
		out.println("</body>");
		out.println("</html>");
	}

}
