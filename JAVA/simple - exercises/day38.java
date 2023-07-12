public class day38 {

    public static void main(String[] args) {

        System.out.println(GetMoneySpent(new int[]{40,50,60,51}, new int[]{5,8,12}, 60));
    }

    public static int GetMoneySpent (int[] keyboardPrices, int[] drives, int budget) {

        int moreExpensiveOption = keyboardPrices[0] + drives[0];

        for (int keyboardPrice : keyboardPrices) {

            for (int drivePrice : drives) {

                int option = keyboardPrice + drivePrice;

                if (option <= budget) {
                    moreExpensiveOption = option;
                }
            }
        }

        return moreExpensiveOption;
    }
}
