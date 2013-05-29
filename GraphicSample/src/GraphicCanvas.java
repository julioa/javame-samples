
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julioa
 */
public class GraphicCanvas extends Canvas implements CommandListener{
    
    Command exitCommand = new Command("Salir", Command.EXIT, 1);
    Command barrasCommand = new Command("Barras", Command.OK, 1);
    Command tartaCommand = new Command("Tarta", Command.OK, 2);
    
    int[] values = {1,5,8,3,8};
    
    int tipo = 1;
    
    public GraphicCanvas() {
        this.addCommand(exitCommand);
        this.addCommand(barrasCommand);
        this.addCommand(tartaCommand);
    }

    protected void paint(Graphics g) {
        
        int width = this.getWidth();
        int height = this.getHeight();
        
        g.setColor(255,255,255);
        g.fillRect(0, 0, width, height);
        
        int seqMax = 0;
        int seqSum = 0;
        for (int i =0; i < values.length; i++) {
            seqSum += values[i];
            seqMax = Math.max(seqMax, values[i]);
        }
        
        for (int i=0; i < values.length; i++) {
            g.setColor(0,255,0);
            
            int barWidth = width/values.length;
            int barHeigth = height/seqMax * values[i];
                    
                    
            g.fillRect(((i)*width/values.length),height-barHeigth,barWidth, barHeigth);
        }        
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
