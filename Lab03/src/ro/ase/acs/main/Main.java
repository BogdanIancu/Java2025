package ro.ase.acs.main;

import ro.ase.acs.classes.Car;
import ro.ase.acs.classes.Vehicle;
import ro.ase.acs.interfaces.Taxable;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[][] matrix = new int[3][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        float[][] raggedArray = new float[2][];
        raggedArray[0] = new float[1];
        raggedArray[1] = new float[3];
        for (int i = 0; i < raggedArray.length; i++) {
            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.print(raggedArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (float f : raggedArray[1]) {
            System.out.println(f);
        }

        Vehicle v = new Car();
        v.move();

        Car c = new Car("Dacia", 10000, "white");
        System.out.println(c.computeTax());
        Taxable t = c;
        System.out.println(t.computeTax());

        if (c instanceof Cloneable) {
            Car c2 = (Car) c.clone();
            System.out.println(c2.getColor());
        }
    }
}
