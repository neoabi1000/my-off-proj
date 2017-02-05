<%@page import="com.jsapl.model.Customer"%>
<%@page import="com.jsapl.persistence.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<html>
<body>
	<h2>Hello, Jyothi Spectro</h2>
	<h2>Hello, Santhosh</h2>

	<%
		Session session1 = HibernateUtil.getAppSessionFactory()
				.openSession();

		//Sample Transaction		
		session1.beginTransaction();
		
		Customer cust1 = (Customer)session1.load(Customer.class, new Long(7727621757672095745L));
		
		out.println("Customer name: " + cust1.getName());

		session1.getTransaction().commit();
		session1.close();
	%>
</body>
</html>
