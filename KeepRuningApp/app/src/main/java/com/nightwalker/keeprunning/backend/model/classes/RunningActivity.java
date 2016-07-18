package com.nightwalker.keeprunning.backend.model.classes;

import com.nightwalker.keeprunning.backend.model.enums.RunningActivityEnum;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Westi on 7/18/2016.
 */
public class RunningActivity {

    private long activityId;

    private long parentId;

    // time will be represented in seconds;
    private int timeElapsed = 0;

    // distance will be represented in meters
    private int distance = 0;

    // speed will be represented in kilometers/hour
    private double averageSpeed = 0;

    private Date date;

    private RunningActivityEnum type;
    private ArrayList<RunningActivity> laps;


    public RunningActivity(){
        super();
        laps = new ArrayList<RunningActivity>();
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public RunningActivityEnum getType() {
        return type;
    }

    public void setType(RunningActivityEnum type) {
        this.type = type;
    }

    public ArrayList<RunningActivity> getLaps() {
        return laps;
    }

    public void setLaps(ArrayList<RunningActivity> laps) {
        this.laps = laps;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
