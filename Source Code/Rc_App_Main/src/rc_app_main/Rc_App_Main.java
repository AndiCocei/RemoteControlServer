package rc_app_main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Rc_App_Main {

    static int i;
    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    static Robot robot;

    public static void main(String[] args) throws AWTException, UnknownHostException, InterruptedException {

        InetAddress inetAddress = InetAddress.getLocalHost();

        JFrame frame = new JFrame("Remote Control Server");
        frame.setSize(640, 360);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        JLabel labelIP = new JLabel("Local IP: " + inetAddress.getHostAddress(), SwingConstants.CENTER);
        frame.add(labelIP);
        frame.setVisible(true);

        try {
            robot = new Robot();
            ss = new ServerSocket(7800);
            while (true) {
                s = ss.accept();
                isr = new InputStreamReader(s.getInputStream());
                br = new BufferedReader(isr);
                message = br.readLine();

                if (message.equals("up")) {
                    robot.keyPress(KeyEvent.VK_UP);
                    robot.keyRelease(KeyEvent.VK_UP);
                }
                if (message.equals("down")) {
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                }
                if (message.equals("left")) {
                    robot.keyPress(KeyEvent.VK_LEFT);
                    robot.keyRelease(KeyEvent.VK_LEFT);
                }
                if (message.equals("right")) {
                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);
                }
                if (message.equals("space")) {
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                }
                if (message.equals("enter")) {
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }

                if (message.equals("volumeup")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("SndVol.exe -f");
                    sleep(90);
                    for (i = 0; i < 5; i++) {
                        robot.keyPress(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_UP);
                    }
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                }
                if (message.equals("volumedown")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("SndVol.exe -f");
                    sleep(90);
                    for (i = 0; i < 5; i++) {
                        robot.keyPress(KeyEvent.VK_DOWN);
                        robot.keyRelease(KeyEvent.VK_DOWN);
                    }
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                }

                if (message.contains(",")) {//mouse movement
                    float movx = Float.parseFloat(message.split(",")[0]);//extract movement in x direction
                    float movy = Float.parseFloat(message.split(",")[1]);//extract movement in y direction
                    Point point = MouseInfo.getPointerInfo().getLocation(); //get current mouse position
                    float nowx = point.x;//assign curent mouse position in x direction
                    float nowy = point.y;//assign curent mouse position in y direction
                    robot.mouseMove((int) (nowx + movx), (int) (nowy + movy));//move mouse to new location
                }
                if (message.equals("leftclick")) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }
                if (message.equals("middleclick")) {
                    robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                }
                if (message.equals("rightclick")) {
                    robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                }

                if (message.equals("restart")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("shutdown /r /t 0");
                }
                if (message.equals("shutdown")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("shutdown /s /t 0");
                }
                if (message.equals("sleep")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
                }
                if (message.equals("screenlock")) {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("Rundll32.exe User32.dll,LockWorkStation");
                }
            }
        } catch (IOException e) {
        }
    }
}
