package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem_II {
    private int[][] building;

    public TheSkylineProblem_II(int[][]building) {
        this.building = building;
    }

    private List<int[]> getSkyLineRec(int low ,int high ){
        List<int[]> skyLineList= new ArrayList<>();
        if(low>high){
            return skyLineList;
        }else if(low==high){
            int x1=building[low][0];
            int x2=building[low][1];
            int h=building[low][2];

            int element1[]={x1,h};
            int element2[]={x2,0};
            skyLineList.add(element2);
            skyLineList.add(0,element1);
            return skyLineList;
        }else{
            int mid= low + (high-low)/2;
            List<int[]> skyLineListLeft=getSkyLineRec(low,mid);
            List<int[]> skyLineListRight=getSkyLineRec(mid+1,high);
            return mergeSkyLine(skyLineListLeft , skyLineListRight);
        }

    }


    private List<int[]> mergeSkyLine(List<int[]> skyLineListLeft , List<int[]> skyLineListRight){
        int h1=0 ,h2=0;
        int newIndex=0;
        List<int[]> mergeSkyLineList= new ArrayList<>();
        while(true){
            if(skyLineListLeft.isEmpty() || skyLineListRight.isEmpty()){
                break;
            }
            int[] stripe1=skyLineListLeft.get(0);
            int[] stripe2=skyLineListRight.get(0);
            int mergedStriped[]=new int[2];
            if(stripe1[0]<stripe2[0]){//compare x coordinate
                mergedStriped[0] =stripe1[0];
                mergedStriped[1] =stripe1[1];
                //y for choosen one is less than the last seen height of skyline
                if(stripe1[1]<h2){
                    mergedStriped[1]=h2;
                }
                //update last seen height of skyline
                h1=stripe1[1];
                skyLineListLeft.remove(0);
            }else if(stripe2[0]<stripe1[0]){//compare x coordinate
                mergedStriped[0] =stripe2[0];
                mergedStriped[1] =stripe2[1];
                //y for choosen one is less than the last seen height of skyline
                if(stripe2[1]<h1){
                    mergedStriped[1]=h1;
                }
                //update last seen height of skyline
                h2=stripe2[1];
                skyLineListRight.remove(0);
            }

            else{
                mergedStriped[0] =stripe2[0];
                mergedStriped[1] =Math.max(stripe1[1] , stripe2[1]);
                h1=stripe1[1];
                h2= stripe2[1];
                skyLineListLeft.remove(0);
                skyLineListRight.remove(0);
            }
            mergeSkyLineList.add(mergedStriped);
        }
        if(skyLineListLeft.isEmpty()){
            while(!skyLineListRight.isEmpty()){
                mergeSkyLineList.add(skyLineListRight.remove(0));
            }
        }
        if(skyLineListRight.isEmpty()){
            while(!skyLineListLeft.isEmpty()){
                mergeSkyLineList.add(skyLineListLeft.remove(0));
            }
        }
        int current=0;
        while(current <mergeSkyLineList.size()){
            boolean dupeFound=true;
            int i=current+1;
            while((i<mergeSkyLineList.size()) && dupeFound){
                if(mergeSkyLineList.get(current)[1]== mergeSkyLineList.get(i)[1]){
                    dupeFound =true;
                    mergeSkyLineList.remove(i);
                }else {
                    dupeFound =false;
                }
            }
            current +=1;
        }
        return mergeSkyLineList;
    }

    public static void main(String[] args) {
        int[][] skyscrappers = {
                {2,9,10},
                {3,6,15},
                {5,12,12},
                {13,16,10},
                {15,17,5}
        };
        TheSkylineProblem_II theSkylineProblem_ii =new TheSkylineProblem_II(skyscrappers);
        List<int[]> list =theSkylineProblem_ii.getSkyLineRec(0,skyscrappers.length-1);
        for(int i[]: list){
            System.out.println(i[0]+"\t"+i[1]);
        }
    }
}
