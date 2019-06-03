package com.expedia.validator.samples.reversewords;


public class ReverseWordsInString {

	public static void main(String[] args) {

		String data = "The sky is Blue";
		String result = reverseString(data);
		System.out.println(result);

	}

	private static String reverseString(String data) {
		String result = "";
		if(data.length() == 0)
			return data;

		String[] b = data.trim().split(" ");
		for(int i = b.length -1 ; i >= 0; i--) {
			result = result + " " + b[i];
		}
		return result.trim();
	}

}
