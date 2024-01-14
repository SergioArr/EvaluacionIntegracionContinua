package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.LoginDao;
import modelo.Persona;

/**
 * Servlet implementation class ValidadorServlett
 */
public class ValidadorServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String usuario = request.getParameter("usuario");
	    String password = request.getParameter("password");
	    String msg = "";

	    try {
	        if (LoginDao.validarUsuario(usuario, password)) {
	            Persona persona = LoginDao.obtenerInformacionPersona(usuario);

	            if (persona != null) {
	                request.setAttribute("mensaje", "Usuario y Contraseña correctos");
	                request.setAttribute("nombre", persona.getNombre() + " " + persona.getApellido());
	                request.setAttribute("rut", persona.getRut());
	                request.setAttribute("telefono", persona.getTelefono());
	            } else {
	                request.setAttribute("mensaje", "Error al obtener la información de la persona");
	            }
	        } else {
	            request.setAttribute("mensaje", "Revise su Usuario o Contraseña");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("mensaje", "Error en la validación de credenciales");
	    }

	    msg = msg.toUpperCase();

	    RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
	    despachador.forward(request, response);
	}
	
	

}
