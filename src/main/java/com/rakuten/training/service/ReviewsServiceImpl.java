package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ReviewsDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;

@Service
@Transactional
public class ReviewsServiceImpl implements ReviewsService {
	
	@Autowired
	ReviewsDAO reviewDAO;
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public int addReviewToProduct(Reviews r, int productId) {
		Product p = productDAO.findById(productId);
		r.setProduct(p);
		reviewDAO.save(r);
		return r.getId();
		
	}

	@Override
	public Reviews findById(int id) {
		return reviewDAO.findById(id);
	}

	@Override
	public void deleteById(int id) {
		reviewDAO.deleteById(id);
	}
	@Override
	public List<Reviews> findByPid(int productId) {
		
		return reviewDAO.findByPid(productId);
	}

	@Override
	public List<Reviews> findByRatingGreaterThan(int rate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
