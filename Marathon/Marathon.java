// Author: Nabiha Bashir
// Marathon Class

import java.util.Scanner;
public class Marathon {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //-------get runner's name-------
        String first_name;
        System.out.print("What is your first name? ");
        first_name = in.next();

        //-------get length of marathon-------
        double length;
        System.out.print("How many miles did you run today? ");
        length = in.nextDouble();

        //-------get time-------
        System.out.println("How long did it take?");

        //convert hrs
        int hours;
        System.out.print("Hour(s): ");
        hours = in.nextInt();

        //convert mins
        int minutes;
        System.out.print("Minutes: ");
        minutes = in.nextInt();

        //convert secs
        int seconds;
        System.out.print("Seconds: ");
        seconds = in.nextInt();

        //-------calculate pace--------
        double timeMinutes = (hours * 60) + minutes + (seconds / 60);
        double pace = timeMinutes / length;  //in minutes = 8.867924528301888

        //convert pace to min:sec
        double pacesecs = (pace - ((int)(pace))) * 60;
        int pacemins = (int)pace;

        //-------calculate marathon time-------
        double marathonLength = 26.21875;  //in miles
        double marathonTime = (int)((pace * marathonLength) * 60);  //in secs

        //convert marathon time hours
        double marathonHours = (marathonTime / 3600);
        int marathonHoursInt = (int)marathonHours;

        //get marathon time minutes
        double marathonMinutes = ((marathonHours - marathonHoursInt) * 60);
        int marathonMinutesInt = (int)marathonMinutes;

        //get marathon time seconds
        int marathonSeconds = (int)((marathonMinutes - marathonMinutesInt) * 60) ;

        System.out.println("");
        System.out.println("Hi " + first_name + ",");
        System.out.printf("Your pace is %d:%.0f (minutes : seconds) \n", pacemins, pacesecs);
        System.out.printf("At this rate your marathon time would be %d:%02d:%02d", marathonHoursInt, marathonMinutesInt, marathonSeconds);
        System.out.println ("");
        System.out.println("Good luck with your training!");
        System.out.println(" ");

        //Pace Table
        System.out.println("Pace Table");
        System.out.println("Pace      Marathon");

        //declare time variables
        int userMarathonTime = ((marathonHoursInt*3600) + (marathonMinutesInt*60) + (marathonSeconds));
        double otherTime = 7264; //Eliud Kipchoge's time in secs
        String name = "<----Eliud Kipchoge";

        while (userMarathonTime > otherTime)
        {
            printTable(otherTime, name);
            name = "";
            otherTime += 1057 ;   //interval in secs
        }

        //End table with user's own pace + time
        String userName = "<----"+first_name;
        System.out.printf("%d:%02d \t %d:%02d:%02d \t %s ", pacemins, (int)pacesecs, marathonHoursInt, marathonMinutesInt, marathonSeconds, userName);
    }
    //create function to calculate paces + times for table
    public static void printTable ( double otherTime, String name) {

        //-------Table's marathon Times-------
        double otherTimeHour = (otherTime / 3600);
        int otherTimeHourInt = (int)(otherTimeHour);

        double otherTimeMinutes = ((otherTimeHour - otherTimeHourInt)*60);
        int otherTimeMinutesInt = (int)(otherTimeMinutes);

        double otherTimeSeconds = (int)((otherTimeMinutes - otherTimeMinutesInt) * 60);

        //-------Table's marathon Paces-------
        int otherTimeMinsTotal = (otherTimeHourInt * 60) + (otherTimeMinutesInt) + (int)(otherTimeSeconds/60);
        double otherPace = otherTimeMinsTotal / 26.21875; //pace based on full marathon length: 26.21875 mi

        //convert pace to min:sec
        double otherPaceSecs = Math.round((otherPace - ((int)otherPace)) * 60);

        int otherPaceMins = (int)otherPace;

        System.out.printf("%d:%02d \t %d:%02d:%02d \t %s \n", otherPaceMins, (int)otherPaceSecs, otherTimeHourInt,otherTimeMinutesInt, (int)otherTimeSeconds, name);

    }

}


