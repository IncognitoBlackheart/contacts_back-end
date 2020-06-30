package com.Contacts.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Contacts.model.Contacts;

public class ContactRepository {
	private EntityManagerFactory entityManagerFactory;
	
	public ContactRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory("contactConfig");
	}
	
	public void add(Contacts contact) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(contact);
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
	
	public Contacts edit(Contacts contact) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		Contacts updatedContact = entityManager.find(Contacts.class, contact.getCpf());
		updatedContact.setName(contact.getName());
		try	 {
			transaction.begin();
			contact = entityManager.merge(updatedContact);
			transaction.commit();
		}
		catch(Exception error) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
		return contact;
	}
	
	public List<Contacts> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from " + Contacts.class.getName());
		return query.getResultList();
	}
	
	public void remove(int cpf) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		Contacts delContact = entityManager.find(Contacts.class, cpf);
		try {
			transaction.begin();
			entityManager.remove(delContact);
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
}
