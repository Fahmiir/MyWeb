package One;

import java.io.IOException;
import java.sql.* ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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
    
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost:3306/myweb";
	      
	Start orang = new Start();
	
	String namaDariForm = request.getParameter("username");
	String emailDariForm = request.getParameter("email");
	String passwordDariForm = request.getParameter("password");
	//String retypepaswordDariForm = request.getParameter("retypepassword");
	
	final String USER = "root";
	final String PASS = "";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // Open a connection
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Execute SQL query
        Statement stmt = conn.createStatement();
        String sql;
        sql = "INSERT INTO akun (Username, Email, Password) VALUES ('"+namaDariForm+"','"+emailDariForm+"','"+passwordDariForm+"');";
        int rs = stmt.executeUpdate(sql);
    	}
	catch(SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
     } catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
     }
//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/LoginRegister.jsp");
//	requestDispatcher.forward(request,response);
	//response.sendRedirect("/WEB-INF/LoginRegister.jsp");

	}

}
