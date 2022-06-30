package testjade;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

/**
 *
 * @authorDouzane
 */
public class jadeTest extends Agent{
    protected void setup(){
//initialisation de l’agent
System.out.println("Agent "+getAID().getName()+" ready");
this.addBehaviour(new GenericBehaviour1(this));

}

protected void takeDown(){
//traitement de fin
System.out.println("Agent " +getAID().getLocalName()+" done");
}

class GenericBehaviour1 extends Behaviour{
    private int counter = 0;
GenericBehaviour1(Agent behaviour){
        super(behaviour);    }
    @Override
 public void action(){
     counter++;
     System.out.println(" action count "+counter);  }
 @Override
 public boolean done(){
     System.out.println(" done "+getAgent().getAID().getName() );
     if(counter>2)
         doDelete();
return counter==3;    }
 }//end of behaviour
}//end of class


