package ro.ase.acs.classes;

import ro.ase.acs.interfaces.BinaryOperation;

public class Sum implements BinaryOperation {

    @Override
    public double compute(double x, double y) {
        return x + y;
    }
}
