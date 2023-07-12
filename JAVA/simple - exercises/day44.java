public class day44 {

    public static void main(String[] args) {

        System.out.println(NextEdge(8, 10));
        System.out.println(NextEdge(5, 7));
        System.out.println(NextEdge(9, 2));
    }

    public static int NextEdge (int side1, int side2) {
        return (side1 + side2) - 1;
    }
}
