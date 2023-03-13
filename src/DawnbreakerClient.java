
import processing.core.*;

public class DawnbreakerClient extends PApplet {
 public static void main(String args []) { PApplet.main("DawnbreakerClient");}

@Override
public void settings() {
 size(1920,1080);
 }
 public void setup(){
     clear();
     background(133,133,170);
 }

 public void draw(){
     rect(150,150,100,100);
 }

}