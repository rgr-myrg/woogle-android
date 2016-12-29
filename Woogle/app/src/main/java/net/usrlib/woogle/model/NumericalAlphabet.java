package net.usrlib.woogle.model;

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
			return -1;
		}

		return map.get(key);
	}
}
