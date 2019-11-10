package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
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
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    private Error advance(Coordinate[][] coordinates){
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = playController.move(coordinates[i][0], coordinates[i][1]);
        }
        return error;
    }

    private void boardWithOneBlackPiece(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Piece piece= board.getPiece(coordinate);
                if (!coordinate.equals(new Coordinate(2,3)) && piece != null){
                    board.remove(coordinate);
                }
            }
        }
    }

    @Test
    public void testGivenGameWhenMovementEatLastPieceThenOk() {
        boardWithOneBlackPiece();
        assertNull(this.advance(new Coordinate[][] {
            { new Coordinate(5, 0), new Coordinate(4, 1) },
            { new Coordinate(2, 3), new Coordinate(3, 2) },
            { new Coordinate(4, 1), new Coordinate(2, 3) },
        }));
    }
}
