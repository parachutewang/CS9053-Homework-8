package edu.nyu.cs9053.homework8;

import java.util.Iterator;

public class LambdaScheduler implements MaxNumberSubset {

	private final JobCollection jobResult;

	public LambdaScheduler() {
		jobResult = new JobCollection();
	}

	public JobCollection chooseMaxJobs(JobCollection jobCollection) {
		jobCollection.sort();
		Iterator<Job> iter = jobCollection.iterator();
		if (iter.hasNext())
			jobResult.add(iter.next());
		while (iter.hasNext()) {
			Job job = iter.next();
			if (job.getStartTime() >= jobResult.get(jobResult.size() - 1).getEndTime())
				jobResult.add(job);
		}
		return jobResult;
	}

	public static void main(String args[]) {
		JobCollection jobCollection = new JobCollection();
		jobCollection.add(new Job(1, 2), new Job(2, 7), new Job(1, 3), new Job(4, 6), new Job(4, 7), new Job(3, 5),
				new Job(5, 6), new Job(6, 8));
		LambdaScheduler scheduler = new LambdaScheduler();
		JobCollection result = new JobCollection();
		result = scheduler.chooseMaxJobs(jobCollection);
		jobCollection.printMaxJob(result);
	}
}
