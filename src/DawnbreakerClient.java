import controlP5.*;
import processing.core.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class DawnbreakerClient extends PApplet {
    UI uI;
    ControlP5 cp5;
    String inputSender;
    String inputRCPT;
    String message;
    String getMessage;
    String Subject;
     boolean pressed = false;
    //boolean pressed = false;

    public static void main(String args[]) {
        PApplet.main("DawnbreakerClient");

    }
        Scanner in = new Scanner(System.in);
        String startSyntax = "helo martin";
        String senderSyntax = "mail from: ";
        String recipientSyntax = "rcpt to: ";
        String messageSyntax = "data";
        String quitSyntax = "quit";


        //boolean pressed = false;



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
        text("Group 29 Email Services!" ,0,0);
        fill(133,177,177);
        //inputSender = cp5.get(Textfield.class, "Sender").getText();
    }

    public void Run(){
        try {

            Socket socketClient = new Socket("datacomm.bhsi.xyz", 2552);

            System.out.println("[CONNECTION] Connection Initiating...\n");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));

            String s, serverMsg;

            while ((serverMsg = reader.readLine()) != null) {
                System.out.println(serverMsg);
                if (serverMsg.startsWith("220")) {
                    System.out.println("[SERVER RESPONSE] Connection Established\n");
                    writer.write(startSyntax + "\r\n");
                    writer.flush();

                } else if (serverMsg.startsWith("250 comit")) {
                    System.out.println("[SERVER RESPONSE] Successful Login");
                    System.out.println("\nPlease enter the sender email address");
                    //String senderInput = in.nextLine();


                        writer.write(senderSyntax + inputSender+ "\r\n");
                        System.out.println(inputSender);
                        writer.flush();


                } else if (serverMsg.startsWith("250 2.1.0")) {
                    System.out.println("\nPlease enter a recipient email address");
                    writer.write(recipientSyntax + inputRCPT + "\r\n");
                    System.out.println(inputRCPT);
                    writer.flush();

                } else if (serverMsg.startsWith("250 2.1.5")) {
                    writer.write(messageSyntax  + "\r\n");
                    writer.flush();
                    System.out.print("\n");

                } else if (serverMsg.startsWith("354")) {
                    System.out.println("[SERVER RESPONSE] Sender and Recipient Email Addresses Confirmed");
                    System.out.println("\n[SERVER RESPONSE] Proceed with the Email Content");

                    // taking input for mail subject
                    System.out.println("Please enter the mail subject");
                    //writer.write(Subject + "\r\n");
                    //Scanner subject = new Scanner(System.in);
                    //String mailSubject = subject.nextLine();

                    // taking input for mail content
                    System.out.println("\nPlease enter the mail content");
                    System.out.println("End the message with a \".\"");
                    Scanner body = new Scanner(System.in);

                    String mail = "Subject: " + Subject + "\n" + message;

                    writer.write(mail + "\r\n");
                    writer.write("." + "\r\n");
                    writer.flush();
                    System.out.print("\n");

                } else if (serverMsg.startsWith("250 2.0.0 Ok: queued")) {
                    writer.write(quitSyntax + "\r\n");
                    writer.flush();
                    System.out.println("[SERVER RESPONSE] Success! Email is being sent out to Recipient");
                    System.out.print("\n");

                } else if (serverMsg.startsWith("221 2.0.0")) {
                    System.out.println("[CONNECTION] Connection Terminated");

                } else {
                    s = in.nextLine();
                    writer.write(s + "\r\n");
                    writer.flush();
                }
            }

        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestB(){
    cp5.addButton("SendMessage")
                .setPosition(width/2 -100, height/2)
                .setSize(182,45)
                .setColorValue(0)
                .setColorLabel(ControlP5Constants.ORANGE)
                .setColorActive(155)
            .setColorBackground(177)
            ;
        cp5.addTextfield("Sender")
                .setCaptionLabel("Input Your Email")
                .setPosition(width/2 -300, height/2 -225)
                .setSize(282, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setAutoClear(pressed)
        ;
        cp5.addTextfield("Recept")
                .setCaptionLabel("Reciever")
                .setPosition(width/2 , height/2 -225)

                .setSize(282, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setAutoClear(pressed)
        ;
        cp5.addTextfield("Message")
                .setCaptionLabel("Message")
                .setPosition(width/2 -300, height/2-75)
                .setSize(580, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setColorValue(ControlP5Constants.GREEN)
                .setAutoClear(pressed)
        ;
        cp5.addTextfield("Subject")
                .setCaptionLabel("Subject")
                .setPosition(width/2 -300, height/2 -150)
                .setSize(580, 62)
                .setAutoClear(false)
                .setColorLabel(000000)
                .setColorValue(ControlP5Constants.GREEN)
                .setAutoClear(pressed)
        ;
}
public void SendMessage(){
    inputSender = cp5.get(Textfield.class, "Sender").getText();
    inputRCPT = cp5.get(Textfield.class,"Recept").getText();
    message = cp5.get(Textfield.class,"Message").getText();
    Subject = cp5.get(Textfield.class,"Subject").getText();

    text("Du har vundet en kage"+getMessage,width/2,height/2-50);
    fill(255,100,33);
    Run();
    cp5.get(Textfield.class, "Sender").clear();
    cp5.get(Textfield.class,"Recept").clear();
    cp5.get(Textfield.class,"Message").clear();
    cp5.get(Textfield.class,"Subject").clear();
}
}