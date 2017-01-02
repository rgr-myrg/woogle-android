package net.usrlib.woogle.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rgr-myrg on 12/27/16.
 */

public class NumericalAlphabet {
	public static final Map<String, Integer> map = new TreeMap<String, Integer>() {{
		put("A", 1);
		put("B", 2);
		put("C", 3);
		put("D", 4);
		put("E", 5);
		put("F", 8);
		put("G", 3);
		put("H", 5);
		put("I", 1);
		put("J", 1);
		put("K", 2);
		put("L", 3);
		put("M", 4);
		put("N", 5);
		put("O", 7);
		put("P", 8);
		put("Q", 1);
		put("R", 2);
		put("S", 3);
		put("T", 4);
		put("U", 6);
		put("V", 6);
		put("W", 6);
		put("X", 5);
		put("Y", 1);
		put("Z", 7);
	}};

	public static final int getValueFor(final String key) {
		if (!map.containsKey(key)) {
			return 0;
		}

		return map.get(key);
	}

	public static NameAnalysisResults computeNameValues(final String name) {
		final ArrayList<Integer> values = new ArrayList<>();
		final int size = name.length();
		int compoundValue = 0;

		for (int i = 0; i < size; i++) {
			String letter = String.valueOf(name.charAt(i)).toUpperCase();
			int numerical = getValueFor(letter);

			if (numerical > 0) {
				values.add(numerical);
				compoundValue += numerical;
			}
		}

		final int singleValue = computeDigitalRoot(compoundValue);

		return new NameAnalysisResults(name, compoundValue, singleValue, values);
	}

	public static int computeDigitalRoot(int n) {
		// Check for master numbers
		if (n == 11 || n == 22) {
			return n;
		}

		if (n == 0) {
			return 0;
		}

		if (n % 9 == 0) {
			return 9;
		}

		return n % 9;
	}
}
