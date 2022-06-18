package com.wfs.google;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _2115_Find_AllPossibleRecipesFromGivenSupplies {

    public static void main(String[] args) {
        final String recipes[] = {"bread"};
        final String supplies[] = {"yeast"};
        final List<List<String>> ingredients =new ArrayList<>();
        ingredients.add(Arrays.asList("flour","yeast"));
        findAllRecipes(recipes , ingredients , supplies).forEach(System.out::println);
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        final Map<Item<String> ,List<Item<String>>> mapOfItems =new HashMap<>();
        Arrays.stream(supplies).forEach(s -> mapOfItems.put(new Item<>(s,true ) , new ArrayList<>()));
        final List<String> returnString = new ArrayList<>();
        for(int i=0;i<ingredients.size();i++){
            final Item<String> item =new Item<>(recipes[i] , true);
            for(int j=0;j<ingredients.get(i).size();j++){
                mapOfItems.computeIfAbsent(item , k-> new ArrayList<Item<String>>());
                int finalI = i;
                int finalJ = j;
                mapOfItems.computeIfPresent(item , (k, v) -> {v.add(new Item<>(ingredients.get(finalI).get(finalJ)));
                    return v;
                });
            }
        }
        Arrays.stream(recipes).forEach(s -> dfs(mapOfItems,returnString , new Item<>(s,true)));
        return returnString;
    }

    private static boolean dfs(final Map<Item<String> ,List<Item<String>>> mapOfItems ,final List<String> returnString , final Item<String> source){
        final List<Item<String>> itemList = mapOfItems.getOrDefault(source , new ArrayList<>());
        if(returnString.contains(source.k))
            return true;
        if(itemList.size()==0){
            source.setSupplies(true);
            if(source.isRecipes)
                returnString.add(source.k);
            return true;
        }
        source.setSupplies(itemList.stream().allMatch(stringItem -> dfs(mapOfItems , returnString , stringItem)));
        if(source.isSupplies)
            returnString.add(source.k);
        return source.isSupplies;
    }

    static class Item<K>{
        private K k;
        private boolean isSupplies = false;
        private boolean isRecipes = false;
        Item(K k){
            this.k=k;
            this.isSupplies = false;
        }

        Item(final K k,final Boolean recipes){
            this.k=k;
            this.isRecipes = recipes;
        }

        public void setSupplies(final Boolean isSupplies){
            this.isSupplies= isSupplies;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item<?> item = (Item<?>) o;
            return Objects.equals(k, item.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "k=" + k+ "}";
        }
    }

}
