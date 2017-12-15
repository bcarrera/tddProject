package com.example.brunocarreraaguado.tddproject.model;

import java.util.ArrayList;

/**
 * Created by bruno.carrera.aguado on 14/12/17.
 */

public class Rover {

    final static int DEFAULT_X = 0;
    final static int DEFAULT_Y = 0;
    final static Direction DEFAULT_DIRECTION = Direction.N;

    int position_x;
    int position_y;
    Direction direction;

    public Rover() {
        this(DEFAULT_X, DEFAULT_Y);
    }

    public Rover(int position_x, int position_y) { this.position_x = position_x;
        this.position_y = position_y;
        this.direction = DEFAULT_DIRECTION;
    }

    public void applyCommand(String commands) {
        for (char command: commands.toCharArray()) {

            switch (command) {
                case 'R':
                    this.direction = direction.turnRight();
                    break;
                case 'L':
                    this.direction = direction.turnLeft();
                    break;
                case 'F':
                    position_y = position_y + 1;
/*                case 'B':
                    break;*/
            }

        }
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
