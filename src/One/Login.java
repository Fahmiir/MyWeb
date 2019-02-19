package One;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.* ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		final String DB_URL = "jdbc:mysql://localhost:3306/myweb";
		
		String namaDariForm = request.getParameter("name");
		String userPasswordDariForm = request.getParameter("userpassword");
		
		final String USER = "root";
		final String PASS = "";
		response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	        // Open a connection
	        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	        // Execute SQL query
	        Statement stmt = conn.createStatement();
	        String sql;	
	        sql = "SELECT * FROM akun WHERE Username='"+namaDariForm+"' and Password='"+userPasswordDariForm+"';";
	        ResultSet rs=stmt.executeQuery(sql);
	        rs.next();
	        if(rs.getString("Password").equals(userPasswordDariForm)&&rs.getString("Username").equals(namaDariForm)) 
	        { 
	        out.println("Welcome "+namaDariForm);
	        } 
		}
		catch(SQLException se) {
	        //Handle errors for JDBC
	        se.printStackTrace();
	     } catch(Exception e) {
	        //Handle errors for Class.forName
	        e.printStackTrace();
	     }
	}

}
