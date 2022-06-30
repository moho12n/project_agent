package testjade;
import jade.core.behaviours.*;


public class PlannedAgent extends DefaultAgent{
private static final int timeout=1000;
  protected void setup() {
	super.setup();
	addBehaviour( new TickerBehaviour(this,timeout) {            
            public void onStart() {    
                super.onStart();                
                System.out.println("TickerBehaviour::onStart - behaviour name : " + this.getBehaviourName());                
            }
        protected void onTick() {
                System.out.println("onTick getTickCount() " + getTickCount());
               //System.out.println("Il reste " + (secondNb -getTickCount())+" secondes");
//myAgent. pour appeler l'agent, ou getAgent()
            } 
        });
    }
}
