package examples.multiplelinearregression;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import examples.multiplelinearregression.DataSet;
import examples.multiplelinearregression.MLR;

public class OneShotAgent extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
        System.out.println("Agent's action method executed");

        DataSet dataSet = new DataSet();        
        MLR mlr = new MLR();

        double[][] x = dataSet.getX();
        double[][] y = dataSet.getY();

        mlr.calcularBetas(x, y);
        mlr.displayar();
        //mlr.pronosticar(82.4, 32.3);
        mlr.pronosticar(60);

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
