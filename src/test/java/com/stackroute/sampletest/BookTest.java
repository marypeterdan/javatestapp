package com.stackroute.sampletest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

	Book book;
	
	@BeforeEach
	public void setBookdata()
	{
		String[] publications= {"National","ISS","Arms","Kelvin"};
		book=new Book("Python","Rahul-in",3500,publications);
	}
	
	
	@Test
	public void whenbookNameSentItreceived()
	{
		String bookname=book.getBookName();
		assertEquals("Python",bookname);
		
	}
	
	@Test
	public void whenInvalidNameThenReturnFalse()
	
	{
		book.setBookName("k");
		
		assertFalse(book.validateBookName());
		
	}
	
	
	
	@Test
	public void whenValidNameThenReturnTrue()
	
	{
		book.setBookName("jhon");
		
		assertTrue(book.validateBookName());
		
	}
	
	@Test
	
	public void findDiscountbyprice()
	{
		  assertEquals(280,book.getDiscount());
	}
	
	
	@DisplayName("negative value for price is not accepted")
	@Test
	
	public void whenPriceInvalidExpectFailure()
		
	{
		book.setPrice(-230);
		
		
	Exception excep=assertThrows (NegativePriceException.class, ()-> book.validatePrice());
	
	assertEquals("Price can no be -ve",excep.getMessage());
	
	}
	
	
	@Test
	public void whenAuthorValidateThenCompleteInSeconds()
	{
	String result=   assertTimeout(Duration.ofSeconds(2), ()-> {
		   									String data=  book.authorData();
		   										return data;
	   							  });
	assertEquals("From India",result);
	
	}
	
	@DisplayName("Validatingbookname,price and author")
	@Test
	public void validatealldatasuccess()
	{
		assertAll("validating all fields",()->{
			
			
			assertNotNull(book.getAuthor());
			assertNotNull(book.getBookName());
			assertTrue(book.validateBookName());
			
			assertAll("checking the price",()->{
				
				book.setPrice(500);
				assertTrue(book.validatePrice());
				int discount=book.getDiscount();
				
				assertEquals(25,discount);
				
			});
			
			
		});
		
		
	}
	
	@Test
	public void WhenDisplayArrayThenSortSuccess()
	{
		//	"National","ISS","Arms","Kelvin"

		
		String[] exparr= {"Arms","ISS","Kelvin","National"};
		
		book.sortPublisher();
		String[] actualarr=book.getPublications();
		
		assertArrayEquals(exparr,actualarr);
	}
	
	@Test
	public void testAuthorName()
	{
		assertFalse(this.book.isValid());
	}
	
	
}
























