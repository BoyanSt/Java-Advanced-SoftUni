import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem_06_TrackTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.valueOf(scan.nextLine());
        ArrayDeque<Station> queue = new ArrayDeque<>();
        int gasInThank = 0;
        boolean foundFirst = false;
        int index = 0;

        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            int gas = Integer.parseInt(token[0]);
            int distance = Integer.parseInt(token[1]);
            Station station = new Station(gas, distance);
            queue.addLast(station);
        }

        while (true){
            Station currStation = queue.removeFirst();
            queue.addLast(currStation);
            gasInThank += currStation.getGasGiven();

            Station firstStation = currStation;
            int helpIndex = 1;

            while (gasInThank >= currStation.getDistanceToNext()){
                gasInThank -= currStation.getDistanceToNext();
                currStation = queue.removeFirst();
                queue.addLast(currStation);
                gasInThank += currStation.getGasGiven();
                helpIndex++;

                if (currStation == firstStation){
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst){
                break;
            }

            index += helpIndex;
            gasInThank = 0;
        }
        System.out.println(index);

    }
}

class Station{
    private int gasGiven;
    private int distanceToNext;

    public Station(int gasGiven, int distanceToNext){
        this.gasGiven = gasGiven;
        this.distanceToNext = distanceToNext;
    }

    public int getDistanceToNext() {
        return distanceToNext;
    }

    public int getGasGiven() {
        return gasGiven;
    }
}
