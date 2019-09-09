package com.spring.courses.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.courses.model.AddCourse;
import com.spring.courses.model.CourseDetails;
import com.spring.courses.model.MainCategory;

@Repository
@Transactional
public class CoursesDaoImpl implements CoursesDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<MainCategory> getAllCourses() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MainCategory");

		List<MainCategory> courseList = query.list();
		System.out.println(courseList);
		return courseList;
	}

	@SuppressWarnings("unchecked")
	public List getCourses(String courseName) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from " + courseName);

		List courseList = query.list();

		System.out.println(courseList);

		return courseList;
	}

	public void addDetails(long count) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("C:/Users/To-ow-12/Desktop/Data.xlsx"));

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		XSSFSheet sheet = workbook.getSheetAt(0);

		System.out.println("sheet.getLastRowNum()" + sheet.getLastRowNum());
		Row row = null;
		int count1 = (int) count;
		for (int i = count1; i <= sheet.getLastRowNum(); i++) {

			row = sheet.getRow(i);

			int number = 0;
			if (row.getCell(0) != null)
				number = (int) Double.parseDouble(row.getCell(0).toString());
			System.out.println(number);

			String courseName = null;
			if (row.getCell(1) != null)
				courseName = row.getCell(1).toString();

			String description = null;
			if (row.getCell(2) != null)
				description = row.getCell(2).toString();
			Session session = this.sessionFactory.getCurrentSession();

			CourseDetails details = new CourseDetails();
			details.setId(number);
			details.setCourseName(courseName);
			details.setDescription(description);

			// session.saveOrUpdate(excelTable);

			session.saveOrUpdate(details);
			System.out.println("Data Inserted");

			// transaction.commit();
			// session.close();

		}
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CourseDetails> getRecord(String courseName) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseDetails where courseName = :id");
		query.setParameter("id", courseName);

		List<CourseDetails> courseList = query.list();
		System.out.println(courseList);
		return courseList;
	}

	public Long getCount() {

		Long count = null;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from CourseDetails");
		for (Iterator it = query.iterate(); it.hasNext();) {
			count = (Long) it.next();
			System.out.print("Count:gfhfgjhgdkkhkkhgkd: " + count);
		}
		return count;
	}

	@SuppressWarnings("null")
	public void addCourse(AddCourse addcourse) {
		Session session = this.sessionFactory.getCurrentSession();

		String courseName = addcourse.getCategory();
		Query query = session.createSQLQuery(
				"INSERT INTO " + courseName + " (courseName,image,mId,file,filename) VALUES (:courseName, :image, :mId, :file, :filename)");
		query.setParameter("courseName", addcourse.getCourseName());
		query.setParameter("image", addcourse.getImage());
		query.setParameter("file", addcourse.getFile());
		query.setParameter("filename", addcourse.getFilename());

		switch (courseName) {

		case "Adobe":
			query.setParameter("mId", 1);
			break;

		case "Hybris":
			query.setParameter("mId", 2);
			break;
		case "Java":
			query.setParameter("mId", 3);
			break;
		case "Spring":
			query.setParameter("mId", 4);
			break;
		case "Hibernate":
			query.setParameter("mId", 5);
			break;
		case "FrontEndTechnologies":
			query.setParameter("mId", 6);
			break;
		}
		query.executeUpdate();

		System.out.println("Data Inserted");
	}
}
/*
 * AddCourse adobe = null; String courseName = addcourse.getCategory();
 * 
 * switch (courseName) {
 * 
 * case "Adobe": adobe.setsId(addcourse.getsId());
 * adobe.setCourseName(addcourse.getCourseName());
 * adobe.setImage(addcourse.getImage()); adobe.setmId(1);
 * session.saveOrUpdate(adobe);
 * 
 * break; case "Hybris": adobe.setsId(addcourse.getsId());
 * adobe.setCourseName(addcourse.getCourseName());
 * adobe.setImage(addcourse.getImage()); adobe.setmId(2);
 * session.saveOrUpdate(adobe);
 * 
 * break; }
 */
