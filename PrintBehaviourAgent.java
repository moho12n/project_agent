package testjade;
import jade.core.behaviours.*;

/**
 *
 * @author BYOD269967
 */

public class PrintBehaviourAgent  extends DefaultAgent{
private static final int timeout=1000;

protected void setup(){

int nbSec = 5;
super.setup();

//--- one Shot
this.addBehaviour(new OneShotBehaviour(this){
    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Comportement à un coup associé à un message request "+this.toString());         
    }
    
    @Override
    public void action() {
    System.out.println("action: request de l'agent "+getAID().getName());
    System.out.println("Tu veux voir le dernier film de Sofia Coppola : BLING RING");
    }  

    @Override
    public int onEnd() {
        System.out.println("onEnd du comportement à un coup");
        return super.onEnd(); 
    }
    
});

//--- Ticker 
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

//--- waker
this.addBehaviour(new WakerBehaviour(this,timeout*nbSec){
    @Override
    public void onStart() {
       super.onStart();
       System.out.println("Comportement imprimant une confirmation au bout de 5 secondes " + this.toString());
           }

    @Override
    protected void onWake() {
        System.out.println("onWake :A ce soir 20h");
    }

    @Override
    public int onEnd() {
        System.out.println("onEnd :terminaison de l'agent");
        doDelete();
        return super.onEnd(); 
    }
});
}     
}

