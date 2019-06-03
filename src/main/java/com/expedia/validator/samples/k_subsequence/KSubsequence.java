package com.expedia.validator.samples.k_subsequence;


import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

public class KSubsequence {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 1};
		int k = 3;
		int[][] result = getkSubsequence(arr, k);

	}

	private static int[][] getkSubsequence(int[] arr, int k) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < arr.length - 1; i++) {
			List<Integer> temp = new ArrayList<>();
			if(arr[i] % k == 0) {
				temp.add(arr[i]);
			}
			result.add(temp);
			int sum = arr[i];
			for(int j = 1; j < arr.length - 1; j++) {
				sum = sum + arr[j];
				if(sum % k == 0) {

				}
			}
		}
		return null;
	}


}
