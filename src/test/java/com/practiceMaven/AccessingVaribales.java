package com.practiceMaven;

public class AccessingVaribales {
	
	int x = 10;
	static int y = 20;
	 AccessingVaribales acs = new AccessingVaribales();
	public void demo()
	{
		
		
		System.out.println(x);
		System.out.println(acs.x);
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println(acs.y);
		System.out.println(y);
		System.out.println(AccessingVaribales.y);
	}
	
	public static void demo1()
	{
		//AccessingVaribales acs2 = new AccessingVaribales();
		System.out.println(y);
		//System.out.println(acs.y);
		System.out.println(AccessingVaribales.y);
		//System.out.println(acs.x);
		
		
	}
	public static void main(String[] args) {
		
		AccessingVaribales acs1 = new AccessingVaribales();
		acs1.demo();
	}

}
