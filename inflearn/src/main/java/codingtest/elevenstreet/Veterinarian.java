package codingtest.elevenstreet;

import java.util.LinkedList;
import java.util.Queue;

public class Veterinarian {
    private Queue<String> queue = new LinkedList<>();

    public void accept(String petName) {
        queue.add(petName);
    }

    public String heal() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}
