package codingtest.hypc;

import java.util.LinkedHashMap;
import java.util.function.Function;

public class Ship {
    private LinkedHashMap<Integer, Integer> containers;
    private Function<Integer, Integer> fillContainer;
    private final static int maxSize = 4;

    public Ship(int containerCount, Function<Integer, Integer> fillContainer) {
        this.containers = new LinkedHashMap<>();
        this.fillContainer = fillContainer;
    }

    public int peekContainer(int containerIndex) {
        int content;
        if (!this.containers.containsKey(containerIndex)) {
            if (this.containers.size() >= maxSize) {
                // Make room by removing an entry
                int key = this.containers.entrySet().iterator().next().getKey();
                this.containers.remove(key);
            }
            content = this.fillContainer.apply(containerIndex);
        } else {
            // Remove entry so to put it at end of LinkedHashMap
            content = this.containers.get(containerIndex);
            this.containers.remove(containerIndex);
        }
        this.containers.put(containerIndex, content);
        return content;
    }

    public static void main(String[] args) {
        Ship ship = new Ship(10, containerIndex -> containerIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }
}
