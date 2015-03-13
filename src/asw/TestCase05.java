package asw;

import static org.junit.Assert.assertEquals;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.testing.RobotTestBed;

/**
 * Test case check if AwBot increase power.
 * @author anthonywu
 *
 */
public class TestCase05 extends RobotTestBed {

  AwBotCompetitive awbot = new AwBotCompetitive();
  
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
    return 1;
  }
  
  
  /**
   * Display result and assert if data is expected.
   * @param e Battle completed event.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent e) {
    
    assertEquals("Check power increase by 1", awbot.increasePower(), 2.0, 0);
    
  }
  
  
}
