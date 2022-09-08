package com.practiceMaven;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet hst = new HashSet<>();
		hst.add(10);
		hst.add(30);
		hst.add(10);
		hst.add(null);
		hst.add(null);
		hst.add("miku");
		System.out.println(hst);
	}

}
