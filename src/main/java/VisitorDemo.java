import org.robokind.api.animation.Animation;
import org.robokind.api.animation.messaging.RemoteAnimationPlayerClient;
import org.robokind.api.animation.player.AnimationJob;
import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.api.speech.messaging.RemoteSpeechServiceClient;
import org.robokind.client.basic.*;

import static org.robokind.api.motion.Robot.*;
import static org.robokind.client.basic.RobotJoints.*;

/**
 * VisitorDemo.java - class to show off our robot
 * @author Lianne Meah
 * @version 1.0
 */
public class VisitorDemo {
    // variables for class
    private static RemoteRobot myRobot;
    private static RemoteAnimationPlayerClient myPlayer;
    private static RemoteSpeechServiceClient mySpeaker;
    private static RobotPositionMap myGoalPositions;
    // start main method
    public static void main(String[] args) {
        long animLen;
        // config and settings - set robotID and IP 
        String robotID = "myRobot";
        String robotIP = "192.168.0.54";
        // set respective addresses
        UserSettings.setRobotId(robotID);
        UserSettings.setRobotAddress(robotIP);
        UserSettings.setAnimationAddress(robotIP);
        UserSettings.setSpeechAddress(robotIP);
        UserSettings.setSensorAddress(robotIP);
        UserSettings.setAccelerometerAddress(robotIP);
        UserSettings.setGyroscopeAddress(robotIP);
        UserSettings.setCompassAddress(robotIP);
        UserSettings.setCameraAddress(robotIP);
        // make connections
        myRobot = Robokind.connectRobot();
        myPlayer = Robokind.connectAnimationPlayer();
        mySpeaker = Robokind.connectSpeechService();
        // intro - load wave animation
        Animation introAnim = Robokind.loadAnimation("avatar_wave.anim.xml");
        AnimationJob introJob = myPlayer.playAnimation(introAnim);
        animLen = introAnim.getLength();
        Robokind.sleep(300 + animLen);
        
        //mySpeaker.speak("Hello, my name is Zeno. I am a friendly humanoid robot.
        //+ I am expressive and sophisticated, I can smile:");
        // smile expression
        // mySpeaker.speak("I can dance:");
        // dance animation
        // mySpeaker.speak("I am new to the department and still learning. The third year students
        // are going to teach me a lot this year.");
        
        // end of program - disconnect and exit
        Robokind.disconnect();
        System.exit(0);     
    } 
}
