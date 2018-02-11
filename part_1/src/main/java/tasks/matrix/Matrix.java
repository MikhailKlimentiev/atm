package tasks.matrix;

import java.util.Scanner;

/**
 * Matrix.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 02/11/2018
 */
public class Matrix {

	private int[][] matrixArray;

	/**
	 * Matrix.
	 * The method is a constructor
	 */
	public Matrix() {

	}

	/**
	 * setMatrixArray.
	 * The method setMatrixArray(int[][] matrix) initializes the variable int[][] matrixArray
	 * @param matrix
	 */
	public void setMatrixArray(int[][] matrix){
		this.matrixArray = matrix;
	}

	/**
	 * getMatrixArray.
	 * The method getMatrixArray returns the variable int[][] matrixArray
	 * @return int[][] matrixArray
	 */
	public int[][] getMatrixArray(){
		return this.matrixArray;
	}

	/**
	 * getSizeOfSquareMatrix.
	 * The method gets the size of the square matrix from console and returns the matrix's size
	 * @param scan
	 * @return int matrixSize
	 */
	public int getSizeOfSquareMatrix(Scanner scan) {
		System.out.print("Enter the size of the square matrix: ");
		int matrixSize = scan.nextInt();
		return matrixSize;
	}

	/**
	 * getMmatrixElements.
	 * The method gets the elements of the square matrix from console
	 * @param matrix
	 * @param scan
	 */
	public void getMmatrixElements(int[][] matrix, Scanner scan) {
		System.out.println("Please input the elements of the matrix.");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("Please input [" + i + "][" + j + "]-th element of the matrix: ");
				matrix[i][j] = scan.nextInt();
			}
		}
	}

	/**
	 * showMatrix.
	 * The method outputs the elements of the square matrix into console
	 * @param matrix
	 */
	public void showMatrix(int[][] matrix) {
		System.out.println("Matrix: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * rotateMatrix.
	 * The method rotates the matrix on 90 degrees clockwise and returns turned matrix
	 * @param matrix
	 * @return int[][] matrix
	 */
	public int[][] rotateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - j - 1][i];
				matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
				matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
				matrix[j][matrix.length - i - 1] = tmp;
			}
		}
		System.out.println();
		System.out.println("The matrix have been rotated on 90 degrees clockwise.");
		return matrix;
	}


}
