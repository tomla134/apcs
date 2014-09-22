/**
 * @(#)ch5walk.java
 *
 * ch5walk application
 *
 * @author 
 * @version 1.00 2014/9/12
 */
 
 import kareltherobot.*;
 
class StandardBot extends Robot{
	public StandardBot (int st, int av, Direction dir, int beeps){
		super(st, av, dir, beeps);
	}
	public boolean wallOnRight(){ // part one
		//move into position
		turnRight();
		//ask the question, part two
		if( !frontIsClear() ){
			//part three, put world back as was before question
			turnLeft();
			//part four, answer
			return true; 
		}
		else {// false 
		// same as part three and four
		turnLeft();
		return false;
		}
	}
	public void bouldering(){
			//assume at (1,1) facing North
			while( wallOnRight() ){
				move();
			}
		}
	public void turnAround(){
		turnLeft();
		
		turnLeft();
	}
	public void moveBackwards(){
			turnAround();
			move();
			turnAround();
			
		}
	public void walk(){
		while( frontIsClear()){
			move();		
		}
		while( !nextToABeeper() ){
			move();
		}
	}
	public void turnRight(){
		turnLeft();	
		turnLeft();	
		turnLeft();
	}
	public void gotoheaven(){
		turnRight();
		while ( nextToABeeper() ){
			pickBeeper();
			turnAround();
		} 
		if (! nextToABeeper() ){
			//dropAllBeepers();
			move();
			//else gotoheaven();
		}
	
		
		
	}
	}
public class beeperpick implements Directions {
	public static void main(String[] args) {
    	StandardBot Karel = new StandardBot (1, 1, North, 0);
    	Karel.bouldering();
    	Karel.turnOff();
	}
   	static {
        World.reset(); 
        World.readWorld("Z:\\Karel\\Worlds\\ch5bool.kwld"); 
        World.setDelay(5);  
        World.setVisible(true);
    }
}
