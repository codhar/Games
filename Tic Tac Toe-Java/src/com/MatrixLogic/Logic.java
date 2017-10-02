package com.MatrixLogic;

public class Logic {
	
	public static int start =0;

	public static int getStart() {
		return start;
	}

	public static void setStart(int start) {
		Logic.start = start;
	}
	
	private static boolean checkHorizontal(int[] array,int size){
		int count = 0;
		for(int i=0;i<(size*size) ;i=i+size){
			for(int j=i;j<(i+size);j++){
				if(array[j] == start){
					count++;
				}
			}
			if(count == size)
				return true;
			count =0;
		}
		return false;
	}
	
	private static boolean checkVertical(int[] array,int size){
		int count = 0;
		for(int i=0;i<size ;i++){
			for(int j=i;j<(size*size);j=j+size){
				if(array[j] == start){
					count++;
				}
			}
			if(count == size)
				return true;
			count =0;
		}
		return false;
	}
	
	private static boolean checkDigonal(int[] array,int size){
		int count = 0;
		for(int i=0;i<size;i++){
			int no = (size*i)+i;
			if(array[no]== start){
				count++;
			}
		}
		if(count == size)
			return true;
		count=0;
		for(int j=1;j<=size;j++){
			int no = (size*j)-j;
			if(array[no]== start){
				count++;
			}
		}
		if(count == size)
			return true;
		return false;
	}
	
	public boolean checkLogic(int[] array, int ArraySize){
		if(checkHorizontal(array, ArraySize) || checkVertical(array, ArraySize) || checkDigonal(array, ArraySize))
			return true;
		return false;
	}
}
