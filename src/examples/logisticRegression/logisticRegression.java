package examples.logisticRegression;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.logisticRegression.logisticRegressionFormula;

public class logisticRegression extends Agent{
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new logisticRegressionBehaviour());
    }

    private class logisticRegressionBehaviour extends Behaviour {
        boolean condition = false;

        public void action() {  
            
            logisticRegressionFormula log = new logisticRegressionFormula();
            log.calculateprobability();
            
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
