import controlP5.*;
import processing.core.*;

public class DawnbreakerClient extends PApplet {
    UI uI;
    ControlP5 cp5;
    String input;
 public static void main(String args []) { PApplet.main("DawnbreakerClient");}

@Override
public void settings() {
 size(1920,1080);
 }
 public void setup(){
     cp5 = new ControlP5(this);
     uI = new UI(cp5,this);
     clear();
     background(133,133,170);
     uI.Sender();
     SenderText();
 }

 public void draw(){

 }


    public void SenderText() {
        input = cp5.get(Textfield.class, "Sender").getText();
        System.out.println(input);

    }
}