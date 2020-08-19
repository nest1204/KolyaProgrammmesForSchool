package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("How many intervals?");

        Scanner scanner = new Scanner(System.in);
        int intervalsAmount = scanner.nextInt();

        ArrayList<String> intervals = new ArrayList<>();

        for (int i = 0; i < intervalsAmount; i++) {

            Scanner scanner2 = new Scanner(System.in);
            String userInput = scanner2.nextLine();

            intervals.add(userInput);
        }

        int[] eachInterval = new int[0];

        ArrayList<Integer> allNumAppeared = new ArrayList<>();
        ArrayList<Integer> appearedNumCount = new ArrayList<>();
        ArrayList<Integer> differentIntervals = new ArrayList<>();
        int differentCount = 0;


        for (int i = 0; i < intervalsAmount; i++) {

            //move the following code into a different method

            String[] eachIntervalStrArr = intervals.get(i).split(" ");

            int size = eachIntervalStrArr.length;

            eachInterval = new int[size];
            for (int e = 0; e < size; e++) {
                eachInterval[e] = Integer.parseInt(eachIntervalStrArr[e]);
            }

            for (int e = 0; e <= (eachInterval[1] - eachInterval[0]); e++) {
                if (!allNumAppeared.contains(eachInterval[0] + e)) {
                    allNumAppeared.add(eachInterval[0] + e);
                    appearedNumCount.add(1);
                    differentIntervals.add(differentCount);
                }
                else if(allNumAppeared.contains(eachInterval[0] + e)) {
                    int index = allNumAppeared.indexOf(eachInterval[0] + e);
                    appearedNumCount.set(index, appearedNumCount.get(index) + 1);

                    differentIntervals.set(index, differentIntervals.get(index) + 2);

                }
            }

            int afterCurrentInterval = (allNumAppeared.size() - 1) - allNumAppeared.indexOf(eachInterval[1]);
            //System.out.println(afterCurrentInterval + "  " + appearedNumCount.size() + "  " + allNumAppeared.indexOf(eachInterval[1]));
            for (int y = 0; y < afterCurrentInterval; y++) {
                int tempIndex = allNumAppeared.indexOf(eachInterval[1]);
                int setNew = differentIntervals.get(tempIndex + y) + 1;
                differentIntervals.set(allNumAppeared.indexOf((eachInterval[1] + 1 + y)), setNew);
            }

            //differentCount++;
            differentCount = Collections.max(differentIntervals) + 1;

        }


        int maxNumber = Collections.max(appearedNumCount);
        ArrayList<Integer> appearedNumCOPY = new ArrayList<>(appearedNumCount);
        int endIntervalsLength = 0;
        int endIntervalsAmount = 0;

        ArrayList<Integer> appearedNumCOPY2 = new ArrayList<>(appearedNumCount);
        int num2 = -1;
        while(appearedNumCOPY2.contains(maxNumber)) {
            int index = appearedNumCOPY2.indexOf(maxNumber);

            int num1 = differentIntervals.get(index);
            if (num1 != num2) {
                endIntervalsAmount++;
            }
            num2 = differentIntervals.get(index);
            appearedNumCOPY2.set(appearedNumCOPY2.indexOf(maxNumber), -1);


        }

        while(appearedNumCOPY.contains(maxNumber)) {
            endIntervalsLength++;
            appearedNumCOPY.set(appearedNumCOPY.indexOf(maxNumber), -1);
        }


        System.out.println(endIntervalsAmount + " " + endIntervalsLength);

    }
}


