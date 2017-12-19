package library.solver;

import javafx.geometry.Point2D;
import library.function.RunnableDoubleFunction;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EqualTwoDoubleFunction implements SolverForTwoFunctions {

    private double equalityOfSign(double first, double second, double currentMin) {
        double curMin = first - second;
        System.out.println("calc: " + curMin);
        if (curMin < currentMin) {
            return curMin;
        }
        return currentMin;
    }

    private double minX;

    private double dichotomySolve(RunnableDoubleFunction firstFunction, RunnableDoubleFunction secondFunction, double from, double to, double accuracy, double min) {
        double center = (from + to) / 2;
        while (Math.abs(from - to) > accuracy) {
            double newMin = equalityOfSign(firstFunction.functionRun(center), secondFunction.functionRun(center), min);
            if (newMin < min) {
                minX = center;
                min = newMin;
                to = center;
            } else {
                from = center;
            }
            center = (from + to) / 2;
        }
        return min;
    }

    @Override
    public List<Point2D> solve(RunnableDoubleFunction firstFunction, RunnableDoubleFunction secondFunction, Double from, Double to, Double searchStep, Double accuracy) {
        List<Point2D> resultList = new LinkedList<>();

        Double firstFunctionY = firstFunction.functionRun(from);
        Double secondFunctionY = secondFunction.functionRun(from);
        Double argFirstFunctionY, argSecondFunctionY;

        double root;
        double currentMin = firstFunction.functionRun(from) - secondFunction.functionRun(from);

         minX = from;
        for (double x = from + searchStep; x <= to; x += searchStep) {
            System.out.println("x: " + x);
            System.out.println("currentMin: " + currentMin);
            argFirstFunctionY = firstFunction.functionRun(x);
            argSecondFunctionY = secondFunction.functionRun(x);

            double newMin = equalityOfSign(argFirstFunctionY, argSecondFunctionY, currentMin);
            System.out.println("new : " + newMin);
            if (newMin < currentMin) {
                System.out.println("new !: " + newMin);
                newMin = currentMin;
                currentMin = dichotomySolve(firstFunction, secondFunction, x - searchStep, x, accuracy, newMin);
                minX = x;
//                resultList.add(new Point2D(root, firstFunction.functionRun(root)));
            }


            firstFunctionY = argFirstFunctionY;
            secondFunctionY = argSecondFunctionY;
        }

        return Collections.singletonList(new Point2D(minX, currentMin));
    }
}
