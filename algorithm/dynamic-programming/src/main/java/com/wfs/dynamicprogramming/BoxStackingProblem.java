package com.wfs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BoxStackingProblem {

    private List<Box> boxes;

    public BoxStackingProblem(Box[] box) {
        this.boxes =generateAllCombition(box);
    }




    static class Box implements Comparable<Box>{
        int l,b,h;

        public Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
        }

        @Override
        public int compareTo(Box o) {
            return (o.b*o.l )- (this.b*this.l);
        }
    }

    public List<Box> generateAllCombition(Box[] box){
        List<Box> boxes =new ArrayList<>();
        for(int i=0;i<box.length;i++){
            Box bo =box[i];
            boxes.add(new Box(bo.l,bo.h,bo.b));
            boxes.add(new Box(bo.h,bo.b,bo.l));
            boxes.add(new Box(bo.b,bo.l,bo.h));
        }
        Collections.sort(boxes);
        return boxes;
    }

    public static void main(String[] args) {
        Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32) };

    }
}
