package edu.nyu.cs9053.homework8;

public class LambdaWeightedScheduler {

	private final WeightedJobCollection jobResult;
	private int maxValue[];
	private int[] latestJob;

	public LambdaWeightedScheduler() {
		jobResult = new WeightedJobCollection();
	}

	public void findLatestJob(WeightedJobCollection jobCollection) {
		int size = jobCollection.size();
		latestJob = new int[size + 1];
		for (int i = 0; i <= size; i++)
			latestJob[i] = 0;
		for (int i = 2; i <= size; i++) {
			for (int j = i - 1; j > 0; j--) {
				if (jobCollection.get(i - 1).getStartTime() >= jobCollection.get(j - 1).getEndTime()) {
					latestJob[i] = j;
					break;
				}
			}
		}
	}

	public void findMaxValue(WeightedJobCollection jobCollection) {
		maxValue = new int[jobCollection.size() + 1];
		maxValue[0] = 0;
		for (int i = 1; i <= jobCollection.size(); i++) {
			int profit = jobCollection.get(i - 1).getValue();
			profit += maxValue[latestJob[i]];
			maxValue[i] = Math.max(profit, maxValue[i - 1]);
		}
	}

	public void chooseMaxJobs(int number, WeightedJobCollection jobCollection) {
		if (number == 0)
			return;
		else if (jobCollection.get(number - 1).getValue() + maxValue[latestJob[number]] > maxValue[number - 1]) {
			jobResult.add(jobCollection.get(number - 1));
			chooseMaxJobs(latestJob[number], jobCollection);
		} else
			chooseMaxJobs(number - 1, jobCollection);
	}

	public WeightedJobCollection chooseMaxJobs(WeightedJobCollection jobCollection) {
		int size = jobCollection.size();
		jobCollection.sort();
		findLatestJob(jobCollection);
		findMaxValue(jobCollection);
		chooseMaxJobs(size, jobCollection);
		return jobResult;
	}

	public static void main(String args[]) {
		WeightedJobCollection jobCollection = new WeightedJobCollection();
		LambdaWeightedScheduler scheduler = new LambdaWeightedScheduler();
		jobCollection.add(new WeightedJob(1, 2, 100), new WeightedJob(2, 7, 300), new WeightedJob(3, 7, 500),
				new WeightedJob(7, 9, 100), new WeightedJob(9, 10, 110), new WeightedJob(1, 2, 100));
		WeightedJobCollection result = new WeightedJobCollection();
		result = scheduler.chooseMaxJobs(jobCollection);
		jobCollection.printMaxJob(result);

	}
}
