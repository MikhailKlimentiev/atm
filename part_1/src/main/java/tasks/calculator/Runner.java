//=================================================================================================================
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                           ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 1                                ////
////                                                                                                           ////
////    Задания к выполнению:                                                                                  ////
////                                                                                                           ////
////    1. Написать простейший калькулятор – консольное приложение(реализовать как минимум 4 операции:         ////
////    сложение, вычитание, умножение, деление) с вводом\выводом значений\результатов;                        ////
////                                                                                                           ////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=================================================================================================================

package tasks.calculator;

import java.util.Scanner;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 04/22/2018
 */

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OperationSwitcher operationSwithcer = new OperationSwitcher();
        boolean condition = true;
        double result;
        while (condition) {
            result = operationSwithcer.switchOperation(scan, condition);
            System.out.println("Result is: " + result);
        }
    }
}
