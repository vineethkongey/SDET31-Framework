package com.practiceMaven;

public class A {
	
	public void text()
	{
		System.out.println("implementation of class RunTime");
		
	}
	

}

class B extends A
{
	public void text()
	{
		System.out.println("implementation of class B");
		
	}
	
	public void demoB()
	{
		System.out.println("implementation of demo2 in class B");
	}
	
	
}

class C extends B
{
	public void text()
	{
		System.out.println("implementation of class C");
		
	}
	
	public void demoC()
	{
		System.out.println("implementation of method demo in class C");
		
	}
}


	
