package examples.Gradient;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.Gradient.GradiantFunction;

public class Gradient extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new GradientBehaviour());
    }

    private class GradientBehaviour extends Behaviour {
        boolean condition = false;

        public void action() {
            GradiantFunction gradiant = new GradiantFunction();

            gradiant.isErrorOptime();
            gradiant.displayar();
            gradiant.pronosticar(80);
            

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

    }

}
