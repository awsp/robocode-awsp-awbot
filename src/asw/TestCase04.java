package asw;

import static org.junit.Assert.assertEquals;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.events.TurnEndedEvent;
import robocode.control.snapshot.IRobotSnapshot;
import robocode.control.testing.RobotTestBed;

/**
 * Test case check if AwBot wins sitting duck all the time and terminate within given turns.
 * @author anthonywu
 *
 */
public class TestCase04 extends RobotTestBed {

  double xPosition = 0.0;
  double yPosition = 0.0;
  IRobotSnapshot robot = null;
  boolean flag = false;
  
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
   * Override the default amount of turn.
   * @return number of rounds robots will be fighting
   */
  @Override
  public int getNumRounds() {
    return 3;
  }

  
  /**
   * store robot into object
   * @param event Turn Ended event
   */
  @Override
  public void onTurnEnded(TurnEndedEvent event) {
   
    this.robot = event.getTurnSnapshot().getRobots()[1];
    
  }
  
  /**
   * Update new position
   */
  public void onTurnStart() {
    
    this.xPosition = this.robot.getX();
    this.yPosition = this.robot.getY();
    
  }
  
  /**
   * Display result and assert if data is expected.
   * @param e Battle completed event.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent e) {
    
    BattleResults[] battleResults = e.getIndexedResults();
    assertEquals("Check robot is this robot ", battleResults[1].getTeamLeaderName(), "asw.AwBotCompetitive*");
    if(this.xPosition != this.robot.getX()) {
      this.flag = true;
    }
    assertEquals(true, this.flag);
    
  }
  
  
}
