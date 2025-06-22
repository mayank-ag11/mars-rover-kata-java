package com.technologyconversations.kata.marsrover;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public static RoverBuilder rover() {
        return new RoverBuilder();
    }

    public static CoordinatesBuilder coordinates() {
        return new CoordinatesBuilder();
    }

    static class RoverBuilder {
        private Coordinates coordinates;

        RoverBuilder() {
            this(new CoordinatesBuilder().build());
        }

        RoverBuilder(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public RoverBuilder with(CoordinatesBuilder coordinates) {
            this.coordinates = coordinates.build();
            return this;
        }

        public Rover build() {
            return new Rover(coordinates);
        }
    }

    static class CoordinatesBuilder {
        private Point x;
        private Point y;
        private Direction direction;
        private List<Obstacle> obstacles;

        CoordinatesBuilder() {
            this(new Point(0, 8), new Point(0, 8), Direction.NORTH, new ArrayList<Obstacle>());
        }

        CoordinatesBuilder(Point x, Point y, Direction direction, List<Obstacle> obstacles) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.obstacles = obstacles;
        }

        public CoordinatesBuilder x(Point x) {
            this.x = x;
            return this;
        }

        public CoordinatesBuilder y(Point y) {
            this.y = y;
            return this;
        }

        public CoordinatesBuilder with(Direction direction) {
            this.direction = direction;
            return this;
        }

        public CoordinatesBuilder with(List<Obstacle> obstacles) {
            this.obstacles = obstacles;
            return this;
        }

        public Coordinates build() {
            return new Coordinates(x, y, direction, obstacles);
        }
    }
}
