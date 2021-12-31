package com.stockers.service;
import java.util.*;

public class StockAnalyzer {
	public static MergeSort mergeSort = new MergeSort();
	public Double[] sortAscending(HashMap<Double,Boolean> map){
		Set<Double> keys = map.keySet();
		// System.out.println("Keys:"+keys);
		Double[] finalKeys = new Double[keys.size()];
		int counter = 0;
		for(Double key : keys){
			finalKeys[counter] = key;
			counter++;
		}
		mergeSort.applyMergeSort(finalKeys,0,finalKeys.length-1);

		System.out.println("Stock Prices in ascending order are:");
		for(int i=0;i<finalKeys.length;i++){
			System.out.print(finalKeys[i]+" ");
		}
		System.out.println("");
		return finalKeys;
	}
	public Double[] sortDescending(HashMap<Double,Boolean> map){
		Set<Double> keys = map.keySet();
		// System.out.println("Keys:"+keys);
		Double[] finalKeys = new Double[keys.size()];
		int counter = 0;
		for(Double key : keys){
			finalKeys[counter] = key;
			counter++;
		}
		mergeSort.applyMergeSort(finalKeys,0,finalKeys.length-1);
		reverse(finalKeys);

		System.out.println("Stock Prices in descending order are:");
		for(int i=0;i<finalKeys.length;i++){
			System.out.print(finalKeys[i]+" ");
		}
		System.out.println("");
		return finalKeys;
	}
	public int getImprovedStockCount(HashMap<Double,Boolean> map){
		int counter = 0;
		for(Double key:map.keySet()){
			if(map.get(key)){
				counter++;
			}
		}
		return counter;		 
	}
	public int getDeclinedStockCount(HashMap<Double,Boolean> map){
		int counter=0;
		for(Double key:map.keySet()){
			if(!map.get(key)){
				counter++;
			}
		}
		return counter;
	}
	public boolean getStockStatus(HashMap<Double,Boolean> map,Double inputKey){
		for(Double key : map.keySet()){
			if(Double.compare(key,inputKey)==0){
				System.out.println("Stock of value "+inputKey+" is present");
				return true;
			}
		}
		System.out.println("Stock of value "+inputKey+" is not present");
		return false;
	}
	static void reverse(Double array[])
    {
        Collections.reverse(Arrays.asList(array));
    }
}
