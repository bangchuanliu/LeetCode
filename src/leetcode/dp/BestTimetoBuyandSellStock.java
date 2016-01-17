package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class BestTimetoBuyandSellStock {
	
	public int maxProfit(List<Integer> prices) {
		if(prices == null || prices.size() == 0){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0;i<prices.size();i++){
			min = Math.min(prices.get(i), min);
			profit = Math.max(profit, prices.get(i) - min);
		}
		return profit;
	}
	
	public static void main(String[] args){
		BestTimetoBuyandSellStock instance = new BestTimetoBuyandSellStock();
		Integer[] a1 = {2,7,6,0}; //5
		Integer[] a2 = {2,2,2,2}; //0
		Integer[] a3 = {1,2,3,4}; //3
		List<Integer> prices = new ArrayList<Integer>(Arrays.asList(a1));
		System.out.println(instance.maxProfit(prices));
		prices = new ArrayList<Integer>(Arrays.asList(a2));
		System.out.println(instance.maxProfit(prices));
		prices = new ArrayList<Integer>(Arrays.asList(a3));
		System.out.println(instance.maxProfit(prices));
	}
}
