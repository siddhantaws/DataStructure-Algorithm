package com.wfs.google;

import java.util.*;

public class _1024VideoStitching {

    public static void main(String[] args) {
        int clips[][] = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(videoStitching(clips , 9));
    }
    public static int videoStitching(int[][] clips, int T) {
        final List<Clip> listOfClips = new ArrayList();
        for(int i=0;i<clips.length;i++)
            listOfClips.add(new  Clip(clips[i][0],clips[i][1]));
        listOfClips.sort((c1,c2)-> c1.start==c2.start ? c2.end-c1.end : c1.start-c2.start);
        final TreeMap<Integer , Clip> mapOfEndTimetoClip =new TreeMap<Integer , Clip>();
        mapOfEndTimetoClip.put(listOfClips.get(0).end ,listOfClips.get(0) );
        int currentMax = listOfClips.get(0).end ;

        for(int i=1;i<listOfClips.size();i++) {
            if(listOfClips.get(i).end >currentMax) {
                while(mapOfEndTimetoClip.ceilingKey(listOfClips.get(i).start)<listOfClips.get(i).start) {
                    mapOfEndTimetoClip.remove(listOfClips.get(i).start);
                }
                mapOfEndTimetoClip.put(listOfClips.get(i).end ,listOfClips.get(i));
            }
        }
        return mapOfEndTimetoClip.size();
    }

    public void remove(final TreeMap<Integer , Clip> mapOfEndTimetoClip ,final Clip clip) {
        Map.Entry<Integer , Clip> entry = mapOfEndTimetoClip.ceilingEntry(clip.start);
        if(clip.start<=entry.getValue().start){

        }
    }

    static class Clip{
        public int start;
        public int end;

        public Clip(int start ,int end ){
            this.start = start;
            this.end = end;
        }
    }
}
