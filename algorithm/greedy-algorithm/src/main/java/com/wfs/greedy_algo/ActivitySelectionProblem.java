package com.wfs.greedy_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ActivitySelectionProblem {

    private int startTime[];

    private int endTime[];

    private List<Activity> activities ;

    private List<Activity> selectedActivities ;

    public ActivitySelectionProblem(int[] startTime, int[] endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activities = new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            activities.add(new Activity(startTime[i],endTime[i]));
        }
        Collections.sort(activities);
        this.selectedActivities =new ArrayList<>();
    }

    public List<Activity> getActivities(){
        int count =0;
        int endTime =-1;
        for(Activity activity :activities){
            int startTime = activity.start;
            if(startTime<=endTime)
                continue;
            endTime = activity.end ;
            count++;
            selectedActivities.add(activity);
        }
        return selectedActivities;
    }

    static class Activity implements Comparable<Activity>{
        int start ;
        int end ;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Activity[start->"+start+" , end->"+end+"]";
        }
    }

    public static void main(String[] args) {
        ActivitySelectionProblem activitySelectionProblem =new ActivitySelectionProblem(new int[]{5,1,3,0,5,8}, new int[]{9,2,4,6,7,9});
        System.out.println(activitySelectionProblem.getActivities());
    }
}
