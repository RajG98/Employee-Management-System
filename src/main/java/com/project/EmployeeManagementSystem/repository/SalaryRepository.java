package com.project.EmployeeManagementSystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.EmployeeManagementSystem.model.Salary;
import com.project.EmployeeManagementSystem.util.HibernateUtil;



public class SalaryRepository {
	static Transaction transaction=null;
	public static Salary checkSalary(int id) {
		try{
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		Salary sal=session.get(Salary.class,id);
    		if(sal!=null) return sal;
    		transaction.commit();
    	}catch(Exception ex) {
    		if(transaction!=null) transaction.rollback();
    		ex.printStackTrace();
    	}
		return null;
	}
	public static void addSalary(Salary s){
		try{
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.persist(s);
    		
    		transaction.commit();
    	}catch(Exception ex) {
    		if(transaction!=null) transaction.rollback();
    		ex.printStackTrace();
    	}
    }
    public static List<Salary> viewSalary() {
    	List<Salary> salary=null;
    	try {
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		String hql="from Salary";
    		Query<Salary>  query= session.createQuery(hql, Salary.class);
    		salary= query.getResultList();
    		transaction.commit();
    	}catch(Exception ex) {
    		if(transaction!=null) transaction.rollback();
    		ex.printStackTrace();
    	}
    	return salary;
    }

    public static void updateSalary(Salary s,int id){
    	try {
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		transaction=session.beginTransaction();
    		Salary sal= session.get(Salary.class, id);
    		if(sal!=null) {
    			sal.setEmployee(s.getEmployee());
    			sal.setSalary_amount(s.getSalary_amount());
    			sal.setPayment_date(s.getPayment_date());
    		}
    		transaction.commit();
    	}catch(Exception ex) {
    		if(transaction!=null) transaction.rollback();
    		ex.printStackTrace();
    	}
    }
    public static void deleteSalary(Salary s){
        try {
        	Session session= HibernateUtil.getSessionFactory().openSession();
        	transaction=session.beginTransaction();
        	session.remove(s);
        	transaction.commit();
        }catch(Exception ex) {
        	if(transaction!=null) transaction.rollback();
        	ex.printStackTrace();
        }
    }
}
