package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayControllerTest {

    private PlayController playController;
    private Game game;
    private Board board;

    public PlayControllerTest() {
        game = new Game();
        board = new Board();
        playController = new PlayController(game, board);
    }

    @Test
    public void givenPlayControllerGoodMovemment() {
        Coordinate origin = new Coordinate(6, 1);
        Coordinate target = new Coordinate(5, 2);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

}
