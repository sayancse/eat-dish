package com.test.EatDish;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestAlgo {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = null;
		BufferedReader br = null;

		try{
			fis = new FileInputStream("C:\\Personal\\PROJECT\\SDGCR33\\tmoworkspace\\EatDish\\src\\main\\java\\com\\test\\EatDish\\data.txt");
			br = new BufferedReader(new InputStreamReader(fis));

			String str=br.readLine();int index=0;
			
			long totalTime = Long.parseLong(str.split(" ")[0]);
			int noOfItems = Integer.parseInt(str.split(" ")[1]);
			
			ItemCat[] itemCats = new ItemCat[noOfItems];
			
			while((str = br.readLine()) != null){
				String[] tmp = str.split(" ");
				long itemSatisfaction = Long.parseLong(tmp[0]);
				long itemTime = Long.parseLong(tmp[1]);
				itemCats[index++] = new ItemCat(itemSatisfaction, itemTime);
			}

			Arrays.sort(itemCats);
			
			long totalSatisfaction=0L, remainingTime=totalTime; int i=0;
			
			while(remainingTime > 0){
				remainingTime =- itemCats[i].getTime();
				totalSatisfaction += itemCats[i].getSatisfaction();
				if(i++>99){
					System.out.println("Oops he tasted all different dishes");
					break;
				}
			}
			
			System.out.println("Maximum Satisfaction : " + totalSatisfaction);
			
			//Order is nlogn because of Arrays.sort;
		}finally{
			if(br != null)
				br.close();
			if(fis != null)
				fis.close();

		}

	}
}

