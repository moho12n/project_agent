/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testjade;
import jade.core.Agent;
public class DefaultAgent extends Agent{
protected void setup(){
//initialisation de l’agent
System.out.println("Agent "+getAID().getName()+" ready");
}

protected void takeDown(){
//traitement de fin
System.out.println("Agent " +getAID().getLocalName()+" done");
}
}//fin de DefaultAgent 

