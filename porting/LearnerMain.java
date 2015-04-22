package porting;

import porting.Learner;

public class LearnerMain {
	public static void main(String... args) {
		Learner learner = new Learner();
		long t1 = System.currentTimeMillis();

		int x = 1000000;
		learner._log("This will learn in " + x + " iterations");

		for (int i = 0; i < x; i++) {
			learner.play(true, false);
		}
		long t2 = System.currentTimeMillis() - t1;
		learner.report();
		
		learner._log("\n\n");
		learner.showLessonsLearntFromRandomStates(10);

		
		learner._log("The end for " + x + " iterations took ( ms ) " + t2);

	}
}