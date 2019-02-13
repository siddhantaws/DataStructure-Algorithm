package com.wellsfargo.data_structure.queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindTourThatVisitsAllStations {

    private PetrolPump[] petrol;

    private int n;

    public FindTourThatVisitsAllStations(PetrolPump[] petrol) {
        this.petrol = petrol;
        this.n=petrol.length;
    }

    static class PetrolPump {
        int petrol;
        int distance;
        // constructor
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // The function returns starting point if there is a possible solution, otherwise returns -1
    public int printTour() {
        int start = 0;
        int end = 1;
        int curr_petrol = petrol[start].petrol - petrol[start].distance;
        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while(end != start || curr_petrol < 0) {
            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while(curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= petrol[start].petrol - petrol[start].distance;
                start = (start + 1) % n;
                // If 0 is being considered as start again, then there is no possible solution
                if(start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += petrol[end].petrol - petrol[end].distance;
            end = (end + 1)%n;
        }
        // Return starting point
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(4, 6),new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)};
        FindTourThatVisitsAllStations allStations =new FindTourThatVisitsAllStations(arr);
        allStations.printTour();
    }

}
