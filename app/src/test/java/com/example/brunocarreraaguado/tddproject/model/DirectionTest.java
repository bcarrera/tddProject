package com.example.brunocarreraaguado.tddproject.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bruno.carrera.aguado on 14/12/17.
 */
public class DirectionTest {

    Direction sut;

    @Before
    public void setUp() throws Exception {
        sut = Direction.N;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void turnRight(){
        assertEquals(Direction.E, sut.turnRight());
    }

    @Test
    public void turnLeft(){
        assertEquals(Direction.W, sut.turnLeft());
    }

}