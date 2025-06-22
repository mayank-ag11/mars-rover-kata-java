/*
 * Copyright 2025 Smarsh Inc.
 */

package com.technologyconversations.kata.marsrover;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static com.technologyconversations.kata.marsrover.TestDataBuilder.coordinates;

public class CoordinatesTest {
    @Test
    public void shouldMoveForwardTowardsNorth() {
        Coordinates coordinates = coordinates()
            .y(new Point(1, 8))
            .direction(Direction.NORTH)
            .build();

        coordinates.moveForward();
        assertEquals(2, coordinates.getY().getLocation());
    }

    @Test
    public void shouldMoveForwardTowardsEast() {
        Coordinates coordinates = coordinates()
            .x(new Point(1, 8))
            .direction(Direction.EAST)
            .build();

        coordinates.moveForward();
        assertEquals(2, coordinates.getX().getLocation());
    }

    @Test
    public void shouldMoveForwardTowardsSouth() {
        Coordinates coordinates = coordinates()
            .y(new Point(1, 8))
            .direction(Direction.SOUTH)
            .build();

        coordinates.moveForward();
        assertEquals(0, coordinates.getY().getLocation());
    }

    @Test
    public void shouldMoveForwardTowardsWest() {
        Coordinates coordinates = coordinates()
            .x(new Point(1, 8))
            .direction(Direction.WEST)
            .build();

        coordinates.moveForward();
        assertEquals(0, coordinates.getX().getLocation());
    }

    @Test
    public void shouldMoveBackwardTowardsSouth_givenCurrentDirectionIsNorth() {
        Coordinates coordinates = coordinates()
            .y(new Point(1, 8))
            .direction(Direction.NORTH)
            .build();

        coordinates.moveBackward();
        assertEquals(0, coordinates.getY().getLocation());
    }

    @Test
    public void shouldMoveBackwardTowardsWest_givenCurrentDirectionIsEast() {
        Coordinates coordinates = coordinates()
            .x(new Point(1, 8))
            .direction(Direction.EAST)
            .build();

        coordinates.moveBackward();
        assertEquals(0, coordinates.getX().getLocation());
    }

    @Test
    public void shouldMoveBackwardTowardsNorth_givenCurrentDirectionIsSouth() {
        Coordinates coordinates = coordinates()
            .y(new Point(1, 8))
            .direction(Direction.SOUTH)
            .build();

        coordinates.moveBackward();
        assertEquals(2, coordinates.getY().getLocation());
    }

    @Test
    public void shouldMoveBackwardTowardsEast_givenCurrentDirectionIsWest() {
        Coordinates coordinates = coordinates()
            .x(new Point(1, 8))
            .direction(Direction.WEST)
            .build();

        coordinates.moveBackward();
        assertEquals(2, coordinates.getX().getLocation());
    }

    @Test
    public void shouldChangeDirectionToWest_givenCurrentDirectionIsNorth() {
        Coordinates coordinates = TestDataBuilder.coordinates()
            .direction(Direction.NORTH)
            .build();

        coordinates.changeDirectionLeft();
        assertEquals(Direction.WEST, coordinates.getDirection());
    }

    @Test
    public void shouldChangeDirectionToEast_givenCurrentDirectionIsNorth() {
        Coordinates coordinates = TestDataBuilder.coordinates()
            .direction(Direction.NORTH)
            .build();

        coordinates.changeDirectionRight();
        assertEquals(Direction.EAST, coordinates.getDirection());
    }

    @Test
    public void shouldPrintCoordinates() {
        Coordinates coordinates = TestDataBuilder.coordinates().build();

        assertEquals("0 X 0 N", coordinates.toString());
    }

    @Test
    public void shouldPrintCoordinatesWithStatusObstacleFound() {
        Coordinates coordinates = TestDataBuilder.coordinates()
            .obstacles(Collections.singletonList(new Obstacle(0, 1)))
            .build();

        coordinates.moveForward();
        assertEquals("0 X 0 N NOK", coordinates.toString());
    }
}
