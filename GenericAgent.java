package testjade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends jadeTest{
private int count=2;   

protected void setup(){
super.setup();
setCount();
// ajout du comportement
this.addBehaviour(new GenericBehaviour(this));
}
private void setCount(){
Object[] args = getArguments();
if (args!=null && args.length>0){
	setCount( args[0]);}
else { System.out.println(" no service specified for Agent "+getAID().getName());}

}

    /**
     * @return the count
     */
    private int getCount() {
        return count;
    }
private void setCount(Object obj){
    String value= ((String) obj);
    setCount(Integer.parseInt(value));
}
    /**
     * @param count the count to set
     */
    private void setCount(int count) {
        this.count = count;
    }

/**
 *
 * @author FSU
 */
class GenericBehaviour extends Behaviour{
     private int time=0;
     
     
     
     public void onStart(Agent a ){
         super.onStart();
         
     }
    GenericBehaviour(Agent a){
        super(a);  }
 public void action(){
setTime(getTime()+1);
     System.out.println(" action of Agent "+myAgent.getAID().getName());
     System.out.println(" action count "+ time);
     if ( isEnded()){
         System.out.println(" before doDelete ");
         myAgent.doDelete();   } 
 }
 
 public boolean done(){
     System.out.println(" done "+myAgent.getAID().getName());
     System.out.println(" done count "+getTime());
     return isDone();   }
private boolean isEnded(){
    return getTime()==getCount();
}

private boolean isDone(){
    return getTime()==(getCount());
}
        /**
         * @return the time
         */
        private int getTime() {
            return time;
        }

        /**
         * @param time the time to set
         */
        private void setTime(int time) {
            this.time = time;
        }
 }//end GenericBehaviour
}//end class Generic Agent
