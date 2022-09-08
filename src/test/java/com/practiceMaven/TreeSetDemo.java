package com.practiceMaven;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet tst =  new TreeSet<>();
		tst.add(40);
		tst.add(70);
		//tst.add("chiku");
		tst.add(null);
		
		System.out.println(tst);
	}

}
