package statisticker;

import java.util.List;

import alerters.IAlerter;

public class StatsChecker {

	private float maxThreshold;
	private IAlerter[] alerters;

	public StatsChecker(float maxThreshold, IAlerter[] alerters) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
	}

	public void checkAndAlert(List<Float> numbers) {
		Statistics statistics = new Statistics();
		float max = statistics.getMax(numbers);
		if (!Float.isNaN(max) &&  max > this.maxThreshold) {
			for (IAlerter alerter : this.alerters) {
				alerter.alert();
			}
		}
	}

}
