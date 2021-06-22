package com.rakuten.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductRepository;
import com.rakuten.training.dal.ReviewsDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewsService;
import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer =
				SpringApplication.run(ProductsAppApplication.class, args);
		
		//ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		//ui.createProductWithUI();
		
		//testProductQueries(springContainer);
		
		//testReviewOps(springContainer);
		
		//testRepository(springContainer);
	}

	private static void testRepository(ApplicationContext springContainer) {
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		Product p = new Product("repo", 12345, 23);
		
		//repo.save(p);//to add new row into db
		
		List<Product> pl1= repo.findByNameLike("mobile");//to search for something in  db
		pl1.forEach(System.out::println);
		
	}

	private static void testProductQueries(ApplicationContext springContainer) {
		ProductService service = springContainer.getBean(ProductService.class);
//		List <Product> all = service.findAll();
//		System.out.println("There are "+all.size()+" products:");
//		all.forEach(System.out::println);
		
		//List <Product> all1 = service.findByName("mobile");
		//List <Product> all1 = service.findByNameLike("mobi");
		List <Product> all1 = service.findByPriceLessThan(20010);
		System.out.println("There are "+all1.size()+" products:");
		all1.forEach(System.out::println);
		
	}

	private static void testReviewOps(ApplicationContext springContainer) {
		
		//ReviewsDAO dao = springContainer.getBean(ReviewsDAO.class);
		//Reviews aReview = new Reviews("myself", "this is good stuff", 5);
		//dao.save(aReview);
		//dao.findById(2);
		
		ReviewsService service = springContainer.getBean(ReviewsService.class);
//		Reviews aReview = new Reviews("myself", "this is really good stuff", 1);
//		service.addReviewToProduct(aReview, 1);
		
		
		//List <Reviews> all1 = service.findByPid(3);
		List <Reviews> all2 = service.findByRatingGreaterThan(3);
		System.out.println("There are "+all2.size()+" reviews:");
		all2.forEach(System.out::println);
		
		
	}

}
