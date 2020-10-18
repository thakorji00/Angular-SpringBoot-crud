package com.ciright.cirightcrudxample.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciright.cirightcrudxample.model.CirightEmployeeModel;

@Repository
public class CirightEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	// Add Employee
	public void addEmployee(CirightEmployeeModel employee) {

		try (Session ss = sessionFactory.openSession()) {

			ss.saveOrUpdate(employee);
			ss.beginTransaction().commit();
			ss.clear();
			ss.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public List<CirightEmployeeModel> getAllEmployee() {

		try (Session ss = sessionFactory.openSession()) {
			Criteria ctr = ss.createCriteria(CirightEmployeeModel.class);
			ctr.add(Restrictions.eq("isActive", 1));
			return (List<CirightEmployeeModel>) ctr.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}

	}

	@SuppressWarnings("deprecation")
	public CirightEmployeeModel findByIdEmployee(Integer id) {
		try (Session ss = sessionFactory.openSession()) {
			Criteria ctr = ss.createCriteria(CirightEmployeeModel.class);
			ctr.add(Restrictions.eq("id",id));
			ctr.add(Restrictions.eq("isActive", 1));
			return (CirightEmployeeModel) ctr.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}

	}

	
}
