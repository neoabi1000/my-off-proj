package com.jsapl.app;

import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.CustomerContact;
import com.jsapl.model.CustomerType;
import com.jsapl.model.Sample;
import com.jsapl.model.TestCategory;
import com.jsapl.model.TestType;
import com.jsapl.model.WorkOrder;
import com.jsapl.model.WorkOrderSample;
import com.jsapl.model.WorkOrderSampleTest;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.util.CUID;

public class TestData {

	public static void main(String[] args) {
		createWorkOrder();
	}


	public static void createWorkOrder(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//1st Transaction		
		session.beginTransaction();

		Customer customer = (Customer)session.load(Customer.class, new Long(7727621757672095745L));
		Sample sample = (Sample)session.load(Sample.class, new Long(7728653054506958849L));
		
		WorkOrder wrkOrder = new WorkOrder();
		wrkOrder.setId(CUID.getInstance().nextId());
		wrkOrder.setCustomer(customer);
		wrkOrder.setClientInfo("Self");
		wrkOrder.setAdvancePaid(0);
		//wrkOrder.setCreated(new Date(Calendar.getInstance().getTimeInMillis()));
		//wrkOrder.setUpdated(new Date(Calendar.getInstance().getTimeInMillis()));
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 03, 01);
		wrkOrder.setDateCommited(new Date(calendar.getTimeInMillis()));
		wrkOrder.setDescription("I pray god that this works fine");
		wrkOrder.setStatus(WorkOrder.Status.New);
		
		WorkOrderSample workOrderSample = new WorkOrderSample();
		workOrderSample.setId(CUID.getInstance().nextId());
		workOrderSample.setWorkOrderId(wrkOrder.getId());
		workOrderSample.setSampleId(sample.getSampleId());
		
		
		WorkOrderSampleTest workOrderSampleTest1 = new WorkOrderSampleTest();
		workOrderSampleTest1.setWorkOrderSampleId(workOrderSample.getId());
		workOrderSampleTest1.setTestTypeId(1L);
		workOrderSampleTest1.setRequiredSpecification("XYZ required Spec");
		workOrderSampleTest1.setComments("Blah...blah...blah...");
		
		WorkOrderSampleTest workOrderSampleTest2 = new WorkOrderSampleTest();
		workOrderSampleTest2.setWorkOrderSampleId(workOrderSample.getId());
		workOrderSampleTest2.setTestTypeId(2L);
		workOrderSampleTest2.setRequiredSpecification("XYZ required Spec");
		workOrderSampleTest2.setComments("Blah...blah...blah...");
		
		workOrderSample.getWorkOrderSampleTests().add(workOrderSampleTest1);
		workOrderSample.getWorkOrderSampleTests().add(workOrderSampleTest2);
		
		wrkOrder.getWorkOrderSamples().add(workOrderSample);
		
		session.save(wrkOrder);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}


	public static void createSamples(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//1st Transaction		
		session.beginTransaction();

		Customer customer = (Customer)session.load(Customer.class, new Long(7727621757672095745L));
		
		Sample sample = new Sample();
		sample.setSampleId(CUID.getInstance().nextId());
		sample.setCustomer(customer);
		sample.setToBeReturned(true);
		sample.setForm(Sample.Form.Powder);
		sample.setReceivedDate(new Date(Calendar.getInstance().getTime().getTime()));
		sample.setStamping("CARVED WITH BIPIN");
		sample.setStatus(Sample.Status.Received);
		
		session.save(sample);


		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}

	public static void createCustomer(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//1st Transaction		
		session.beginTransaction();


		CustomerType customerType = (CustomerType)session.load(CustomerType.class, new Integer(1));

		Customer cust1 = new Customer();
		cust1.setCustId(CUID.getInstance().nextId());
		cust1.setName("Customer ABC");
		cust1.setPan("AKUPB9629G");
		cust1.setPhone("+91 9878987878787");
		cust1.setCustomerType(customerType);
		cust1.getContacts().add(new CustomerContact("Clark", "Clark@kony.com", "+19898998"));
		cust1.getContacts().add(new CustomerContact("Cheryl", "Cheryl@kony.com", "29784735"));
		session.save(cust1);
		session.getTransaction().commit();



		//2nd transaction
		session.beginTransaction();


		Sample sample1 = new Sample();
		sample1.setSampleId(CUID.getInstance().nextId());
		sample1.setCustomer(cust1);
		sample1.setForm(Sample.Form.Wires);
		sample1.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample1.setRequiredSpecification("IS 713-1981 Gr: ZnAl4Cu1");
		sample1.setSize(10);
		sample1.setStatus(Sample.Status.Received);

		Sample sample2 = new Sample();
		sample2.setSampleId(CUID.getInstance().nextId());
		sample2.setCustomer(cust1);
		sample2.setForm(Sample.Form.Powder);
		sample2.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample2.setRequiredSpecification("IS 713-1981 Gr: kcjahsj");
		sample2.setSize(1);
		sample2.setStatus(Sample.Status.Received);

		Sample sample3 = new Sample();
		sample3.setSampleId(CUID.getInstance().nextId());
		sample3.setCustomer(cust1);
		sample3.setForm(Sample.Form.Pipe);
		sample3.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample3.setRequiredSpecification("IS 950-19");
		sample3.setSize(50);
		sample3.setStatus(Sample.Status.Used);

		session.save(sample1);
		session.save(sample2);
		session.save(sample3);


		session.getTransaction().commit();






		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}

	public static void createCustomerTypes(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Sample Transaction		
		session.beginTransaction();


		CustomerType customerType1 = new CustomerType("Platinum", 200_000);
		CustomerType customerType2 = new CustomerType("Gold", 100_000);
		CustomerType customerType3 = new CustomerType("Silver", 25_000);
		CustomerType customerType4 = new CustomerType("Bronze", 5_000);
		CustomerType customerType5 = new CustomerType("Walk-in", 0);

		session.save(customerType1);
		session.save(customerType2);
		session.save(customerType3);
		session.save(customerType4);
		session.save(customerType5);




		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}

	public static void createTests(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Sample Transaction		
		session.beginTransaction();


		TestCategory chemicalCategory = new TestCategory();
		chemicalCategory.setCategory("Chemical");

		TestCategory mechanicalCategory = new TestCategory();
		mechanicalCategory.setCategory("Mechanical");

		TestCategory ndCategory = new TestCategory();
		ndCategory.setCategory("Non-Destructive");

		TestCategory metallographyCategory = new TestCategory();
		metallographyCategory.setCategory("Metallography");

		TestCategory miscCategory = new TestCategory();
		miscCategory.setCategory("Misc");


		TestType testType = new TestType();
		//testType.setTestTypeId(CUID.getInstance().nextId());
		testType.setCategory(chemicalCategory);
		testType.setName("Spectro");
		testType.setDescription("Sample Description for Spectro");

		TestType testType1 = new TestType();
		//testType1.setTestTypeId(CUID.getInstance().nextId());
		testType1.setCategory(chemicalCategory);
		testType1.setName("Edxrf");
		testType1.setDescription("Sample Description for Edxrf");

		TestType testType2 = new TestType();
		//testType2.setTestTypeId(CUID.getInstance().nextId());
		testType2.setCategory(chemicalCategory);
		testType2.setName("Coating");
		testType2.setDescription("Sample Description for Coating");



		TestType testType3 = new TestType();
		//testType3.setTestTypeId(CUID.getInstance().nextId());
		testType3.setCategory(mechanicalCategory);
		testType3.setName("Tensile");
		testType3.setDescription("Sample Description for Tensile");

		TestType testType4 = new TestType();
		//testType4.setTestTypeId(CUID.getInstance().nextId());
		testType4.setCategory(mechanicalCategory);
		testType4.setName("Hardness");
		testType4.setDescription("Sample Description for Hardness");

		TestType testType5 = new TestType();
		//testType5.setTestTypeId(CUID.getInstance().nextId());
		testType5.setCategory(mechanicalCategory);
		testType5.setName("Bend");
		testType5.setDescription("Sample Description for Bend");



		session.save(chemicalCategory);
		session.save(mechanicalCategory);
		session.save(ndCategory);
		session.save(metallographyCategory);
		session.save(miscCategory);

		session.save(testType);
		session.save(testType1);
		session.save(testType2);
		session.save(testType3);
		session.save(testType4);
		session.save(testType5);


		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}


}
