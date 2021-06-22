package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTestTestWithAnnotations {
	
	@Mock
	ProductDAO mockDao;
	
	@Test
	void addNewProduct_Must_Return_NonZeroId_When_Value_GTEQ_10K() {
		// AAA
		// Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		Product paramToMethod = new Product("name", 10000, 1);
		Product saved = new Product();
		saved.setId(1);

		Mockito.when(mockDao.save(paramToMethod)).thenReturn(saved); // training to the mock

		objUnderTest.setDao(mockDao);

		// Act
		int result = objUnderTest.addNewProduct(paramToMethod);

		// Assert
		assertTrue(result > 0);
	}

}
