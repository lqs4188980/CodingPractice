package com.leetcode.candy;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {1,2,4,4,3};
		System.out.println(candy(ratings));
	}
	
    public static int candy(int[] ratings) {
        if(ratings == null)
            return 0;
        if(ratings.length == 1)
            return 1;
        int length = ratings.length;
        int[] candy = new int[length];
        
        for(int i = 0; i < length; i++){
            if(i == 0){
                candy[i] = 1;
                continue;
            }
            else{
                if(ratings[i - 1] > ratings[i]){
                    if(candy[i - 1] == 1){
                        candy[i - 1] ++;
                        candy[i] = 1;
                    }
                    else{
                        candy[i] = 1;
                    }
                    continue;
                }
                if(ratings[i - 1] < ratings[i]){
                    candy[i] = candy[i - 1] + 1;
                    continue;
                }
                if(ratings[i - 1] == ratings[i]){
                    //candy[i] = candy[i - 1];
                    candy[i] = 1;
                    continue;
                }
            }
        }
        
        for(int i = length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
                candy[i] = candy[i + 1] + 1;
                continue;
            }
            
            if(ratings[i] < ratings[i + 1] && candy[i] >= candy[i + 1]){
                if(candy[i + 1] == 1){
                    candy[i + 1]++;
                    candy[i] = 1;
                }
                else{
                    candy[i] = candy[i + 1] - 1;
                }
                continue;
            }
        }
        
        int sum = 0;
        for(int item : candy){
            sum += item;
        }
        return sum;
    }
    
    

}
