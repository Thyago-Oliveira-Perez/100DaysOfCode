public class day43 {

    public static void main(String[] args) {
        System.out.println(TriArea(3, 2));
        System.out.println(TriArea(5, 3));
        System.out.println(TriArea(5, 4));
        System.out.println(TriArea(7, 4));
        System.out.println(TriArea(10, 10));
        System.out.println(TriArea(12, 11));
        System.out.println(TriArea(0, 60));
    }

    public static double TriArea (double base, double height) {
        return (base * height) / 2;
    }
}
