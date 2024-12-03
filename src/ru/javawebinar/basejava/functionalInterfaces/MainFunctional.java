package ru.javawebinar.basejava.functionalInterfaces;

public class MainFunctional {
    public static void main(String[] args) {
        // SimpleGen sg = new SimpleGen(5);
        // Generator gen1 = sg::getNumber;
        // int temp = gen1.getNextElement();
        // System.out.println(temp);

        // Generator gen2 = SimpleGen::getRandomNumber;
        // int temp2 = gen2.getNextElement();
        // System.out.println(temp2);

        // Generator gen3 = IntGenerator::next;
        // IntGenerator intGen = new IntGenerator();
        // System.out.println(gen3.getNextElement(intGen));

        // Generator gen5 = int[]::new;
        // Object a = gen5.createNewObject(10);
        // System.out.println(a.getClass());

        // NumberGenerator ng = new NumberGenerator();
        // Modifier<Integer> a = ng::add;
        // Modifier<String> b = ng::add;

        // System.out.println(a);
        // System.out.println(b);

        Gen gen6 = new Gen();
        IntElementGenerator ieg = gen6::nextElement;
    }
}
