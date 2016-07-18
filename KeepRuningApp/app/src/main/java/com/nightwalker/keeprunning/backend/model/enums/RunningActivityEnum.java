package com.nightwalker.keeprunning.backend.model.enums;

import com.nightwalker.keeprunning.utils.ProjectConstants;

/**
 * Created by Westi on 7/18/2016.
 */
public enum RunningActivityEnum{

    SIMPLE_RUNNING(0),
    KEEP_RYTHM(1),
    LONG_DISTANCE(2),
    SHORT_TRACKS(3);

    private int intValue;

    private RunningActivityEnum(int value) {
        intValue = value;
    }

    @Override
    public String toString() {
        switch (intValue){
            case 0:
                return ProjectConstants.SIMPLE_RUNNING;
            case 1:
                return ProjectConstants.KEEP_RHYTM;
            case 2:
                return ProjectConstants.LONG_DISTANCE;
            case 3:
                return ProjectConstants.SHORT_TRACKS;
            default:
                return ProjectConstants.SIMPLE_RUNNING;
        }
    }
}
