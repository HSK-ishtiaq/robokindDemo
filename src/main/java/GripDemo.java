import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import static org.robokind.api.motion.Robot.*;
import org.robokind.client.basic.Robokind;
import static org.robokind.client.basic.RobotJoints.*;

/**
 * GripDemo.java
 * @author Lianne Meah <lianne.meah@gmail.com>
 */
public class GripDemo {
    // class variables
    private static RobotPositionMap myGoalPositions;
    private static RemoteRobot myRobot;
    private static int timeFrame;
    // left joints
    JointId left_shoulder_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_PITCH));
    JointId left_shoulder_roll = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_ROLL));
    JointId left_elbow_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_YAW));
    JointId left_elbow_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_PITCH));
    JointId left_wrist_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_WRIST_YAW));
    JointId left_hand_grasp = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HAND_GRASP));
    // right joints
    JointId right_shoulder_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_PITCH));
    JointId right_shoulder_roll = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_ROLL));
    JointId right_elbow_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ELBOW_YAW));
    JointId right_elbow_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ELBOW_PITCH));
    JointId right_wrist_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_WRIST_YAW));
    JointId right_hand_grasp = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HAND_GRASP));
    
    /**
     * Main method - needs to be purged
     * @param args 
     */
    public static void main(String[] args) {
        String robotID = "myRobot";
        String robotIP = "192.168.0.54";
        // set addresses
        SetSettings settings = new SetSettings(robotID, robotIP);
        // make connection
        myRobot = Robokind.connectRobot();
        if (myRobot.isConnected()) {
            // do some stuff with the grip
        }
        
        // disconnnect and exit
        Robokind.disconnect();
        System.exit(0);
    }
    
    /**
     * method to extend the robot's arm
     * @param timeFrame the amount of time to move over
     * @param arm the arm to be used
     */
    public void armOut(int timeFrame, String arm) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        // move left arm if 0 is given
        arm = arm.toUpperCase();
        if (arm.equals("L") || arm.equals("LEFT")) {
            this.myGoalPositions.put(left_shoulder_pitch, new NormalizedDouble(0.5));
        }
        // move right arm if 1 is given
        else if (arm.equals("R") || arm.equals("RIGHT")) {
            this.myGoalPositions.put(right_shoulder_pitch, new NormalizedDouble(0.5));
        }
        // now move the arm
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
    /**
     * method to make robot 
     * @param timeFrame the amount of time to move over
     * @param arm the arm to be used: 0:Left, 1:Right
     */
    public void grasp(int timeFrame, String arm) {
        
    }
    
        
    /*public void grab(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(left_shoulder_pitch, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
        Robokind.sleep(200);
        this.myGoalPositions.put(left_wrist_yaw, new NormalizedDouble(0.9));
        this.myGoalPositions.put(left_hand_grasp, new NormalizedDouble(0.9));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
        Robokind.sleep(200);
    }*/
    
    /**
     * Method to make robot move to defaults
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void atDefaults(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        // push joints back to defaults
        this.myGoalPositions.put(left_shoulder_pitch, new NormalizedDouble(0.185185185185185));
        this.myGoalPositions.put(left_shoulder_roll, new NormalizedDouble(0.055555555555556));
        this.myGoalPositions.put(left_elbow_yaw, new NormalizedDouble(0.5));
        this.myGoalPositions.put(left_elbow_pitch, new NormalizedDouble(0.111111111111111));
        this.myGoalPositions.put(left_wrist_yaw, new NormalizedDouble(0.5));
        this.myGoalPositions.put(left_hand_grasp, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
}
