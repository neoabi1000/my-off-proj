package com.jsapl.app;

import org.hibernate.Session;

import com.jsapl.model.CustomerType;
import com.jsapl.model.TestCategory;
import com.jsapl.model.TestType;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.util.CUID;

public class AddTestCategoriesAndTypes {
	
	public static void main(String[] args) {
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
		testType.setId(CUID.getInstance().nextId());
		testType.setCategory(chemicalCategory);
		testType.setName("Spectro");
		testType.setDescription("Sample Description for Spectro");
		
		TestType testType1 = new TestType();
		testType1.setId(CUID.getInstance().nextId());
		testType1.setCategory(chemicalCategory);
		testType1.setName("Edxrf");
		testType1.setDescription("Sample Description for Edxrf");
		
		TestType testType2 = new TestType();
		testType2.setId(CUID.getInstance().nextId());
		testType2.setCategory(chemicalCategory);
		testType2.setName("Coating");
		testType2.setDescription("Sample Description for Coating");
		
		
		
		TestType testType3 = new TestType();
		testType3.setId(CUID.getInstance().nextId());
		testType3.setCategory(mechanicalCategory);
		testType3.setName("Tensile");
		testType3.setDescription("Sample Description for Tensile");
		
		TestType testType4 = new TestType();
		testType4.setId(CUID.getInstance().nextId());
		testType4.setCategory(mechanicalCategory);
		testType4.setName("Hardness");
		testType4.setDescription("Sample Description for Hardness");
		
		TestType testType5 = new TestType();
		testType5.setId(CUID.getInstance().nextId());
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
