/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testjade;

import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author BYOD269967
 */
public class ParallelPrintBehaviourAgent extends DefaultAgent {
    
    private static ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
    private static ACLMessage inform = new ACLMessage(ACLMessage.INFORM);
    private static ACLMessage confirm = new ACLMessage(ACLMessage.CONFIRM);
    
    @Override
    protected void setup() {
        super.setup();
        
        ParallelBehaviour myCompositeBehaviour = new ParallelBehaviour(this, ParallelBehaviour.WHEN_ALL){   // Classe anonyme pour spécifier le onEnd().
            
            @Override
            public int onEnd(){
                System.out.println("onEnd : terminaison de "+this.toString());
                System.out.println("onEnd : terminaison de l'agent");
                myAgent.doDelete();
                return super.onEnd();
            }
        }; 
        addBehaviour(myCompositeBehaviour);
        
        /* ----------------------- OneShotBehaviour ----------------------- */
        myCompositeBehaviour.addSubBehaviour(new OneShotBehaviour(this){
            
            @Override
            public void onStart(){
                super.onStart();
                
                System.out.println("Comportement à un coup associé à un message request "+this.toString());
                
                request.setContent("Tu veux voir le dernier film de Sofia Coppola : BLING RING ?");
            }
            
            @Override
            public void action() {
                System.out.println("action: request de l'agent "+myAgent.getAID().getName());
                System.out.println(request);
            }
            
            @Override
            public int onEnd(){
                System.out.println("onEnd : terminaison de "+this.toString());
                return super.onEnd();
            }
        });
        
        /* ----------------------- SimpleBehaviour ----------------------- */
        myCompositeBehaviour.addSubBehaviour(new SimpleBehaviour(this){
            
            private int count=0;
            
            @Override
            public void onStart(){
                super.onStart();
                
                System.out.println("Comportement simple associé à un message inform "+this.toString());
                
                inform.setContent("BLING RING : des jeunes qui rêvent de devenir riche et célèbre et qui se font arrêter à force de cambrioler les maisons des stars.");
            }
            
            @Override
            public void action() {
                setCount(getCount()+1);
                System.out.println("envoi numéro "+getCount());
                System.out.println(inform);
            }

            @Override
            public boolean done() {
                return getCount()==2;
            }
            
            @Override
            public int onEnd(){
                System.out.println("onEnd : terminaison de "+this.toString());
                return super.onEnd();
            }
            
            private int getCount() {
                return count;
            }
            
            private void setCount(int count) {
                this.count = count;
            }
            
        });
        
        /* ----------------------- OneShotBehaviour ----------------------- */
        myCompositeBehaviour.addSubBehaviour(new OneShotBehaviour(this){
                        
            @Override
            public void onStart(){
                super.onStart();
                
                System.out.println("comportement imprimant une confirmation "+this.toString());
                
                confirm.setContent("A ce soir 20h");
            }
            
            @Override
            public void action() {
                System.out.println("action: confirm de l'agent "+myAgent.getAID().getName());
                System.out.println(confirm);
            }
            
            @Override
            public int onEnd(){
                System.out.println("onEnd : terminaison de "+this.toString());
                return super.onEnd();
            }
            
        });

    }
}
