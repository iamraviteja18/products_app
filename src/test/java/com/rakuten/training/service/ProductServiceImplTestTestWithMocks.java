package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

class ProductServiceImplTestTestWithMocks {

	@Test
	void addNewProduct_Must_Return_NonZeroId_When_Value_GTEQ_10K() {
		// AAA
		// Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		Product paramToMethod = new Product("name", 10000, 1);
		Product saved = new Product();
		saved.setId(1);

		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		Mockito.when(mockDAO.save(paramToMethod)).thenReturn(saved); // training to the mock

		objUnderTest.setDao(mockDAO);

		// Act
		int result = objUnderTest.addNewProduct(paramToMethod);

		// Assert
		assertTrue(result > 0);
	}

	@Test
	void addNewProduct_MustReturn_Exception() {
		
		// AAA
		// Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		Product paramToMethod = new Product("name", 9999, 1);

		// Act and Assert
		assertThrows(IllegalArgumentException.class, () -> objUnderTest.addNewProduct(paramToMethod));
	}

	@Test
	void removeExistingMustExecuteWhenGTLT_100K() {
		// Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		int paramToMethod = 1;
		Product exist = new Product("name",10000,5); //less than 100K delete

		ProductDAO mockDao = Mockito.mock(ProductDAO.class);
		Mockito.when(mockDao.findById(paramToMethod)).thenReturn(exist);
		objUnderTest.setDao(mockDao);
		
		//Act
		objUnderTest.removeExisting(paramToMethod);
		
		//Assert
		Mockito.verify(mockDao).deleteById(paramToMethod);
	}
	
	@Test
	void removeExistingMustReturn_Exception() {
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		int paramToMethod = 1;
		Product exist = new Product("name",100000,1); //greater = 100K then exception is called
		
		ProductDAO mockDao = Mockito.mock(ProductDAO.class);
		Mockito.when(mockDao.findById(paramToMethod)).thenReturn(exist);
		//Act
		objUnderTest.setDao(mockDao);
		
		//A
		assertThrows(IllegalStateException.class, () -> objUnderTest.removeExisting(paramToMethod));
		
		
	}

}
