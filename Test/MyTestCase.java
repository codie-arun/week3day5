package week3day5.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyTestCase {

	  @BeforeClass
	  public static void beforeClassMethod() {
	      System.out.println("BeforeClass");
	  }
	  
	  @Before
	  public void beforeMethod() {
	      System.out.printf("Before");
	  }

	  @After
	  public void afterMethod() {
	      System.out.printf("After");
	  }

	  @AfterClass
	  public static void afterClassMethod() {
	      System.out.printf("AfterClass");
	  }

	  @Test
	  public void test1() {
	      System.out.printf("Test method 1");
	  }

	  @Test
	  public void test2() {
		  System.out.printf("Test method 2");
	  }
	  
	  @Test
	  public void test3() {
		  System.out.printf("Test method 3");
	  }
	  
	  @Test
	  public void test4() {
		  System.out.printf("Test method 4");
	  }
	  
	  @Test
	  public void test5() {
		  System.out.printf("Test method 5");
	  }

	 
	}
