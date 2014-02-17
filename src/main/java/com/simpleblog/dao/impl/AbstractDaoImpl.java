package com.simpleblog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import com.simpleblog.dao.AbstractDao;

public abstract class AbstractDaoImpl<E,I extends Serializable> implements AbstractDao<E,I>{

	private Class<E> entityClass;

	@Autowired
	public SessionFactory sessionFactory;

	
	public AbstractDaoImpl(Class<E> entityClass ) {
	       this.entityClass = entityClass;
	       
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
    }
	
	@Override
	public void saveOrUpdate(E e) {
		getCurrentSession().saveOrUpdate(e);
		
	}
	
	@Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findListByCriteria(Criterion criterion) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
	}

}
