package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.*;

public class PlayController {

    private Game game;
    private Board board;

    public PlayController(Game game, Board board) {
        this.game = game;
        this.board = board;
    }

    public Error move(Coordinate origin, Coordinate target) {
        return game.move(origin, target);
    }

    public Piece getPiece(Coordinate origin) {
        return null;
    }

    public Color getColor() {
        return null;
    }

}
