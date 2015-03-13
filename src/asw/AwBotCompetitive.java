/**
 * To create a competitive robot that could beat other robots.
 * 
 * package aswbot for ICS 413 Homework 9
 */
package asw;

import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * @author Anthony Wu
 * Main Class extending Robot class.
 * gunPower Keep track of the current gun power.
 * inRange A flag indicates if opponent is a melee-typed robot or not.
 */
public class AwBotCompetitive extends Robot {

  //Keep track of the current gun power
  public double gunPower = 1;
  //A flag indicates if opponent is a melee-typed robot or not.
  public boolean inRange = true;
  
  /**
   * Define basic robot action.
   */
  public void run() {
    
    
    while (true) {
     
      if (this.inRange) {
        
        turnRadarRight(360);

      } 
      else {
        
        //Move forward and backward to get ready to evade
        ahead(195); 
        
        turnGunRight(360);
        back(195); 
        
        turnGunLeft(360);
        
      }
    }
    
  }
  
  
  /**
   * Perform 3 basic movements while robot is scanned.
   * Stable gun for melee-type robot
   * @param e scanned robot event 
   */
  public void onScannedRobot(ScannedRobotEvent e) {
    
    
    if (e.getDistance() < 400 && getEnergy() > 50) {
      
      this.inRange = true;
      turnLeft(getHeading());
      if (getGunHeading() != e.getBearing()) {
        
        if (e.getBearing() > 0) {
          if (getGunHeading() - e.getBearing() < 0) {
            turnGunRight(Math.abs(getGunHeading() - e.getBearing()));
          } 
          else {
            turnGunLeft(Math.abs(getGunHeading() - e.getBearing()));
          }
        } 
        else {
          if (getGunHeading() - e.getBearing() < 0) {
            turnGunLeft(360 - Math.abs(getGunHeading()) - Math.abs(e.getBearing()));
          } 
          else {
            turnGunRight(360 - Math.abs(getGunHeading()) - Math.abs(e.getBearing()));
          }
          
        }
      }
      
      if (e.getEnergy() >= 16) {
        //Fire in Max power
        this.gunPower = 16;
        fire(this.gunPower);
      } 
      else {
        //Save energy if opponent has less energy than max power
        this.gunPower = e.getEnergy();
        fire(this.gunPower);
      }
      
      
    }
    else {
      
      //General firing
      this.gunPower = 1;
      fire(this.gunPower);
      this.inRange = false;
      
    }
    
    
  }
  
  /**
   * onBulletHit callback.
   * Define what should be done when bullet is hit
   * @param hre bullet hit event
   */
  public void onBulletHit(BulletHitEvent hre) {
    //Increase gun power after hit.
    this.increasePower();
  }
  
  public double increasePower() {
    
    if (this.gunPower < 16 && !this.inRange) {
      this.gunPower++;
    }
    return this.gunPower;
  }
  
  /**
   * onBulletMissed callback.
   * Define what should be done when the bullet is missed
   * @param e bullet missed event
   */
  public void onBulletMissed(BulletMissedEvent e) {
    //reset gun power to normal
    this.gunPower = 1;
  }
  
  
  /**
   * onHitByBullet callback.
   * Define how the robot should behave when it is hit.
   * @param event hit by bullet event
   */
  public void onHitByBullet(HitByBulletEvent event) {
    
    if (!this.inRange) {
      turnLeft(1 * Math.random() + 90 - event.getBearing());
    }
    
  }
  

}
