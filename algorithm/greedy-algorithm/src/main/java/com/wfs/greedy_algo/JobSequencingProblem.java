package com.wfs.greedy_algo;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class JobSequencingProblem {

    private Job[] jobs;

    private Job[] assignedJobs;

    public JobSequencingProblem(Job[] jobs) {
        this.jobs = jobs;
        Arrays.sort(jobs);
        this.assignedJobs = new Job[jobs[0].deadLine];
    }

    public Job[] getTotalJobScheduling() {
        for (int i = 0; i < jobs.length; i++) {
            int j = jobs[i].deadLine;
            for (j = Math.min(jobs[i].deadLine, j); j >= 0 && assignedJobs[j].id == 0; j--) {
                assignedJobs[j] = jobs[i];
                break;
            }
        }
        return assignedJobs;
    }

    static class Job implements Comparable<Job> {

        int id;
        int deadLine;
        int profit;

        public Job(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return o.profit - this.profit;
        }
    }



}


