package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.domain.Product;

class ProductServiceImplTest {

	@Test
	void addNewProduct_Must_Return_NonZeroId_When_Value_GTEQ_10K() {
		//AAA
				//Arrange
				ProductServiceImpl objUnderTest = new ProductServiceImpl();
				Product paramToMethod = new Product("name", 10000, 1);
				
//				ProductDAOInMemImpl doubleOfRealDAO = new ProductDAOInMemImpl();
//				objUnderTest.setDao(doubleOfRealDAO);
				
				ProductDAOStub stub = new ProductDAOStub();
				objUnderTest.setDao(stub);
				
				//Act
				int result = objUnderTest.addNewProduct(paramToMethod);
				
				//Assert
				assertTrue(result > 0);

	}

}
