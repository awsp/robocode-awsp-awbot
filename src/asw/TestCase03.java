package asw;

import static org.junit.Assert.assertEquals;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.events.TurnEndedEvent;
import robocode.control.snapshot.IRobotSnapshot;
import robocode.control.testing.RobotTestBed;


public class TestCase03 extends RobotTestBed {
  
  private double gunHeading = 0.0;
  private boolean gunTurn = false;
  /**
   * Override two robots in the battle field.
   * @return Names of the two robots.
   */
  @Override 
  public String getRobotNames() {
    // TODO Auto-generated method stub
    return "sample.MyFirstRobot,asw.AwBotCompetitive";
  }
  
  
  /**
   * Determine if the gun turn each turn.
   * @param event turn ended event.
   */
  @Override
  public void onTurnEnded(TurnEndedEvent event) {
    
    IRobotSnapshot robot = event.getTurnSnapshot().getRobots()[1];
    if (this.gunHeading != robot.getGunHeading()) {
      this.gunTurn = true;
    } 
    //System.out.println(this.gunHeading + " " + robot.getGunHeading());
    this.gunHeading = robot.getGunHeading();
    
    
  }
  
  
  
  /**
   * Assert result on battle completed.
   * @param e battle completed event
   */
  public void onBattleCompleted(BattleCompletedEvent e) {
    
    assertEquals("Check if gun turns ", this.gunTurn, true);
    
  }
  
  
}
