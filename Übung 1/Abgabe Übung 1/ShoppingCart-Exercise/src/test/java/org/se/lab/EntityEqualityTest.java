package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class EntityEqualityTest
{
    Entity entity1 = new Product(111, "product 1", 28);
    Entity entity2 = new Product(222, "product 2", 42);
    Entity entityCopy = new Product(222, "product 2", 42);
    Entity category = new Category("category");

    @Test
    public void testEntitySame()
    {
        Assert.assertTrue(entity1.equals(entity1));
    }

    @Test
    public void testEntityDifferent()
    {
        Assert.assertFalse(entity1.equals(entity2));
        Assert.assertFalse(entity1.hashCode() == entity2.hashCode());
    }

    @Test
    public void testDifferentObj()
    {
        Assert.assertFalse(entity1.equals(category));
    }

    @Test
    public void testEntitySameObj()
    {
        Assert.assertTrue(entity2.equals(entityCopy));
        Assert.assertTrue(entityCopy.equals(entity2));
        Assert.assertTrue(entity2.hashCode() == entityCopy.hashCode());
    }

    @Test
    public void testEntityNotEqualNull()
    {
        Assert.assertFalse(entity2.equals(null));
    }
}
