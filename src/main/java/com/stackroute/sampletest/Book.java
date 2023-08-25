package com.stackroute.sampletest;

import java.util.Arrays;

public class Book {
   String bookName;
   String author;
   int price;
   String[] publications;
   
   
   public String[] getPublications() {
	return publications;
}


public void setPublications(String[] publications) {
	this.publications = publications;
}


public Book(String bookName, String author, int price,String[] publi) {
	super();
	this.bookName = bookName;
	this.author = author;
	this.price = price;
	this.publications=publi;
	
	
}


public void sortPublisher()
{
	Arrays.sort(publications)
	
}

   
   public boolean validatePrice() throws NegativePriceException
   {
	   if(price<=0)
		   throw new NegativePriceException("Price can no be -ve");
	   else
		   return true;
	   
	   
   }

   public boolean validateBookName()
   {
	   if(bookName.length()<=1)
		   return false;
	   else
		   return true;
   }
   
   public int getDiscount()
   {
	   if (price>1000)
		   return price*8/100;
	   else
		   return price*5/100;
   }
   
   public String authorData()
   {
	    if(author.contains("in"))
	    return "From India";
	    else if (author.contains("sg"))
	    	return "From Singapore";
	    else
	    	return "From Other Countries";
	     
   }
   
   
 public boolean isValid()
 {
	 if (author.length()>=3)
		 return false;
	 else
		 return true;
 }
   
public Book() {}
   
   
   
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) 
{
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
   
}
