package EXAM.AllFourth;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChampionsLeague130316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String club1 = "";
        String club2 = "";
        TreeMap<String, Integer> tm1 = new TreeMap<>();
        TreeMap<String, ArrayList<String>> tm2 = new TreeMap<>();

        while (!s.equals("stop")) {


            Pattern pat = Pattern.compile("([A-Za-z]+\\s*[A-Za-z]+)\\s*\\|\\s*([A-Za-z]+\\s*[A-Za-z]+)\\s*\\|\\s*(\\d):(\\d)\\s*\\|\\s*(\\d+):(\\d+)");
            Matcher matcher = pat.matcher(s);

            while (matcher.find()) {

                club1 = matcher.group(1);
                club2 = matcher.group(2);

                int scoreFirst = Integer.parseInt(matcher.group(3));
                int scoreSecond = Integer.parseInt(matcher.group(4));

                scoreSecond += Integer.parseInt(matcher.group(5));
                scoreFirst += Integer.parseInt(matcher.group(6));

                int wins1 = 0;
                int wins2 = 0;

                if (scoreFirst > scoreSecond) {
                    wins1 = 1;
                }
                if (scoreFirst < scoreSecond) {
                    wins2 = 1;
                }
                if (scoreFirst == scoreSecond) {
                    if ((Integer.parseInt(matcher.group(5)) + Integer.parseInt(matcher.group(6))
                            > Integer.parseInt(matcher.group(3)) + Integer.parseInt(matcher.group(4)))) {
                        wins1 = 1;
                    } else {
                        wins2 = 1;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        if (!tm1.containsKey(club1)) {
                            tm2.put(club1, new ArrayList<>());
                            tm1.put(club1, 0);

                        }
                        int n = tm1.get(club1) + wins1;
                        tm1.put(club1, n);
                        tm2.get(club1).add(club2);
                    }
                    if (i == 1) {
                        if (!tm1.containsKey(club2)) {
                            tm2.put(club2, new ArrayList<>());
                            tm1.put(club2, 0);

                        }
                        int n = tm1.get(club2) + wins2;
                        tm1.put(club2, n);
                        tm2.get(club2).add(club1);
                    }
                }
                s = scanner.nextLine();
            }
        }
        ArrayList<String> elements = new ArrayList<>();

        tm1.entrySet()
                .stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k1 -> elements.add(k1.getKey() + "\n" + "- Wins: " + k1.getValue() + "\n"));


        for (String element : elements) {
            for (String s1 : tm2.keySet()) {
                if (element.contains(s1)) {
                    String sss = "";
                    ArrayList<String> list = tm2.get(s1);
                    Collections.sort(list);
                    sss = String.join(", ", list);
                    System.out.println(element + "- Opponents: " + sss);

                }
            }
        }

    }
}


//                for (int i = 0; i < 2; i++) {
//                    if (i == 0) {
//                        if (!outTM.containsKey(club1)) {
//                            outTM.put(club1, new TreeMap<>());
//                            outTM.get(club1).put(wins1, new ArrayList<>());
//                            outTM.get(club1).get(wins1).add(club2);
//                        } else if (outTM.containsKey(club1)) {
//                            TreeMap<Integer, ArrayList<String>> tm = outTM.get(club1);
//                            ArrayList<String> ls = new ArrayList<>();
//                            int num = 0;
//                            for (Integer n : tm.keySet()) {
//                                num = n;
//                            }
//                            outTM.get(club1).get(num).add(club2);
//                            ls = outTM.get(club1).get(num);
//
//                            tm.remove(num);
//                            num += wins1;
//                            tm.put(num, ls);
//                            outTM.remove(club1);
//                            outTM.put(club1, tm);
//
//                        }
//                    }
//                    if (i == 1) {
//                        if (!outTM.containsKey(club2)) {
//                            outTM.put(club2, new TreeMap<>());
//                            outTM.get(club2).put(wins1, new ArrayList<>());
//                            outTM.get(club2).get(wins1).add(club1);
//                        } else if (outTM.containsKey(club2)) {
//                            TreeMap<Integer, ArrayList<String>> tm = outTM.get(club2);
//                            ArrayList<String> ls = new ArrayList<>();
//                            int num = 0;
//                            for (Integer n : tm.keySet()) {
//                                num = n;
//                            }
//                            outTM.get(club2).get(num).add(club1);
//                            ls = outTM.get(club2).get(num);
//
//                            tm.remove(num);
//                            num += wins1;
//                            tm.put(num, ls);
//                            outTM.remove(club2);
//                            outTM.put(club2, tm);
//
//                        }
//                    }
//                }
//                s = scanner.nextLine();
//            }
//        }
//        outTM.entrySet()
//                .stream()
//                .sorted((k1, k2) -> k2.getValue().values().compareTo(k1.getValue().values()))
//                .forEach(k1 -> System.out.println(k1.getKey()+": "+ k1.getValue()));
//        for (String ss : outTM.keySet()) {
//            System.out.println(ss);
//            TreeMap<Integer, ArrayList<String>> tm = outTM.get(ss);
//
//            for (Integer s1 : tm.keySet()) {
//                List<String> ts = tm.get(s1);
//                Collections.sort(ts);
//
//                System.out.println("- Wins: " + s1);
//                String res = String.join(", ", ts);
//                System.out.print("- Opponents: ");
//                System.out.print(res);
//            }
//            System.out.println();
//        }
//    }
//}
















