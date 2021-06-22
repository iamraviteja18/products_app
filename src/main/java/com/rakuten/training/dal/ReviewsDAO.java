package com.rakuten.training.dal;

import java.util.ArrayList;
import java.util.List;

import com.rakuten.training.domain.Reviews;

public interface ReviewsDAO {
	
	public Reviews save(Reviews r);
	//public List<Reviews> findAll();
	public Reviews findById(int id);
	public void deleteById(int id);
	
	public default List<Reviews> findByPid(int pid){ return new ArrayList<>();	}
	public default List<Reviews> findByRatingGreaterThan(int rating){ return new ArrayList<>();	}

}
