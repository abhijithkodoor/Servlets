package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpSalary
 */
@WebServlet("/EmpSalary")
public class EmpSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String ename=request.getParameter("n1");
		String grade=request.getParameter("g1");
		double bonus=0.0,tax,netSalary;
		
		double basic=Double.parseDouble(request.getParameter("s1"));
		if(basic>100000 && grade.equals("A"))
			bonus=basic*0.05;
		else if(basic>50000 && grade.equals("B"))
			bonus=basic*0.07;
		else if(basic<50000 && grade.equals("C"))
			bonus=basic*0.2;
		
		tax=basic*0.25;
		netSalary=basic+bonus-tax;
		pw.println("<pre>Emoloyee Name    :"+ename+"</pre><br>");
		pw.println("<pre>Basic Salary     :"+basic+"</pre><br>");
		pw.println("<pre>Bonus            :"+bonus+"</pre><br>");
		pw.println("<pre>Tax              :"+tax+"</pre><br>");
		pw.println("<pre>Net Salary       :"+netSalary+"</pre><br>");


			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
