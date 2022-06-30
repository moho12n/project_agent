
package testjade.sendmessage;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import testjade.DefaultAgent;
import static testjade.sendmessage.interfaceConstants.JACK;

/**
 *
 * @author BYOD269967
 */
public class SendMessageAgent extends DefaultAgent implements interfaceConstants{
private static final int timeout=1000;
private static ACLMessage request ; 
//private static ACLMessage inform ;= new ACLMessage(ACLMessage.INFORM);
//private static ACLMessage confirm ;= new ACLMessage(ACLMessage.CONFIRM);
    
protected void setup(){

super.setup();

//--- one Shot
this.addBehaviour(new OneShotBehaviour(this){


    @Override
    public void onStart() {

        super.onStart();
        System.out.println("Comportement à un coup "+this.toString());  
        request = new ACLMessage(ACLMessage.REQUEST);
        request.addReceiver(JACK);
        request.setContent("Tu veux voir le dernier film de Sofia Coppola : BLING RING");             
    }
    
    @Override
    public void action() {
     send(request);
     System.out.println("Message de demande "+request.toString()); 
    }  

    @Override
    public int onEnd() {
        System.out.println("onEnd du comportement à un coup");
        return super.onEnd(); 
    }
    
});

//--- Ticker 
/*
this.addBehaviour(new TickerBehaviour(this,timeout){
    @Override
    public void onStart() {
       super.onStart();
       System.out.println("Comportement périodique associé à un message inform "+ this.toString());
        }
    
    @Override
    protected void onTick() {
        System.out.println("envoi information toutes les secondes");
        System.out.println("BLING RING : des jeunes qui rêvent de devenir riche et célèbre et qui se font arrêter à force de cambrioler les maisons des stars");
        
        
    }
});
*/
}     
}
