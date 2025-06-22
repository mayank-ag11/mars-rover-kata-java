package com.technologyconversations.kata.marsrover;

import org.junit.Test;

import java.util.Collections;

import static com.technologyconversations.kata.marsrover.TestDataBuilder.coordinates;
import static com.technologyconversations.kata.marsrover.TestDataBuilder.rover;
import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void shouldMoveForward() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .y(new Point(1, 8))
                    .with(Direction.NORTH))
            .build();

        rover.receiveSingleCommand('F');
        assertEquals(2, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldNotMoveForward_whenObstacleIsFound() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .y(new Point(1, 8))
                    .with(Direction.NORTH)
                    .with(Collections.singletonList(new Obstacle(0, 2))))
            .build();

        rover.receiveSingleCommand('F');
        assertEquals(1, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldMoveBackward() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .y(new Point(1, 8))
                    .with(Direction.NORTH))
            .build();

        rover.receiveSingleCommand('B');
        assertEquals(0, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldNotMoveBackward_whenObstacleIsFound() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .y(new Point(1, 8))
                    .with(Direction.NORTH)
                    .with(Collections.singletonList(new Obstacle(0, 0))))
            .build();

        rover.receiveSingleCommand('B');
        assertEquals(1, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldTurnLeft() throws Exception {
        Rover rover = rover()
            .with(coordinates().with(Direction.NORTH))
            .build();

        rover.receiveSingleCommand('L');
        assertEquals(Direction.WEST, rover.getCoordinates().getDirection());
    }

    @Test
    public void shouldTurnRight() throws Exception {
        Rover rover = rover()
            .with(coordinates().with(Direction.NORTH))
            .build();

        rover.receiveSingleCommand('R');
        assertEquals(Direction.EAST, rover.getCoordinates().getDirection());
    }

    @Test(expected = Exception.class)
    public void shouldThrowError_givenUnknownCommand() throws Exception {
        Rover rover = rover().build();
        rover.receiveSingleCommand('-');
    }

    @Test
    public void shouldMoveAsPerTheReceivedCommands() throws Exception {
        Rover rover = rover().build();
        rover.receiveCommands("FFFFRRF");
        assertEquals(3, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldStop_whenObstacleIsFound() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .with(Collections.singletonList(new Obstacle(0, 3))))
            .build();
        rover.receiveCommands("FFFRRF");
        assertEquals(2, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void shouldPrintPosition() throws Exception {
        Rover rover = rover().build();
        rover.receiveCommands("FFFFRRF");
        assertEquals("0 X 3 S", rover.getPosition());
    }

    @Test
    public void shouldPrintPositionWithStatusObstacleFound() throws Exception {
        Rover rover = rover()
            .with(
                coordinates()
                    .with(Collections.singletonList(new Obstacle(0, 3))))
            .build();
        rover.receiveCommands("FFFRRF");
        assertEquals("0 X 2 N NOK", rover.getPosition());
    }
}
