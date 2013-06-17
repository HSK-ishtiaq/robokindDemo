import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import static org.robokind.api.motion.Robot.*;
import org.robokind.client.basic.Robokind;
import static org.robokind.client.basic.RobotJoints.*;

/**
 * Expression.java
 * @author Lianne Meah <lianne.meah@gmail.com>
 */
public class Expression {
    private static RobotPositionMap myGoalPositions;
    private static RemoteRobot myRobot;
    private static int timeFrame;
    // declare joints
    JointId eyelids = new JointId(myRobot.getRobotId(), new Joint.Id(EYELIDS)); 
    JointId eyes_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(EYES_PITCH)); 
    JointId left_eye_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_EYE_YAW)); 
    JointId right_eye_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_EYE_YAW));
    JointId left_smile = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SMILE));
    JointId right_smile = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SMILE));
    JointId neck_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_PITCH));
        
    /**
     * Main method for testing/example usage
     */
    public static void main(String[] args) {
        String robotID = "myRobot";
        String robotIP = "192.168.0.54";
        // set addresses
        SetSettings settings = new SetSettings(robotID, robotIP);
        // make connection
        myRobot = Robokind.connectRobot();
        // make robot do something with face
        if (myRobot.isConnected()) {
            Expression expression = new Expression();
            expression.smile(1000);
            Robokind.sleep(1000);            
            expression.nod(1000);
            Robokind.sleep(500);
            expression.atDefaults(1000);
            Robokind.sleep(1000);
        }
    }
    /**
     * Default constructor
     */
    public Expression() {
        
    }
    
    /**
     * Method to make robot smile
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void smile(int timeFrame) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(left_smile, new NormalizedDouble(0.9));
        this.myGoalPositions.put(right_smile, new NormalizedDouble(0.9));
        // makes the robot look up
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.7));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    /**
     * Method to make robot frown
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void frown(int timeFrame) {
        
    }
    
    /**
     * Method to make robot move to defaults
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void atDefaults(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        // push joints back to defaults
        this.myGoalPositions.put(left_smile, new NormalizedDouble(0.5));
        this.myGoalPositions.put(right_smile, new NormalizedDouble(0.5));
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    /**
     * Method to make robot close eyes
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void closeEyes(int timeFrame) {
        
    }
    
    /** 
     * Method to make robot blink
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */
    public void blink(int timeFrame) {
        
    }
    
    /** 
     * Method to make robot nod
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */    
    public void nod(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.8));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(1000);
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.2));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(1000);
    }
    
     /** 
     * Method to make robot look up
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */    
    public void lookUp(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.8));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
     /** 
     * Method to make robot look down
     * @param timeFrame the amount of time to move joint over (milliseconds)
     */ 
    public void lookDown(int timeFrame) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.2));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
}
