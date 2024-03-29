package com.rakuten.training.domain;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reviews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String reviewer;
	String details;
	int rating;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pid")
	Product product;
	
	
	public Reviews() {
		
	}

	public Reviews(String reviewer, String details, int rating) {
		super();
		this.reviewer = reviewer;
		this.details = details;
		this.rating = rating;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", reviewer=" + reviewer + ", details=" + details + ", rating=" + rating
				+ ", product=" + product + "]";
	}
	
	
	
	
//	create a table and an entity class to model the reviews for a product
//	each review:
//	int id autogenerated
//	String reviewer
//	String details
//	int rating
//
	//CREATE TABLE `reviews` (`user_id` int(11) NOT NULL auto_increment, `user_name` varchar(50) default NULL,`user_review` varchar(100) default NULL,`user_rating` int(11) default NULL,PRIMARY KEY  (`user_id`)) ENGINE=InnoDB;
//
//	Create a DAO interface for CRUD and Query ops and implement in a bean using JPA


}
