package edu.nyu.cs9053.homework8;

public class Job {
	private final int startTime;
	private final int endTime;
	private int label;

	public Job(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int setLabel(int label) {
		return this.label = label;
	}

	public int getLabel() {
		return label;
	}

}
