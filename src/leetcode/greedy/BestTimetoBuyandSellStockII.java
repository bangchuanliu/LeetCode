package leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. 
	You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class BestTimetoBuyandSellStockII {
	
	public int maxProfit(List<Integer> prices) {
		if(prices == null || prices.size() == 0){
			return 0;
		}
		int profit = 0;
		for(int i = 1;i<prices.size();i++){
			int temp = prices.get(i) - prices.get(i-1);
			if(temp > 0){
				profit += temp;
			}
		}
		return profit;
	}
	public static void main(String[] args){
		BestTimetoBuyandSellStockII instance = new BestTimetoBuyandSellStockII();
		Integer[] a1 = {1,5,6,7}; //6
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
