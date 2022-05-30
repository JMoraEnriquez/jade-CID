package examples.KNN;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.KNN.KnnFormula;
import examples.KNN.dataSet;

public class KNN extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    addBehaviour(new KNNBehaviour());
  }

  private class KNNBehaviour extends Behaviour {

    boolean condition = false;

    public void action() {
      System.out.println("Agent's action method is executed");

      dataSet dataSet = new dataSet();
      KnnFormula knn = new KnnFormula();

      double[][] arrayX = dataSet.getX();
      double[][] arrayY = dataSet.getY();
      String[][] arrayZ = dataSet.getZ();

      double distances[] = new double[arrayX.length];
      String categories[] = new String[distances.length];

      for (int i = 0; i < arrayX.length; i++) {
        distances[i] = knn.calculateDistance(arrayX[i][0], arrayY[i][0], 5.5, 2.4);
        categories[i] = arrayZ[i][0];
      }

      for (int x = 0; x < distances.length; x++) {
        for (int y = 0; y < distances.length - 1; y++) {
          double elementoActual = distances[y],
              elementoSiguiente = distances[y + 1];

          String elementoActualS = categories[y],
              elementoSiguienteS = categories[y + 1];

          if (elementoActual > elementoSiguiente) {
            // Intercambiar
            distances[y] = elementoSiguiente;
            distances[y + 1] = elementoActual;
            categories[y] = elementoSiguienteS;
            categories[y + 1] = elementoActualS;
          }
        }
      }      

      System.out.println("Specie: | Distance: | Rank: \n");
      for (int i = 0; i < distances.length; i++) {
        System.out.println(categories[i] + "  " + distances[i] + "  " + i);
      }

      System.out.println("\n" + knn.nearestNeighbor(categories));

      condition = true;
    }

    public boolean done() {
      if (condition)
        return true;
      else
        return false;
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class ...Behaviour
}
