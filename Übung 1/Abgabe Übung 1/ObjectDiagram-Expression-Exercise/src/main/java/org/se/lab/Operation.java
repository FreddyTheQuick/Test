package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation
	extends Expression
{
	/*
	 * Association: ---[*]-> Expression
	 */
	private List<Expression> expressions = new ArrayList<Expression>();
	public void addExpression(Expression ex)
	{
		if(ex == null)
			throw new NullPointerException();
		expressions.add(ex);
	}
	public List<Expression> getExpressions()
	{
		return expressions;
	}	
}
