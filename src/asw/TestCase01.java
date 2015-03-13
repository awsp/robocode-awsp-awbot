package asw;

import static org.junit.Assert.assertEquals;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.testing.RobotTestBed;

/**
 * Test case check if AwBot wins sitting duck all the time and terminate within given turns.
 * @author anthonywu
 *
 */
public class TestCase01 extends RobotTestBed {

  /**
   * Override two robots in the battle field.
   * @return Names of the two robots.
   */
  @Override 
  public String getRobotNames() {
    // TODO Auto-generated method stub
    return "sample.SittingDuck,asw.AwBotCompetitive";
  }

  /**
   * Override the default amount of turn.
   * @return number of rounds robots will be fighting
   */
  @Override
  public int getNumRounds() {
    return 10;
  }
  
  
  /**
   * Display result and assert if data is expected.
   * @param e Battle completed event.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent e) {
    
    BattleResults[] battleResults = e.getIndexedResults();
    assertEquals("Check robot is this robot ", battleResults[1].getTeamLeaderName(), "asw.AwBotCompetitive*");
    assertEquals("Check rounds this robot wins ", battleResults[1].getFirsts(), this.getNumRounds());
    
  }
  
  
}
