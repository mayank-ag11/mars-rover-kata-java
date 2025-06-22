package com.technologyconversations.kata.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void shouldIncreaseLocation() {
        Point point = new Point(0, 8);
        assertEquals(1, point.getForwardLocation());
    }

    @Test
    public void shouldDecreaseLocation() {
        Point point = new Point(4, 8);
        assertEquals(3, point.getBackwardLocation());
    }

    @Test
    public void shouldWrapAroundAtMaxLocation() {
        Point point = new Point(8, 8);
        assertEquals(0, point.getForwardLocation());
    }

    @Test
    public void shouldWrapAroundAtZero() {
        Point point = new Point(0, 8);
        assertEquals(8, point.getBackwardLocation());
    }
}
