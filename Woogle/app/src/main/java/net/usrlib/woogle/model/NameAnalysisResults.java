package net.usrlib.woogle.model;

import java.util.ArrayList;

/**
 * Created by rgr-myrg on 1/1/17.
 */

public class NameAnalysisResults {
	private String name;
	private int compoundValue;
	private int singleValue;
	private ArrayList<Integer> computedValues;

	public NameAnalysisResults(
			String name,
			int compoundValue,
			int singleValue,
			ArrayList<Integer> computedValues) {
		this.name = name;
		this.compoundValue = compoundValue;
		this.singleValue = singleValue;
		this.computedValues = computedValues;
	}

	public String getName() {
		return name;
	}

	public int getCompoundValue() {
		return compoundValue;
	}

	public int getSingleValue() {
		return singleValue;
	}

	public ArrayList<Integer> getComputedValues() {
		return computedValues;
	}
}
