package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class JobCollection implements Iterable<Job> {

	private final List<Job> jobList;
	private int count = 1;

	public JobCollection() {
		jobList = new ArrayList<Job>();
	}

	public void add(Job... jobs) {
		if (jobs == null)
			return;
		for (Job job : jobs) {
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
		Function<Job, Integer> function = u -> u.getEndTime();
		Comparator<Job> compare = Comparator.comparing(function);
		Collections.sort(jobList, compare);
	}

	public Job get(int index) {
		return jobList.get(index);
	}

	public int size() {
		return jobList.size();
	}

	public void printMaxJob(JobCollection jobList) {
		int size = jobList.size();
		System.out.print("Max job set is ");
		for (int i = 0; i < size; i++) {
			System.out.print("(" + jobList.get(i).getStartTime() + "," + jobList.get(i).getEndTime() + ") ");
		}
		System.out.println();
		System.out.print("Total number is " + size);
	}

	public Iterator<Job> iterator() {
		return jobList.iterator();
	}

}
