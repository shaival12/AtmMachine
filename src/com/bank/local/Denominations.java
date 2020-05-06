package com.bank.local;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Denominations{
	private static Map map = new TreeMap(Collections.reverseOrder()); // reverse sorted
	 
	public Denominations(int note1, int note5, int note10, int note20) {
		super();
		map.put(20,note20);
		map.put(10,note10);
		map.put(5,note5);
		map.put(1,note1);
	}

	public Denominations() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		map.forEach((k,v)->{
			 buf.append("["+k + " = " + v +" ],");
		});
		
		return buf.toString();
	}
	
	
	// add notes to existing values
	void addNotes(int amount) {
		
		//count  and add to Notes	
		Map<Integer,Integer> newCountMap  =	countCurrency(amount);
		
		newCountMap.forEach((k,v)->{
			int newValue = (int) map.get(k);
			map.replace(k, ((int)v+newValue)); 
			
		});
		
		 toString();
	}
	
	//deduct notes from  existing values
	void deductNotes(int amount) {
		
    //count and deduct to Notes	
     Map newCountMap  =	countCurrency(amount);
     
     newCountMap.forEach((k,v)->{
 		int oldCount = (int) map.get(k);
 		if(oldCount>(int)v)
 	    	map.replace(k, (oldCount - (int)v)); 
 		
 	  });
     
     toString();
		
		
	}
	
	/**
	 *  count currency 
	 * @param amount
	 */
	private Map countCurrency(int amount) 
	    { 
		    Map<Integer,Integer> respMap = new TreeMap<Integer,Integer>();
	        int[] notes = new int[]{20, 10, 5, 1 }; 
	        int[] noteCounter = new int[4]; 
	    
	        for (int i = 0; i < notes.length; i++) { 
	            if (amount >= notes[i]) { 
	                noteCounter[i] = amount / notes[i]; 
	                amount = amount - noteCounter[i] * notes[i]; 
	            } 
	        } 
	        
	        for (int i = 0; i < notes.length; i++) { 
	        	respMap.put(notes[i], noteCounter[i]);
	        } 
	       
	        
	       return  respMap;
	    } 
	
} 