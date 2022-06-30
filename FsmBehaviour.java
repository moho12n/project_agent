
package testjade;

import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class FsmBehaviour extends DefaultAgent {
    
    private static ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
    private static ACLMessage inform = new ACLMessage(ACLMessage.INFORM);
    private static ACLMessage confirm = new ACLMessage(ACLMessage.CONFIRM);
    
    @Override
    protected void setup() {
        super.setup();
        
       FSMBehaviour behaviour= new FSMBehaviour(this); 
addBehaviour(behaviour);
behaviour.registerFirstState(new OneShotBehaviour() { 
    int current;
	public void action(){
        	current=(int)(Math.random()*2);
  		System.out.println("Etat X :  transition : "+ current); }
	public int onEnd(){
       		 return current;   }
},"X");
 behaviour.registerLastState(new OneShotBehaviour() { 
	public void action(){
  		System.out.println("Etat Y : dernier comportement");     }    
  	  },"Y");
behaviour.registerState(new OneShotBehaviour(){ 
	public void action(){
		 System.out.println("Etat Z :  comportement intermédiaire");     }    
 	  },"Z");
behaviour.registerTransition("X","Y",1);
behaviour.registerTransition("X","Z",0);
behaviour .registerDefaultTransition("Z","X",new String[]{"X","Z"});             }

    
}
