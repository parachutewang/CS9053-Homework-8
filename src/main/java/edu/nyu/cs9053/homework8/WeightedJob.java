package edu.nyu.cs9053.homework8;

public class WeightedJob extends Job {

	private final int value;

	public WeightedJob(int startTime, int endTime, int value) {
		super(startTime, endTime);
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
