import controlP5.CColor;
import controlP5.ControlP5;
import processing.core.PApplet;
public class UI {
   int Textwidth;
    int  Textheight;
    ControlP5 cp5;
    PApplet p;


    public UI(ControlP5 cp5,PApplet p){
        this.cp5 = cp5;
        this.p = p;
        Textwidth = p.width/2;
        Textheight = p.height/2;
    }


}
