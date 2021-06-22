package com.rakuten.training.dal;

import java.util.List;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Reviews;

@Repository
@Transactional
public class ReviewsDAOJpaImpl implements ReviewsDAO {
	
	@Autowired
	EntityManager em;

	@Override
	public Reviews save(Reviews toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}


	@Override
	public Reviews findById(int id) {
		return em.find(Reviews.class, id);
	}

	@Override
	public void deleteById(int id) {
		Reviews r=em.find(Reviews.class, id);
		if(r!=null)
		{
			em.remove(r);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> findByPid(int productId) {
		Query q = em.createQuery("select r from Reviews r where r.product.id=:x");
		q.setParameter("x", productId);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> findByRatingGreaterThan(int rating) {
		Query q = em.createQuery("select r from Reviews r where r.rating>=:x");
		q.setParameter("x", rating);
		return q.getResultList();
	}

	
//	 In ReviewDAO, create the following query methods :
//
//	 findByPid(int productId)
//	 findByRatingGreaterThanAndPid(int rating,int pid)
}
