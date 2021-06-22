package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Reviews;

public interface ReviewsService {

	int addReviewToProduct(Reviews r, int productId);

	Reviews findById(int id);

	void deleteById(int id);

	public List<Reviews> findByPid(int id);
	public List<Reviews> findByRatingGreaterThan(int rate);
}