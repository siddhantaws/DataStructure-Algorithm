package com.amazon.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    private List<List<Interval>> schedule;

    public EmployeeFreeTime(List<List<Interval>> schedule) {
        this.schedule = schedule;
    }

    public List<Interval> employeeFreeTime1() {
        int OPEN = 0, CLOSE = 1;

        List<int[]> events = new ArrayList<>();
        for (List<Interval> employee : schedule)
            for (Interval iv : employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, bal = 0;
        for (int[] event : events) {
            // event[0] = time, event[1] = command
            if (bal == 0 && prev >= 0)
                ans.add(new Interval(prev, event[0]));
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }


    public List<Interval> employeeFreeTime() {
        List<Interval> ans = new ArrayList();
        PriorityQueue<Job> pq = new PriorityQueue<Job>((a, b) ->
                schedule.get(a.eid).get(a.index).start -
                        schedule.get(b.eid).get(b.index).start);
        int ei = 0, anchor = Integer.MAX_VALUE;

        for (List<Interval> employee : schedule) {
            pq.offer(new Job(ei++, 0));
            anchor = Math.min(anchor, employee.get(0).start);
        }

        while (!pq.isEmpty()) {
            Job job = pq.poll();
            Interval iv = schedule.get(job.eid).get(job.index);
            if (anchor < iv.start)
                ans.add(new Interval(anchor, iv.start));
            anchor = Math.max(anchor, iv.end);
            if (++job.index < schedule.get(job.eid).size())
                pq.offer(job);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Interval>> lists = new ArrayList<>();
        List<Interval> list1 = new ArrayList<>();
        Interval i1 = new Interval(1, 2);Interval i2 = new Interval(5, 6);list1.add(i1);list1.add(i2);lists.add(list1);
        list1 = new ArrayList<>();
        i1 = new Interval(1, 3);list1.add(i1);lists.add(list1);
        list1 = new ArrayList<>();
        i1 = new Interval(4, 10);list1.add(i1);lists.add(list1);
        EmployeeFreeTime  time =new EmployeeFreeTime(lists);
        for(Interval interval: time.employeeFreeTime())
            System.out.println( interval.start +"\t"+interval.end);

    }
}

class Job {
    int eid, index;

    Job(int e, int i) {
        eid = e;
        index = i;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}