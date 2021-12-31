package com.stockers.service;

public class MergeSort {
	public void applyMergeSort(Double array[],int left,int right) {
		if(left<right) {
			mergeSort(array,left,right);
		}else {
			System.out.println("Invalid Left and Right parameters");
		}
	}
	public void mergeSort(Double[] array,int left,int right){
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}
	public void merge(Double array[],int left,int mid,int right) {

		int leftSize = mid-left+1;
		int rightSize = right-mid;
		Double leftArray[] = new Double[leftSize];
		Double rightArray[] = new Double[rightSize];
		int k=left;

		for(int i=0;i<leftSize;i++) {
			leftArray[i] = array[left+i];
		}

		for(int j=0;j<rightSize;j++) {
			rightArray[j] = array[mid+1+j];
		}
		int i=0,j=0;
		while(i<leftSize && j<rightSize) {
				if(leftArray[i]<=rightArray[j]) {
					array[k] = leftArray[i];
					i++;
				}else {
					array[k] = rightArray[j];
					j++;
				}
				k++;
		}
		while(i<leftSize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while(j<rightSize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

}
