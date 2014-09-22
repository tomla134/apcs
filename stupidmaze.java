/**
 * @(#)ch5walk.java
 *
 * ch5walk application
 *
 * @author 
 * @version 1.00 2014/9/12
 */
 
 import kareltherobot.*;
 //previously mariobeeperchallengething
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
	
	public boolean beeperAbove(){
		//assume facing east
		turnLeft(); move();
		if( nextToABeeper() ){ //frontIsClear
			turnAround(); move(); turnLeft();
			return true;
		}
		else {
			turnAround(); move(); turnLeft();
			return false;
		}
	}
	public void advance (){
		if ( !donewhenbeeperinfront() ){
		if ( !frontIsClear ()){
			turnLeft(); move();
			turnRight(); move();
			turnRight(); move(); 
			turnLeft(); }
		else {
			move();
		}
		}
		else { turnOff();
		}
	}
	public boolean donewhenbeeperinfront(){
		//I, get in position to ask question
		move();
		if ( !nextToABeeper() ) //II ask question
		//III, return to position
			{ turnAround(); move(); turnAround();
			return true; //IV, 
		}
		else //part III
		{ turnAround(); move(); turnAround();
		return false; //IV,
		}
	}
	public void checkandgrab(){
		if( beeperAbove() ){
			turnLeft(); move(); pickBeeper();
			turnAround(); move(); turnLeft();
			advance();
		}
	}
	public void pullamario(){
		checkandgrab();
		} 
	public boolean wallonrightandnotbeeperinfront(){
		if ( !nextToABeeper() ){
			return true;}
		else{
			return false;
		}
		}
	public void gotoendofmaze(){
		while ( !nextToABeeper() ){
		
			if ( !frontIsClear() ){
				turnLeft();
				
			}
	}
	}
public class stupidmaze implements Directions { //class used to be beeperpick
	public static void main(String[] args) {
    	StandardBot Karel = new StandardBot (1, 1, East, 0);
    	Karel.pullamario();
    	Karel.turnOff();
	}
   	static {
        World.reset(); 
        World.readWorld("Z:\\Karel\\Worlds\\mariothing.kwld"); 
        World.setDelay(5);  
        World.setVisible(true);
    }
}
