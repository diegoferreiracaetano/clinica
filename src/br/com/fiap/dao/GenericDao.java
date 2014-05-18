package br.com.fiap.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class GenericDao<T extends Serializable> implements Dao<T>{

	List<T> lista;


	EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
	EntityManager entityManager = emf.createEntityManager();
	
	public GenericDao() {
		
	}

	public List<T> findAll() {

		lista = entityManager.createQuery(("FROM " + getGenericClass().getName())).getResultList();
		if(lista.size() > 0){
			entityManager.close();
			return lista;
		}else{
			entityManager.close();
			return null;
		}
	}
	
	@Override
	public List<T> findEspecific(Integer id) {
		Query query = entityManager.createQuery(("FROM " + getGenericClass().getName()+" WHERE id = :paramId "));
		query.setParameter("paramId", id);
		
		lista = query.getResultList();
		
		if(lista.size() > 0){
			entityManager.close();
			return lista;
		}else{
			entityManager.close();
			return null;
		}
	}
	
	@Override
	public void delete(Integer primaryKey) {
		entityManager = getEntityManager();
		try{
			T entity = (T) entityManager.find(getGenericClass(), primaryKey);
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(">> "+e.getMessage());
		}
		finally {
			entityManager.close();
	    }
	}

	@Override
	public T findById(Integer primaryKey) {
		
		try {
		      //Consulta um Cliente pelo seu ID.
			entityManager = getEntityManager();	
			entityManager.getTransaction().begin();
			return (T) entityManager.find(getGenericClass(), primaryKey);
	
		}catch (Exception e) {
			System.out.println("teste");
			return null;
		}finally {
		    entityManager.close();
		}
	}
	
	@Override
    public void update(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
    }
	

	public EntityManager getEntityManager() {
		if(entityManager == null || !(entityManager.isOpen())){
			return ((EntityManagerFactory) entityManager).createEntityManager();
		}
		return entityManager;
	}

	 private Class<?> getGenericClass() {
	        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[0];
	        return clazz;
	    }
	 
	@Override
	public void insert(T entity) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		} 
	}
	
}
