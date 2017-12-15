package com.example.brunocarreraaguado.tddproject.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.*;

/**
 * Created by bruno.carrera.aguado on 14/12/17.
 */

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    Rover sut;

    final static int OTHER_POSITION_X = 2;
    final static int OTHER_POSITION_Y= 3;

    @Before
    public void setUp() throws Exception {
        sut = new Rover();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sutIsNotNull()  throws Exception {
        assertNotNull(sut);
    }

    @Test
    public void initXPositionIs0() throws Exception {
        assertEquals(0, Rover.DEFAULT_X);
    }

    @Test
    public void initYPositionIs0() throws Exception {
        assertEquals(0, Rover.DEFAULT_Y);
    }

    @Test
    public void initRoverIsAtDefaultX() throws Exception {
        assertEquals(Rover.DEFAULT_X, sut.getPosition_x());
    }

    @Test
    public void initRoverIsAtDefaultY() throws Exception {
        assertEquals(Rover.DEFAULT_Y, sut.getPosition_y());
    }

    @Test
    public void initRoverAtPosition() throws Exception{
        sut = new Rover (OTHER_POSITION_X,OTHER_POSITION_Y);
        assertEquals(OTHER_POSITION_X, sut.getPosition_x());
        assertEquals(OTHER_POSITION_Y, sut.getPosition_y());
    }

    @Test
    public void initDirectionIsN() throws Exception{
        assertEquals(Direction.N, Rover.DEFAULT_DIRECTION);
    }

    @Test
    public void initDirectionIsDefault() throws Exception{
        assertEquals(Rover.DEFAULT_DIRECTION, sut.getDirection());
    }

    @Test
    public void turnOneMovementRightFromNorth() throws Exception{
        //prepare
        String command = "R";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.E, sut.getDirection());
    }

    @Test
    public void turnOneMovementLeftFromNorth() throws Exception{
        //prepare
        String command = "L";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.W, sut.getDirection());
    }

    @Test
    public void turnTwoMovementRightFromNorth() throws Exception{
        //prepare
        String command = "RR";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.S, sut.getDirection() );
    }

    @Test
    public void turnTwoMovementLeftFromNorth() throws Exception{
        //prepare
        String command = "LL";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.S, sut.getDirection());
    }

    @Test
    public void turnThreeMovementRightFromNorth() throws Exception{
        //prepare
        String command = "RRR";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.W, sut.getDirection());
    }

    @Test
    public void turnThreeMovementLeftFromNorth() throws Exception{
        //prepare
        String command = "LLL";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.E, sut.getDirection());
    }

    @Test
    public void turnFourMovementRightFromNorth () throws Exception{
        //prepare
        String command = "RRRR";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.N, sut.getDirection());
    }

    @Test
    public void turnFourMovementLeftFromNorth() throws Exception {
        //prepare
        String command = "LLLL";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.N, sut.getDirection());
    }

    @Test
    public void turnOneMovementRightFromEast() throws Exception {
        //prepare
        sut.setDirection(Direction.E);
        String command = "R";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.S, sut.getDirection());
    }

    @Test
    public void turnOneMovementLeftFromEast() throws Exception {
        //prepare
        sut.setDirection(Direction.E);
        String command = "L";
        //act
        sut.applyCommand(command);
        //assert
        assertEquals(Direction.N, sut.getDirection());
    }

    @Ignore
    @Test
    public void moveForwardFromDefaultStateIncrementsY() throws Exception {
        //act
        sut.applyCommand("F");
        int expectedValue = Rover.DEFAULT_Y + 1;
        //assert
        assertEquals(Rover.DEFAULT_X, sut.getPosition_x());
        assertEquals(expectedValue, sut.getPosition_y());
    }

    @Ignore
    @Test
    public void moveForwardFromInitialStateIncrementsY() throws Exception {
        //prepare
        sut = new Rover(12, 35);
        //act
        sut.applyCommand("F");
        //assert
        assertEquals(12, sut.getPosition_x());
        assertEquals(36, sut.getPosition_y());
    }

    //PRIMERA OPCIÓN
    @Test
    @Parameters(method = "parametersMoveForward")
    public void moveForwardParameters(int x, int y, int expectedX, int expectedY) throws Exception {
        Rover sut = new Rover(x, y);
        sut.applyCommand("F");
        //assert
        assertEquals(expectedX, sut.getPosition_x());
        assertEquals(expectedY, sut.getPosition_y());
    }

    private Object[] parametersMoveForward(){
        return new Object[] {new Object[]{0,0,0,1}, new Object[] {6,6,6,7}};
    }


    @Test
    @Parameters({"0,0,0,1", "6,6,6,7"})
    public void moveForwardParametersNoPrivateClass(int x, int y, int expectedX, int expectedY) throws Exception {
        Rover sut = new Rover(x, y);
        sut.applyCommand("F");
        //assert
        assertEquals(expectedX, sut.getPosition_x());
        assertEquals(expectedY, sut.getPosition_y());
    }

}