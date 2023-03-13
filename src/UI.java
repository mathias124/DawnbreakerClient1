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

    public void Sender(){
        cp5.addTextfield("Sender")
                .setCaptionLabel("Input Your Email")
                .setPosition(Textwidth -141, Textheight -250)
                .setSize(282, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
        ;
        p.rect(150,150,100,100);
    }
}
