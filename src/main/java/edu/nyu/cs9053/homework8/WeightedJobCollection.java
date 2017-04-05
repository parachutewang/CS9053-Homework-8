package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class WeightedJobCollection implements Iterable<WeightedJob> {

	private final List<WeightedJob> jobList;
	private int count = 1;

	public WeightedJobCollection() {
		jobList = new ArrayList<WeightedJob>();
	}

	public void add(WeightedJob... jobs) {
		if (jobs == null)
			return;
		for (WeightedJob job : jobs) {
			if (job.getStartTime() > job.getEndTime()) {
				throw new IllegalArgumentException("Start time must early than end time!");
			} else {
				jobList.add(job);
				job.setLabel(count);
				count++;
			}
		}
	}

	public void sort() {
		Function<WeightedJob, Integer> function = u -> u.getEndTime();
		Comparator<WeightedJob> compare = Comparator.comparing(function);
		Collections.sort(jobList, compare);
	}

	public WeightedJob get(int index) {
		return jobList.get(index);
	}

	public int size() {
		return jobList.size();
	}

	public void printMaxJob(WeightedJobCollection jobList) {
		int totalValue = 0;
		System.out.print("Max job set is ");
		for (int i = 0; i < jobList.size(); i++) {
			System.out.print("(" + jobList.get(i).getStartTime() + "," + jobList.get(i).getEndTime() + ","
					+ jobList.get(i).getValue() + ") ");
			totalValue += jobList.get(i).getValue();
		}
		System.out.println();
		System.out.print("Total value is " + totalValue);

	}

	public Iterator<WeightedJob> iterator() {
		return jobList.iterator();
	}

}
