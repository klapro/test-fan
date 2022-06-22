package com.klapro.testfan;

enum Direction {
    CLOCKWISE,
    COUNTERCLOCKWISE
}


public class Fan {

    public static int OFF = 0;
    private static final int MAX_SPEED = 3;


    private Direction directionSetting = Direction.CLOCKWISE;
    private int speedSetting = OFF;

    public void switchDirection() {
        if (this.directionSetting == Direction.CLOCKWISE) {
            this.directionSetting = Direction.COUNTERCLOCKWISE;
        } else {
            this.directionSetting = Direction.CLOCKWISE;
        }
    }

    public int getSpeed() {
        return this.speedSetting;
    }

    public Direction getDirection() {
        return this.directionSetting;
    }

    public void increaseSpeed() {
        speedSetting++;
        if (speedSetting > MAX_SPEED) {
            speedSetting = OFF;
        }
    }

    @Override
    public String toString(){
        String speedText = "" + this.speedSetting;

        if (this.speedSetting == OFF) {
            speedText += " (OFF)";
        }

        String directionText = "";

        if (this.directionSetting == Direction.CLOCKWISE) {
            directionText = "clockwise";
        } else {
            directionText = "counterclockwise";
        }

        return "FAN || speed : " +  speedText + " | direction : " + directionText;
    }
}
