// Author: Nabiha Bashir
// CrazyTrain Class


package CrazyTrain;
import java.util.Scanner;

public class CrazyTrain {


    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int numCars;

        do {
            System.out.println("---------------------------");
            System.out.println("Welcome to the Crazy Train!");

            //---------ask user for number of cars---------
            System.out.println("Enter the number of train cars (Enter 0 to quit): ");
            numCars = in.nextInt();
            in.nextLine();
            //End program if user chooses to quit
            if (numCars == 0) {
                System.out.println("You have chosen to quit. Goodbye!");
                break;
            }


            //---------ask user for starting configuration---------
            System.out.println("Enter the order of the original in train A (separated by a single space): ");
            String trainA = in.nextLine();

            //store starting configuration in an array
            String[] trainAConfig = trainA.split(" ");

            //create 2 new queues to store starting configuration
            Queue startQueue = new Queue();
            Queue startQueue1 = new Queue();

            //add num of cars to starting queues
            for (int i = 0; i < trainAConfig.length; i++) {
                int car = (Integer.parseInt(trainAConfig[i]));
                startQueue.enQueue(car);
                startQueue1.enQueue(car);
            }

            //-------ask user for ending configuration-------
            System.out.println("Enter the order of the reconfiguration in train B (separated by a single space): ");
            String trainB = in.nextLine();

            //store ending configuration in an array
            String[] trainBConfig = trainB.split(" ");

            //create 2 new queues for ending configuration
            Queue endQueue = new Queue();
            Queue endQueue1 = new Queue();

            //add num of cars to duplicate ending queue only
            for (int i = 0; i < trainBConfig.length; i++){
                int car = (Integer.parseInt((trainBConfig[i])));
                endQueue1.enQueue(car);
            }

            //create an empty stack called station
            Stack stationStack = new Stack();
            int counter = 0;

            //test reconfiguration possibility while looping through multiple conditions
            while (true) {
                //if starting queue has cars & station is empty, push cars in station from starting queue
                if (startQueue.isEmpty() == false && stationStack.isEmpty() == true) {
                    stationStack.push(startQueue.deque());
                }
                 //if starting queue has no cars & station is empty, reconfiguration was a success
                 if (startQueue.isEmpty() == true && stationStack.isEmpty() == true) {
                     System.out.println("Smooth move - the reconfiguration is successful.");
                     break;
                 }
                //if top of station != car in ending config. & starting queue is empty means no success
                if (stationStack.top() != Integer.parseInt(trainBConfig[counter]) && startQueue.isEmpty() == true) {
                    System.out.println("Bozo! You can't do that! Reconfiguration is impossible.");
                    break;
                }
                //if top of station != car in ending config. & starting queue still has cars, push car from starting to station
                if (stationStack.top() != Integer.parseInt(trainBConfig[counter]) && startQueue.isEmpty() == false) {
                    stationStack.push(startQueue.deque());
                }
                //if station is not empty & top of station matches car in ending config., then add car to our copy of end queue
                if (stationStack.isEmpty() == false && stationStack.top() == Integer.parseInt(trainBConfig[counter]) ) {
                    endQueue.enQueue(stationStack.pop());
                    counter++;
                }
            }

            //display original configuration
            System.out.println("");
            System.out.print("Original (train A): ");
            startQueue1.display();

            //display target configuration
            System.out.println("");
            System.out.print("Target (train B): ");
            endQueue1.display();
            System.out.println("");

            //display actual configuration
            System.out.print("Actual: " );
            endQueue.display();
            System.out.println(" ");
        }
        while (numCars != 0);
    }
}

