package testjade;

/**
 *
 * @author BYOD269967
 */

import jade.core.behaviours.*;

public class Agent3 extends DefaultAgent{

private int count_agent=0;
private int count_action=0;

@Override
protected void setup(){
super.setup();

this.addBehaviour(new OneShotBehaviour(this){
    @Override
    public void onStart() {
        System.out.println("Comportment " + this.toString());
        System.out.println("onStart :: " + getAID().getName());
        super.onStart(); }
    
    @Override
    public void action() {
    System.out.println("Comportment "+this.toString());
    System.out.println("one shot action :: agent_count"+count_agent);
     count_agent = count_agent+1;   
    }
    
});

this.addBehaviour(new CyclicBehaviour(this){
    @Override
    public void onStart() {
       System.out.println("Comportment "+this.toString());
       System.out.println("Action of agent "+getAID().getName());
       super.onStart(); 
    }
    
    @Override
    public void action() {
       count_action = count_action + 1 ;
       System.out.println("action count "+count_action);
       System.out.println("action agent "+count_agent);
       if(count_action==3){
           System.out.println("before doDelete");
           doDelete();
       }
    }
    
});

}

}