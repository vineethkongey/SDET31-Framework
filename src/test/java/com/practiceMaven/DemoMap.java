package com.practiceMaven;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DemoMap {
	public static void main(String[] args) {
		HashMap map = new HashMap<>();
		map.put(1, "chiku");
		map.put(2, "miku");
		map.put(3, "jhuma");
		map.put(4, "jagan");
		map.put(5, 7);
		//map.put("name", "soumya");
		System.out.println(map);
		 // Set desc = map.keySet();
		 Collection hv = map.values();
		 System.out.println(map.values());
		 
		 TreeSet sorted = new TreeSet<>(hv);
		 System.out.println(sorted);
		 System.out.println(sorted.descendingSet());
		
		
		  TreeSet set1 = new TreeSet(map.keySet());
		  System.out.println(set1.descendingSet());
		 
		TreeMap map1 = new TreeMap<>();
		map1.put(1, "aaa");
		map1.put(2, "bbb");
		System.out.println(map1);
	
	}

}
