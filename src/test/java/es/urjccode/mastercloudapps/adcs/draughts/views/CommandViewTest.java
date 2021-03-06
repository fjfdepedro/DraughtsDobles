package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CommandView commandView;

    @Test
    public void testCommandViewGoodMovementBlack(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("21.30\n");
        commandView.interact();
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }
    @Test
    public void testCommandViewGoodMovementWhite(){
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("61.52\n");
        commandView.interact();
        verify(playController).move(new Coordinate(6, 1), new Coordinate(5, 2));
    }

    @Test
    public void testCommandViewBadMovement(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString())).thenReturn("21.RR.90");
        commandView.interact();
        verify(console).writeln(Mockito.matches("(.*error)"));
    }

}
