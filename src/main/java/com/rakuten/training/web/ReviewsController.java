package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Reviews;
import com.rakuten.training.service.ReviewsService;

@CrossOrigin
@RestController
public class ReviewsController {

	@Autowired
	ReviewsService service;
	
	@PostMapping("/products/{pid}/reviews")
	public ResponseEntity addReview(@RequestBody Reviews toBeAdded,@PathVariable("pid") int pid) {
		int id = service.addReviewToProduct(toBeAdded, pid);
		return new ResponseEntity(toBeAdded, HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{pid}/reviews")
	public List<Reviews> getReviewsForAProduct(@PathVariable("pid") int pid){
		return service.findByPid(pid);
	}
//	
//	
//	@GetMapping("/reviews/{id}")
//	public ResponseEntity<Reviews> findById(@PathVariable("id") int id)
//	{
//		Reviews r = services.findById(id);
//		if(r==null)
//		{
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		else {
//			return new ResponseEntity<Reviews>(r,HttpStatus.OK);
//		}
//	}
//	
//	@PostMapping("/products/{pid}/reviews")
//	public ResponseEntity addReview(@RequestBody  Reviews r, @PathVariable("pid") int pid) {
//			int id = service.addReviewToProduct(r,pid);
////			HttpHeaders headers = new HttpHeaders();
////			headers.setLocation(URI.create("/reviews/"+id));
//			return new ResponseEntity(r, HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/reviews/{id}")
//	public ResponseEntity deleteById(@PathVariable("id") int id) {
//		try {
//			services.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}catch(IllegalStateException e) {
//			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
//		}
//		 
//	}
	
}
