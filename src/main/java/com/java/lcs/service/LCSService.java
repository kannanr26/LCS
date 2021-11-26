package com.java.lcs.service;

import org.springframework.stereotype.Service;

@Service
public class LCSService {

	public String findLCS(String[] strArr) {
		// TODO Auto-generated method stub

		// function to find the stem (longest common
		// substring) from the string array

		int strArrLength = strArr.length;

		// Take first word from array as reference
		String firstString = strArr[0];
		int firstStringLength = firstString.length();

		String lcs = "";

		for (int i = 0; i < firstStringLength; i++) {
			for (int j = i + 1; j <= firstStringLength; j++) {

				// generating all possible substrings
				// of our reference string value[0] i.e s
				String str = firstString.substring(i, j);
				int k = 1;
				for (k = 1; k < strArrLength; k++)

					if (!strArr[k].contains(str))
						break;

				if (k == strArrLength && lcs.length() < str.length())
					lcs = str;
			}
		}

		return lcs;

	}

}
