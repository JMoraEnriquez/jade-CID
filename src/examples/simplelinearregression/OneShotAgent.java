package examples.simplelinearregresion;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import examples.simplelinearregresion.DataSet;
import examples.simplelinearregresion.SumHelper;
import examples.simplelinearregresion.SLR;

public class OneShotAgent extends Agent { 
  
  protected void setup() {
    System.out.println("Agent " + getLocalName() + " startewd.");
    addBehaviour(new MyOneShotBehaviour());
  }

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      System.out.println("Agent's action method executed");

      DataSet dataSet = new DataSet();
      SumHelper sumatorias = new SumHelper();
      SLR slr = new SLR();

      int[] x = dataSet.getX();
      int[] y = dataSet.getY();
      double sumatoriaX = sumatorias.sumatoriaX(x);
      double sumatoriaY = sumatorias.sumatoriaY(y);
      double sumatoriaXY = sumatorias.sumatoriaXY(x, y);
      double sumatoriaXX = sumatorias.sumatoriaXX(x);

      slr.calcularB1(sumatoriaX, sumatoriaY, sumatoriaXY, sumatoriaXX);
      slr.calcularB0(sumatoriaX, sumatoriaY);
      slr.displayar();
      slr.pronosticar(80);
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class ...Behaviour
}
