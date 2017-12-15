package com.example.brunocarreraaguado.tddproject.model;

/**
 * Created by bruno.carrera.aguado on 14/12/17.
 */

public enum Direction {
    N, E, S, W;

    Direction left;
    Direction right;

    static {
        N.left = W;
        N.right = E;
        E.left = N;
        E.right = S;
        S.left = E;
        S.right = W;
        W.left = S;
        W.right = N;
    }

    Direction turnRight() {
        return this.right;
    }

    Direction turnLeft() {
        return this.left;
    }

}

