package EXAM.AllFourth;


import java.util.*;

public class CouplesFrequency260514 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        LinkedHashMap<String, Double> outTM = new LinkedHashMap<>();
        for (int i = 0; i < str.length - 1; i++) {
            String couple = str[i] + " " + str[i + 1];
            Double n = 1.;
            if (outTM.containsKey(couple)) {
                n = outTM.get(couple) + 1.;
            }
            outTM.put(couple,n);
        }
        for (Map.Entry<String, Double> entry : outTM.entrySet()) {
            double d = (entry.getValue() * 100 )/ (str.length - 1);
            System.out.printf("%s -> %.2f%%\n",entry.getKey(),d);
        }
    }
}

