//=================================================================================================================
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                           ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 1                                ////
////                                                                                                           ////
////    Task 2                                                                                                 ////
////                                                                                                           ////
////    Решить алгоритмическую задачу (варианты «загуглить» крайне не приветствуются).                         ////
////    Варианты ниже (вариант необходимо выбрать самостоятельно):                                             ////
////                                                                                                           ////
////    Turn a matrix on 90 degrees clockwise (Повернуть матрицу на 90 градусов по часовой стрелке)            ////
////                                                                                                           ////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=================================================================================================================

package tasks.matrix;

import tasks.matrix.Matrix;

import java.util.Scanner;

/**
 * RunnerMatrix.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 02/11/2018
 */
public class RunnerMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Matrix matrix = new Matrix();

        int size = matrix.getSizeOfSquareMatrix(scan);

        matrix.setMatrixArray(new int[size][size]);

        matrix.getMmatrixElements(matrix.getMatrixArray(), scan);

        matrix.showMatrix(matrix.getMatrixArray());

        matrix.showMatrix(matrix.rotateMatrix(matrix.getMatrixArray()));
    }
}
