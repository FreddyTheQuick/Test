package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class IntegerSequenceTest
{
    @Test
    public void testSequenceNextValue()
    {
        IntegerSequence.setInitValue(0);

        int value = IntegerSequence.getNextValue();
        Assert.assertEquals(0, value);

        int nextValue = IntegerSequence.getNextValue();
        Assert.assertEquals(1, nextValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSequenceNegative()
    {
        IntegerSequence.setInitValue(-1);
    }
}
