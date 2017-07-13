package com.wfs.devideConqur;

import java.util.*;

/**
 * Created by Suryasnata on 5/27/2017.
 * We are given an array of n points in the plane, and the problem is to find out the closest pair of points in the array. This problem arises in a number of applications.
 * For example, in air-traffic control, you may want to monitor planes that come too close together, since this may indicate a possible collision.
 * Recall the following formula for distance between two points p and q.
 */
public class ClosestPairOfPoints
{
    private List<Point> points;

    public ClosestPairOfPoints(List<Point> points) {
        this.points = points;
    }


    public static void main(String[] args) {
        List<Point> points=new ArrayList<>();
        points.add(new Point(1,6));points.add(new Point(2,4));points.add(new Point(2,11));points.add(new Point(3,2));points.add(new Point(4,2));
        points.add(new Point(4,9));points.add(new Point(4,12));points.add(new Point(8,1));points.add(new Point(8,7));points.add(new Point(9,10));
        points.add(new Point(10,3));points.add(new Point(10,6));points.add(new Point(11,1));points.add(new Point(11,10));points.add(new Point(13,5));
        points.add(new Point(13,8));points.add(new Point(13,12));
        ClosestPairOfPoints closestPairOfPoints=new ClosestPairOfPoints(points);
        closestPairOfPoints.getClosetest();
    }

    public double getClosetest()
    {
        Collections.sort(points , new CompareX());
        return  getCloset(points , 0 , points.size()-1);
    }

    private double getCloset(List<Point> points ,int start , int end )
    {
        if(Math.abs(end - start) <=3)
            return  getBtruteForce( points , start , end);

        int mid = (end - start)/2;
        Point midPoint = points.get(mid);

        // Consider the vertical line passing through the middle point
        // calculate the smallest distance dl on left of middle point and
        // dr on right side
        double dl = getCloset(points, start , mid);
        double dr = getCloset(points  , mid+1, end);

        // Find the smaller of two distances
        double d = Math.min(dl, dr);

        // Build an array strip[] that contains points close (closer than d)
        // to the line passing through the middle point
        Point strip[] =new Point[end - start+1]  ;

        int j = 0;
        for (int i = start; i <= end; i++)
            if (Math.abs(points.get(i).x - midPoint.x) <= d)
            {
                strip[j] = points.get(i); j++;
            }


        // Find the closest points in strip.  Return the minimum of d and closest
        // distance is strip[]
        return Math.min(d, stripClosest(points, j, d) );
    }

    // A utility function to find the distance beween the closest points of
    // strip of given size. All points in strip[] are sorted accordint to
    // y coordinate. They all have an upper bound on minimum distance as d.
    // Note that this method seems to be a O(n^2) method, but it's a O(n)
    // method as the inner loop runs at most 6 times
    private double  stripClosest(List<Point> points, int size, double d)
    {
        double min = d ,currMin  = Double.MIN_VALUE;;  // Initialize the minimum distance as d
        Collections.sort(points , new CompareY());
        // Pick all points one by one and try the next points till the difference
        // between y coordinates is smaller than d.
        // This is a proven fact that this loop runs at most 6 times
        for (int i = 0; i < size; ++i)
            for (int j = i+1; j < size && (points.get(j).y - points.get(i).y) < min; ++j)
                if ((currMin = getDistance(points.get(i),points.get(j))) < min)
                    min = currMin;
        return min;
    }

    private double getBtruteForce(List<Point> points ,int start , int end)
    {
        double min = Double.MAX_VALUE, currMin  = Double.MIN_VALUE;
        for (int i = start; i <= end; i++)
            for (int j = i+1; j <= end; ++j)
                if ( (currMin = getDistance(points.get(i), points.get(j))) < min)
                    min = currMin;
        return min;
    }

    private double getDistance(Point  p1, Point p2)
    {
        return Math.sqrt( (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y) );
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class CompareX implements Comparator<Point>
    {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    }
    class CompareY implements Comparator<Point>
    {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.y - o2.y;
        }
    }
}
