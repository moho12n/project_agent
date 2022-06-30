
package testjade;
import jade.core.behaviours.*;
import jade.core.Agent;

public class MyGenericBehaviourAgent2 extends DefaultAgent{

  protected void setup() {
	super.setup();
	addBehaviour( new GenericBehaviour(this));
        addBehaviour(new TrivialBehaviour(this));
    }
  
private class GenericBehaviour extends Behaviour{
    private int count=0;

GenericBehaviour (Agent a) {
        super(a);
    }
 public void action(){
        System.out.println(" Comportement "+ this.toString());
        System.out.println(" action of Agent "+ getAID().getName() );
        System.out.println(" action count " + count);
       count++;}
 public boolean done() {
    
if(count == 3) { 
    System.out.println(" Agent "+getAID().getName() + " done");
        
    System.out.println(" before:: doDelete()");    
    myAgent.doDelete();
    return true; 
}
    else {
    System.out.println(" done: "+getAID().getName());    
    return false;}
}
}//end GenericBehaviour

private class TrivialBehaviour extends Behaviour{
    private int count=0;

TrivialBehaviour (Agent a) {
        super(a);
    }
 public void action(){
        System.out.println(" Comportement Trivial "+ this.toString());
        System.out.println(" action of Agent "+ getAgent().getAID().getName() );
        }
 public boolean done() {
System.out.println(" done: "+getAID().getName() );
  
return true;
}
}

}