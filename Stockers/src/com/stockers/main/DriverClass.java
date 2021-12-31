package com.stockers.main;

import java.util.*;
import com.stockers.service.*;
import com.stockers.utils.*;

public class DriverClass {
	public static Scanner scanner = new Scanner(System.in);
	public static StockAnalyzer stockAnalyzer = new StockAnalyzer();

	public static void main(String[] args) {
		System.out.println("Please enter the number of companies: ");
		int numberOfCompanies = scanner.nextInt();
		HashMap<Double,Boolean> map = new HashMap<Double,Boolean>();
		int counter=0;
		while(counter<numberOfCompanies){
			System.out.println("Enter current stock price of the company "+(counter+1)+" : ");
			Double stockPrice = scanner.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?(true/false) : ");
			Boolean stockStatus = scanner.nextBoolean();//Boolean.valueOf(scanner.nextLine());
			map.put(Double.valueOf(stockPrice),Boolean.valueOf(stockStatus));
			counter++;
		}

		int choice;
		do {
			GeneralFunctions.displayMenu();
			choice = scanner.nextInt();
				switch(choice) {
					case 1:
						// System.out.println(choice);
						stockAnalyzer.sortAscending(map);
						break;
					case 2:
						// System.out.println(choice);
						stockAnalyzer.sortDescending(map);
						break;
					case 3:
						// System.out.println(choice);
						System.out.println("Total no of companies whose stock price rose today : "+stockAnalyzer.getImprovedStockCount(map));
						break;
					case 4:
						// System.out.println(choice);
						System.out.println("Total no of companies whose stock price declined today : "+stockAnalyzer.getDeclinedStockCount(map));
						break;
					case 5:
						// System.out.println(choice);
						System.out.println("Enter the key value : ");
						Double key = scanner.nextDouble();
						stockAnalyzer.getStockStatus(map,key);
						break;
					case 0:
						// System.out.println(choice);
						System.out.println("Exit option is chosen");
						break;
					default:
						System.out.println("Invalid Option chosen");
						break;
				}
			}while(choice!=0);
	}
}
