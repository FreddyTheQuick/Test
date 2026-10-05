package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductTest
{
	/*
	 * Association: ---[1]-> p:Product
	 */
	private Product product;

	@Before
	public void setup()
	{
		product = new Product(3,"Java Programming", 3550);

		IntegerSequence.setInitValue(1);
	}

	@Test
	public void testProduct()
	{
		out.println("@Test testProduct");
		String s = product.toString();
		assertEquals("<product id=\"3\" title=\"Java Programming\" price=\"35.5\"/>", s);
	}

    @Test
    public void testPriceZero()
    {
        Product p = new Product(3,"Java Programming", 0);
        assertEquals(0, p.getPrice());
    }

	@Test(expected = IllegalArgumentException.class)
	public void testTitleNull()
	{
		new Product(3,null, 3550);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitleNull()
    {
        product.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitleEmpty()
    {
        product.setTitle("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitleEmpty()
    {
        new Product(3,"", 3550);
    }

	@Test(expected = IllegalArgumentException.class)
	public void testPriceNegative()
	{
		new Product(3, "Java Programming", -3550);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testSetPriceNegative()
    {
        product.setPrice(-1);
    }

	@Test
	public void testNextId()
	{
		Product p1 = new Product("Java Programming", 3550);
		assertEquals(1, p1.getId());

		Product p2 = new Product("Programming C", 1790);
		assertEquals(2, p2.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCategoryNull()
	{
		product.setCategory(null);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testIdNegative()
    {
        new Product(-1, "Java Programming", 10);
    }

    @Test
	public void testToXml()
	{
		final String EXPECTED = 
			"<product id=\"3\" title=\"Java Programming\" price=\"35.5\"/>";
		String xml = product.toXml();
		assertEquals(EXPECTED, xml);
		System.out.println(xml);
	}
}
