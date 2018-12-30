package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CalculateAngleBetweenHourHandAndMinuteHand {

    private int hour ;

    private int min;

    public CalculateAngleBetweenHourHandAndMinuteHand(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public int getAngel(){

        if (hour == 12)
            hour = 0;
        if (min == 60)
            min = 0;
        // Calculate the angles moved by hour and minute hands
        // with reference to 12:00
        int hour_angle = (int)(0.5 * (hour*60 + min));
        int minute_angle = (int)(6*min);

        // Find the difference between two angles
        int angle = Math.abs(hour_angle - minute_angle);

        // smaller angle of two possible angles
        angle = Math.min(360-angle, angle);
        return angle;
    }
}
