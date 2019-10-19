package com.amazon.question;

import java.util.*;

public class FavoriteGenres {
    Map<String, List<String>> userMap;

    Map<String, List<String>> genreMap;

    public FavoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        this.userMap = userMap;
        this.genreMap = genreMap;
    }

    public Map<String, Object[]> favoritegenreStringListMap(){
        Map<String , Object[]> stringPairMap =new HashMap<>();
        Map<String,String> genreSongMapping =new HashMap<>();
        for(Map.Entry<String, List<String>>  stringListEntry :genreMap.entrySet()){
            for(String s :stringListEntry.getValue())
                genreSongMapping.put(s,stringListEntry.getKey() );
        }


        for(Map.Entry<String, List<String>>  stringListEntry  : userMap.entrySet()){
                int maxCount =0;
                Set<String> l =new HashSet<>();
                Map<String ,Integer> stringIntegerMap =new HashMap<>();
                for(String songs:stringListEntry.getValue()){
                    String song  =genreSongMapping.get(songs);
                    int count = stringIntegerMap.getOrDefault(song ,0)+1;
                    stringIntegerMap.put(song ,count);
                    if(count==maxCount)
                        l.add(song);
                    if(count > maxCount){
                        l =new HashSet();
                        l.add(song);
                         maxCount=count;
                    }
                }
                stringPairMap.put(stringListEntry.getKey() , l.toArray());
            }
        return stringPairMap;
    }

    public void print(Map<String, Object[]> stringMap){
        for(Map.Entry<String, Object[]> entry :stringMap.entrySet()){
            System.out.print(entry.getKey() +" ");
            for(Object o :entry.getValue())
                System.out.print(o+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> list1 =new ArrayList<>(); list1.add("song1");list1.add("song2");list1.add("song3");list1.add("song4");list1.add("song8");
        List<String> list2 =new ArrayList<>(); list2.add("song5");list2.add("song6");list2.add("song7");
        Map<String ,List<String>> userSongs =new HashMap<>();
        userSongs.put("David" , list1);userSongs.put("Emma" , list2);
        Map<String ,List<String>> songGener =new HashMap<>();
        list1 =new ArrayList<>();list1.add("song1");list1.add("song3");
        songGener.put("Rock", list1);
        list1 =new ArrayList<>();list1.add("song7");
        songGener.put("Dubstep", list1);
        list1 =new ArrayList<>();list1.add("song2");list1.add("song4");
        songGener.put("Techno", list1);
        list1 =new ArrayList<>();list1.add("song5");list1.add("song6");
        songGener.put("Pop", list1);
        list1 =new ArrayList<>();list1.add("song8");list1.add("song9");
        songGener.put("Jazz", list1);
        FavoriteGenres favoriteGenres =new FavoriteGenres(userSongs , songGener);
        favoriteGenres.print(favoriteGenres.favoritegenreStringListMap());
    }

}
