package com.klapro.testfan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FanTest {

    private Fan fan;

    @BeforeEach
    void setup() {
        this.fan = new Fan();
    }

    @Test
    void testSpeedIncrease() {
        assertFan(Direction.CLOCKWISE, Fan.OFF);

        for (int i = 1; i <= 3; i++) {
            fan.increaseSpeed();
            assertFan(Direction.CLOCKWISE, i);
        }

        fan.increaseSpeed();
        assertFan(Direction.CLOCKWISE, Fan.OFF);
    }

    @Test
    void testChangeDirection() {
        assertFan(Direction.CLOCKWISE, Fan.OFF);

        fan.switchDirection();
        assertFan(Direction.COUNTERCLOCKWISE, Fan.OFF);

        fan.switchDirection();
        assertFan(Direction.CLOCKWISE, Fan.OFF);

        fan.increaseSpeed();
        assertFan(Direction.CLOCKWISE, 1);

        fan.switchDirection();
        assertFan(Direction.COUNTERCLOCKWISE, 1);

        fan.increaseSpeed();
        assertFan(Direction.COUNTERCLOCKWISE, 2);

        fan.switchDirection();
        assertFan(Direction.CLOCKWISE, 2);

        fan.switchDirection();
        assertFan(Direction.COUNTERCLOCKWISE, 2);

        fan.increaseSpeed();
        assertFan(Direction.COUNTERCLOCKWISE, 3);

        fan.switchDirection();
        assertFan(Direction.CLOCKWISE, 3);

        fan.switchDirection();
        assertFan(Direction.COUNTERCLOCKWISE, 3);

        fan.increaseSpeed();
        assertFan(Direction.COUNTERCLOCKWISE, Fan.OFF);

        fan.switchDirection();
        assertFan(Direction.CLOCKWISE, Fan.OFF);
    }

    private void assertFan(Direction direction, int speed) {
        assertEquals(speed, fan.getSpeed());
        assertEquals(direction, fan.getDirection());
    }
}
