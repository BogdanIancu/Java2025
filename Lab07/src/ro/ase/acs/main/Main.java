package ro.ase.acs.main;

import ro.ase.acs.classes.Sum;
import ro.ase.acs.interfaces.BinaryOperation;
import ro.ase.acs.interfaces.Displayable;
import ro.ase.acs.interfaces.Printable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BinaryOperation operation = new Sum();
        double result = operation.compute(5, 6);
        System.out.println(result);

        operation = new BinaryOperation() {
            @Override
            public double compute(double x, double y) {
                return x * y;
            }
        };

        result = operation.compute(7, 9);
        System.out.println(result);

        new Sum().compute(4, 9);

        operation = (x, y) -> x - y;

        result = operation.compute(5, 7);
        System.out.println(result);

        operation = (a, b) -> {
            double sum = a + b;
            return sum / 2;
        };

        Displayable d = () -> System.out.println("Hello world");
        d.display();

        Printable p = a -> System.out.println(a);
        p.print("Hello");

        List<Integer> list = List.of(5, 2, 4, 6, 5, 7, 9);
        long number = list.stream().filter(x -> x >= 5).count();
        System.out.println(number);

        List<Integer> list2 = list.stream().
                distinct().sorted().
                collect(Collectors.toList());
        System.out.println(list2);

        List<String> strings = List.of("John", "Mary", "George", "James");
        String s = strings.stream().map(String::toUpperCase).
                reduce((x, y) -> x + ' ' + y).get();
        System.out.println(s);

        strings.forEach(System.out::println);
    }

}
