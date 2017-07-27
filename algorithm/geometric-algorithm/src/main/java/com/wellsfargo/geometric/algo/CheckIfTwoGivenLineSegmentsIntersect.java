package com.wellsfargo.geometric.algo;

/**
 * Created by Suryasnata on 6/23/2017.
 *  Given two line segments (p1, q1) and (p2, q2), find if the given line segments intersect with each other.
 *  Before we discuss solution, let us define notion of orientation. Orientation of an ordered triplet of points in the plane can be
    –counterclockwise
    –clockwise
    –colinear
 */
public class CheckIfTwoGivenLineSegmentsIntersect {

    private Point p1 ;private Point q1 ;
    private Point p2 ;private Point q2 ;

    public CheckIfTwoGivenLineSegmentsIntersect(Point p1, Point q1, Point p2, Point q2) {
        this.p1 = p1;
        this.q1 = q1;
        this.p2 = p2;
        this.q2 = q2;
    }

    public boolean doIntersect()
    {
        return  doIntersect(p1,q1,p2,q2);
    }

    private boolean doIntersect(Point p1 ,Point q1 , Point p2 , Point q2)
    {
        return false;
    }

    int orientation(Point p, Point q, Point r)
    {
        // See http://www.geeksforgeeks.org/orientation-3-ordered-points/
        // for details of below formula.
        int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0) return 0;  // colinear

        return (val > 0)? 1: 2; // clock or counterclock wise
    }
}
