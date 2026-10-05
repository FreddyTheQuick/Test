package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
		order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));		
	}
	
	
	@Test
	public void testOrder()
	{
		Assert.assertEquals(1, order.getId());
		Assert.assertEquals("Special order", order.getName());
		Assert.assertEquals(2, order.getOrderLines().size());
	}

	
	@Test
	public void testOrderLine1()
	{
		OrderLine l = order.getOrderLines().get(0);
		
		Assert.assertEquals(2, l.getId());
		Assert.assertEquals(1, l.getQuantity());
		Assert.assertNotNull(l.getProduct());
		
		Product p = l.getProduct();
		Assert.assertEquals(3, p.getId());
		Assert.assertEquals("Pizza Frutti di Mare", p.getDescription());
		Assert.assertEquals(880, p.getPrice());
	}

	
	@Test
	public void testOrderLine2()
	{
		OrderLine l = order.getOrderLines().get(1);

		Assert.assertEquals(4, l.getId());
		Assert.assertEquals(2, l.getQuantity());
		Assert.assertNotNull(l.getProduct());
		
		Product p = l.getProduct();
		Assert.assertEquals(5, p.getId());
		Assert.assertEquals("Pizza Quattro Formaggi", p.getDescription());
		Assert.assertEquals(820, p.getPrice());
	}


	@Test
	public void testOrderLineToString()
	{
		OrderLine l = order.getOrderLines().get(1);

		Assert.assertEquals("OrderLine { 4, 2, Product: 5, Pizza Quattro Formaggi, 820€ }", l.toString());
	}


	@Test
	public void testOrderLineHasZeroQuantity()
	{
		OrderLine orderLine = new OrderLine(77, 0, new Product(3, "Pizza Frutti di Mare", 880));

		Assert.assertEquals(0, orderLine.getQuantity());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrder_IdIsNegative()
	{
		new Order(-1, "Special order");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrder_NameIsNull()
	{
		new Order(1, null);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testOrder_NameIsEmpty()
    {
        new Order(1, "");
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_IdIsNegative()
	{
		new OrderLine(-1, 1, new Product(3, "Pizza Frutti di Mare", 880));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_QuantityIsNegative()
	{
		new OrderLine(1, -1, new Product(3, "Pizza Frutti di Mare", 880));		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_ProductIsNull()
	{
		new OrderLine(1, 1, null);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_AddProductIsNull()
	{
		order.addOrderLine(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_IdIsNegative()
	{
		new Product(-1, "Pizza Frutti di Mare", 880);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_DescriptionIsNull()
	{
		new Product(1, null, 880);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testProduct_DescriptionIsEmpty()
    {
        new Product(1, "", 880);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_PriceIsNegative()
	{
		new Product(1, "Pizza Frutti di Mare", -880);
	}	
}
