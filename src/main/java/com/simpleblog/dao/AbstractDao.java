package com.simpleblog.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface AbstractDao<E,I extends Serializable > {

	void saveOrUpdate(E e);
	void delete(E e);
	List<E> findListByCriteria(Criterion criterion);
}
