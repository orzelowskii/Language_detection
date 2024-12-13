//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Random;

public class Perceptron {
    String nameOfLangue;
    ArrayList<Integer> letters = new ArrayList(26);
    ArrayList<Double> weights = new ArrayList(26);
    final double LEARNING_CONSTANT = (double)0.5F;
    double threshold;
    int numOfLetters;

    public Perceptron(String nameOfLangue) {
        this.nameOfLangue = nameOfLangue;
        this.threshold = 0.9;
        Random random = new Random();

        for(int i = 0; i < 26; ++i) {
            this.weights.add(random.nextDouble((double)11.0F) - (double)5.0F);
        }

    }

    public ArrayList<Double> getWeights() {
        return this.weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }

    public int getNumOfLetters() {
        return this.numOfLetters;
    }

    public void setNumOfLetters(int numOfLetters) {
        this.numOfLetters = numOfLetters;
    }

    public double getThreshold() {
        return this.threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public String getNameOfLangue() {
        return this.nameOfLangue;
    }

    public double getLEARNING_CONSTANT() {
        return (double)0.5F;
    }
}
