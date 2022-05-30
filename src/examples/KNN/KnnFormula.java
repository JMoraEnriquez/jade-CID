package examples.KNN;

import java.util.*;

public class KnnFormula{
    int k = 1;
    int[] counters = {0,0,0};//counterSE=0, counterVi=0, counterVe=0;
    int pos=0;
    //a = x dataset
    //b = y datadet
    //x = x observado
    //y = y observado   
    double calculateDistance(double a,double b, double x, double y){
        double distance = Math.sqrt((Math.pow((x-a),2) + Math.pow((y-b), 2)));
        return distance;
    }

    public String nearestNeighbor(String[] categories){
        String higher;
        for(int i = 0; i < k; i++){
            switch(categories[i]){
                case "Setosa":counters[0]++;//Setosa    //counterSE++;
                break;

                case "Virginica":counters[1]++;//Virginica    //counterVi++;
                break;

                default:counters[2]++;//Verscicolor     //counterVe++;
                break;
            }                      
        }
        if(counters[0] == counters[1] | counters[0] == counters[2] | counters[1] == counters[2]){
            k++;
            counters[0] = 0;
            counters[1] = 0;
            counters[2] = 0;                
            nearestNeighbor(categories);
        }
        for(int x = 1; x < counters.length; x++){            
            if(counters[x] > counters[0]){
                counters[0] = counters[x];
                pos = x;                         
            }            
        }
        switch(pos){
            case 0: higher = "Setosa";
                break;
            case 1: higher = "Virginica";
                break;
            case 2: higher = "Verscicolor";
                break;
            default: higher = "error";
        }
        return higher;
    }
}