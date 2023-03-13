import controlP5.*;
import processing.core.*;

public class DawnbreakerClient extends PApplet {
    UI uI;
    ControlP5 cp5;
    String inputSender;
    String inputRCPT;
    String message;
    String getMessage;

    public static void main(String args[]) {
        PApplet.main("DawnbreakerClient");
    }

    @Override
    public void settings() {
        size(1000, 500);
    }

    public void setup() {
        cp5 = new ControlP5(this);
        uI = new UI(cp5, this);
        clear();
        background(133, 133, 170);

        //ConfirmButton();
        TestB();
    }

    public void draw() {

    }


    public void TestB(){
    cp5.addButton("Test")
                .setPosition(width/2 -300, height/2-75)
                .setSize(182,45)
                .setColorValue(0)
                .setColorLabel(133)
                .setColorActive(155)
            .setColorBackground(177)
            ;
        cp5.addTextfield("Sender")
                .setCaptionLabel("Input Your Email")
                .setPosition(width/2 -300, height/2 -225)
                .setSize(282, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setAutoClear(true)
        ;
        cp5.addTextfield("Recept")
                .setCaptionLabel("Reciever")
                .setPosition(width/2 , height/2 -225)

                .setSize(282, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setAutoClear(true)
        ;
        cp5.addTextfield("Message")
                .setCaptionLabel("Message")
                .setPosition(width/2 -300, height/2 -150)
                .setSize(580, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setColorValue(133)
                .setAutoClear(true)
        ;
}
public void Test(){
    inputSender = cp5.get(Textfield.class, "Sender").getText();
    inputRCPT = cp5.get(Textfield.class,"Recept").getText();
    message = cp5.get(Textfield.class,"Message").getText();

    getMessage = message;
    text("Du har vundet en kage"+getMessage,0,0);
    System.out.println("test"+inputRCPT + inputSender);
}
}