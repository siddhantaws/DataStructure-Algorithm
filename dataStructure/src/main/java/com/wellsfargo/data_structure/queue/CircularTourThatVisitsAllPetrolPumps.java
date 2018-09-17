package com.wellsfargo.data_structure.queue;

public class CircularTourThatVisitsAllPetrolPumps {

    // The function returns starting point if there is a possible solution,
    // otherwise returns -1
    public static int printTour(PetrolPump arr[], int n)
    {
        int start = 0;
        int end = 1;
        int curr_petrol = arr[start].petrol - arr[start].distance;

        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while(end != start || curr_petrol < 0)
        {

            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while(curr_petrol < 0 && start != end)
            {
                // Remove starting petrol pump. Change start
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if(start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += arr[end].petrol - arr[end].distance;

            end = (end + 1)%n;
        }

        // Return starting point
        return start;
    }

    static class PetrolPump
    {
        int petrol;
        int distance;

        // constructor
        public PetrolPump(int petrol, int distance)
        {
            this.petrol = petrol;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Petrol ->"+petrol+" distance ->"+distance;
        }
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),new PetrolPump(4, 5)};

        System.out.println(arr[printTour(arr, arr.length)]);

    }
}
