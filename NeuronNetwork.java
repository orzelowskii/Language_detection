//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class NeuronNetwork {
    String folderPath;
    ArrayList<Perceptron> perceptrons = new ArrayList(3);
    int numOfLetters;

    public NeuronNetwork(String folderPath) {
        this.folderPath = folderPath;
    }

    public void train() {
        this.perceptrons.add(new Perceptron("PL"));
        this.perceptrons.add(new Perceptron("EN"));
        this.perceptrons.add(new Perceptron("ES"));
        File folder = new File(this.folderPath);

        for(boolean isNotTrained = true; isNotTrained; isNotTrained = this.checking(folder)) {
            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();

                for(File file : files) {
                    this.numOfLetters = 0;
                    ArrayList<Integer> letters = new ArrayList(26);

                    for(int i = 0; i < 26; ++i) {
                        letters.add(0);
                    }

                    try {
                        BufferedReader bf = new BufferedReader(new FileReader(file));

                        String line;
                        while((line = bf.readLine()) != null) {
                            line = removeNonEnglishAndToLower(line);
                            this.countLetters(line, letters);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    for(Perceptron perceptron : this.perceptrons) {
                        double result = (double)0.0F;

                        for(int i = 0; i < 26; ++i) {
                            result += (double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F * (Double)perceptron.getWeights().get(i);
                        }

                        String name;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader(file))) {
                            String line = bf2.readLine();
                            name = line.substring(0, 2);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        if (result >= perceptron.getThreshold() && !perceptron.getNameOfLangue().equals(name)) {
                            for(int i = 0; i < 26; ++i) {
                                double oldWeight = (Double)perceptron.getWeights().get(i);
                                double newWeight = this.regulaDelta((double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F, oldWeight, 0, 1, perceptron.getLEARNING_CONSTANT());
                                perceptron.getWeights().set(i, newWeight);
                            }

                            double x = perceptron.getThreshold();
                            perceptron.setThreshold(x + perceptron.getLEARNING_CONSTANT() * (double)-1.0F);
                        } else if (result < perceptron.getThreshold() && perceptron.getNameOfLangue().equals(name)) {
                            for(int i = 0; i < 26; ++i) {
                                double oldWeight = (Double)perceptron.getWeights().get(i);
                                double newWeight = this.regulaDelta((double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F, oldWeight, 1, 0, perceptron.getLEARNING_CONSTANT());
                                perceptron.getWeights().set(i, newWeight);
                            }

                            double x = perceptron.getThreshold();
                            perceptron.setThreshold(x + perceptron.getLEARNING_CONSTANT());
                        }
                    }
                }
            }
        }

    }

    public void classify(String filePath) {
        this.numOfLetters = 0;
        ArrayList<Integer> letters = new ArrayList(26);

        for(int i = 0; i < 26; ++i) {
            letters.add(0);
        }

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = bf.readLine()) != null) {
                line = removeNonEnglishAndToLower(line);
                this.countLetters(line, letters);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double[] tab = new double[3];
        int x = 0;
        int index = 0;
        double max = (double)0.0F;

        for(Perceptron perceptron : this.perceptrons) {
            double result = (double)0.0F;

            for(int i = 0; i < 26; ++i) {
                result += (double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F * (Double)perceptron.getWeights().get(i);
            }

            if (result >= perceptron.getThreshold()) {
                tab[x] = result - perceptron.getThreshold();
            } else {
                tab[x] = (double)0.0F;
            }

            ++x;
        }

        for(int i = 0; i < tab.length; ++i) {
            if (tab[i] > max) {
                max = tab[i];
                index = i;
            }
        }

        PrintStream var10000 = System.out;
        Object var10001 = this.perceptrons.get(index);
        var10000.println("Tekst jest napisany w języku " + ((Perceptron)var10001).getNameOfLangue() + " !!!");
    }

    public void classifyText(String text) {
        this.numOfLetters = 0;
        ArrayList<Integer> letters = new ArrayList(26);

        for(int i = 0; i < 26; ++i) {
            letters.add(0);
        }

        text = removeNonEnglishAndToLower(text);
        this.countLetters(text, letters);
        double[] tab = new double[3];
        int x = 0;
        int index = 0;
        double max = (double)0.0F;

        for(Perceptron perceptron : this.perceptrons) {
            double result = (double)0.0F;

            for(int i = 0; i < 26; ++i) {
                result += (double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F * (Double)perceptron.getWeights().get(i);
            }

            if (result >= perceptron.getThreshold()) {
                tab[x] = result - perceptron.getThreshold();
            } else {
                tab[x] = (double)0.0F;
            }

            ++x;
        }

        for(int i = 0; i < tab.length; ++i) {
            if (tab[i] > max) {
                max = tab[i];
                index = i;
            }
        }

        PrintStream var10000 = System.out;
        Object var10001 = this.perceptrons.get(index);
        var10000.println("Tekst jest napisany w języku " + ((Perceptron)var10001).getNameOfLangue() + " !!!");
    }

    public boolean checking(File folder) {
        int x = 0;
        int numOfFiles = 0;
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            numOfFiles = files.length;

            for(File file : files) {
                ArrayList<Integer> letters = new ArrayList(26);

                for(int i = 0; i < 26; ++i) {
                    letters.add(0);
                }

                try {
                    BufferedReader bf = new BufferedReader(new FileReader(file));

                    String line;
                    while((line = bf.readLine()) != null) {
                        line = removeNonEnglishAndToLower(line);
                        this.countLetters(line, letters);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                int xx = 0;

                for(Perceptron perceptron : this.perceptrons) {
                    double result = (double)0.0F;

                    for(int i = 0; i < 26; ++i) {
                        result += (double)(Integer)letters.get(i) / (double)this.numOfLetters * (double)100.0F * (Double)perceptron.getWeights().get(i);
                    }

                    String name;
                    try {
                        BufferedReader bf2 = new BufferedReader(new FileReader(file));
                        String line = bf2.readLine();
                        name = line.substring(0, 2);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    if (result >= perceptron.getThreshold() && perceptron.getNameOfLangue().equals(name)) {
                        ++xx;
                    }
                }

                if (xx == 1) {
                    ++x;
                }
            }
        }

        return x < 17;
    }

    public double regulaDelta(double x, double weight, int expectedDecision, int decision, double LEARNING_CONSTANT) {
        weight += (double)(expectedDecision - decision) * LEARNING_CONSTANT * x;
        return weight;
    }

    public static String removeNonEnglishAndToLower(String input) {
        StringBuilder resultBuilder = new StringBuilder();

        for(char ch : input.toCharArray()) {
            if (Character.isLetter(ch) && (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                resultBuilder.append(Character.toLowerCase(ch));
            }
        }

        return resultBuilder.toString();
    }

    public void countLetters(String input, ArrayList<Integer> letters) {
        for(char ch : input.toCharArray()) {
            if (Character.isLetter(ch) && ch >= 'a' && ch <= 'z') {
                int index = ch - 97;
                int count = (Integer)letters.get(index);
                letters.set(index, count + 1);
                ++this.numOfLetters;
            }
        }

    }
}
