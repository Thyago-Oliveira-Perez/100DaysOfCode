import java.util.*;
import java.util.stream.Collectors;

public class day51 {

    public static void main(String[] args) {
        System.out.println(CollisionResult(new int[]{5,10,-5}));
        System.out.println(CollisionResult(new int[]{8,-8}));
        System.out.println(CollisionResult(new int[]{10,2,-5}));
        System.out.println(CollisionResult(new int[]{-2,-1,1,2}));
        System.out.println(CollisionResult(new int[]{-2}));
        System.out.println(CollisionResult(new int[]{-2,-1000,1, 2}));
    }

    public static List<Integer> CollisionResult (int[] asteroids) {

        LinkedList<Integer> s = new LinkedList<>();

        if (asteroids.length <= 1) {
            System.out.print("Error: Few asteroids.");
            return null;
        }

        for (int i : asteroids) {
            if (i >= 1000 || i <= -1000 ) {
                System.out.print("Error: Asteroid is too big.");
                return null;
            } else if (i > 0) {
                s.add(i);
            } else {
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i) {
                    s.pollLast();
                }
                if (!s.isEmpty() && s.getLast() == -i) {
                    s.pollLast();
                }
                else if (s.isEmpty() || s.getLast() < 0) {
                    s.add(i);
                }
            }
        }

        return Arrays.stream(s.stream().mapToInt(i->i).toArray()).boxed().collect(Collectors.toList());
    }
}
