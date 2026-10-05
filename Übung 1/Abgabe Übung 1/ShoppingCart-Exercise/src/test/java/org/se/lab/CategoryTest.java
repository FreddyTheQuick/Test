package org.se.lab;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest
{
	private Category books;

	@Before
	public void setUp()
	{
		books = new Category("Books");
		Product p1 = new Product("Programming C", 1790);
		Product p2 = new Product("Java Programming", 3450);

		books.addProduct(p1);
		p1.setCategory(books);

		books.addProduct(p2);
		p2.setCategory(books);
	}

	@Test
	public void testNavigationCategoryProduct()
	{
		final String EXPECTED = "Programming C";
		String title = books.getProducts().get(0).getTitle();
		assertEquals(EXPECTED, title);
	}


	@Test
	public void testNavigationXXX()
	{
		final String EXPECTED = "Java Programming";
		Product p1 = books.getProducts().get(0);
		Category c = p1.getCategory();
		Product p2 = c.getProducts().get(1);
		String title = p2.getTitle();

		assertEquals(EXPECTED, title);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProductNull()
	{
		books.addProduct(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNameNull()
	{
		new Category(null);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameEmpty()
    {
        new Category("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameSetterEmpty()
    {
        Category c = new Category("name");
        c.setName("");
    }

	@Test(expected = IllegalArgumentException.class)
	public void testAddChildNull()
	{
		books.addChild(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetParentNull()
	{
		books.setParent(null);
	}
}
