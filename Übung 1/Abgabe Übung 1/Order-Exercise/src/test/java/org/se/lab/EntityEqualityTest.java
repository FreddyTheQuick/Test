package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class EntityEqualityTest
{
    Entity entity1 = new Order(1, "order 1");
    Entity entity2 = new Order(2, "order 2");
    Entity entityCopy = new Order(2, "order 2");

    @Test
    public void testEntitySame()
    {
        Assert.assertEquals(entity1, entity1);
    }

    @Test
    public void testEntityDifferent()
    {
        Assert.assertNotEquals(entity1, entity2);
        Assert.assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    public void testDifferentObj()
    {
        Entity product = new Product(27, "a product", 28);
        Assert.assertNotEquals(entity1, product);
    }

    @Test
    public void testEntitySameObj()
    {
        Assert.assertEquals(entity2, entityCopy);
        Assert.assertEquals(entityCopy, entity2);
        Assert.assertEquals(entity2.hashCode(), entityCopy.hashCode());
    }

    @Test
    public void testEntityNotEqualNull()
    {
        Assert.assertFalse(entity1.equals(null));
    }

    @Test
    public void testEntityWithSameIdButDifferentType()
    {
        Entity product2 = new Product(2, "a product", 28);
        Assert.assertNotEquals(entity2, product2);
    }
}
