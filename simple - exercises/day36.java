public class day36 {

    public static void main(String[] args) {

        ToLCD(123456, 2);
        ToLCD(67890, 3);
    }

    public static void ToLCD (int num, int size) {

        final String horizontal = "-";
        final String vertical = "|";
        final String space = " ";
        char[] numbers = Integer.toString(num).toCharArray();

        for (int o = 0 ; o < ((size * 2) + 3) ; o++) {
            if (o == 0 || o == (size + 1) || o == (size * 2) + 2) {
                for (char number : numbers) {
                    if (number == '1') {
                        for (int i = 0; i < (size + 2); i++) {
                            System.out.print(space);
                        }
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '2') {
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '3') {
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '4') {
                        if (o == (size + 1)) {
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            System.out.print(space);
                            System.out.print(space);

                        } else {
                            for (int i = 0; i < size + 1; i++) {
                                System.out.print(space);
                            }
                            System.out.print(space);

                        }
                    } else if (number == '5') {
                        System.out.print(space);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '6') {
                        System.out.print(space);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '7') {
                        if (o == 0) {
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            System.out.print(space);
                        } else {
                            for (int i = 0; i < size + 1; i++) {
                                System.out.print(space);
                            }
                        }
                    } else if (number == '8') {
                        System.out.print(space);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '9') {
                        System.out.print(space);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        System.out.print(space);
                        System.out.print(space);
                    } else if (number == '0') {
                        if (o != (size + 1)) {
                            System.out.print(space);
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            System.out.print(space);
                            System.out.print(space);
                        }
                    }
                }
                System.out.print("\n");
            } else {
                for (char number : numbers) {
                    if (number == '1') {
                        for (int i = 0; i < ((size + 2) - 1); i++) {
                            System.out.print(space);
                        }
                        System.out.print(vertical);
                    } else if (number == '2') {
                        if (o < (size + 1)) {
                            for (int i = 0; i < (size + 2); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                        } else {
                            for (int i = 0; i < (size - 1); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                        }
                    } else if (number == '3') {
                        if (o < (size + 1)) {
                            for (int i = 0; i < (size + 2); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                            System.out.print(space);
                        } else {
                            for (int i = 0; i < (7); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                            System.out.print(space);
                        }
                    } else if (number == '4') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            for (int i = 0; i < (2); i++) {
                                System.out.print(space);
                            }
                        } else {
                            for (int i = 0; i < (3); i++) {
                                System.out.print(space);
                            }
                        }
                        System.out.print(vertical);
                        System.out.print(space);
                    } else if (number == '5') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            for (int i = 0; i < (size + 2); i++) {
                                System.out.print(space);
                            }
                        } else {
                            for (int i = 0; i < (size + 1); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                            System.out.print(space);
                        }
                    } else if (number == '6') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            for (int i = 0; i < (size); i++) {
                                System.out.print(space);
                            }
                        } else {
                            System.out.print(vertical);
                            for (int i = 0; i < (size); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                        }
                    } else if (number == '7') {
                        if (o < (size + 1)) {
                            for (int i = 0; i < (size + 2); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                        } else {
                            for (int i = 0; i < (size + 1); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                        }
                    } else if (number == '8') {
                        System.out.print(vertical);
                        for (int i = 0; i < (size); i++) {
                            System.out.print(space);
                        }
                        System.out.print(vertical);
                        System.out.print(space);
                    } else if (number == '9') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            for (int i = 0; i < (size); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                            System.out.print(space);
                        } else {
                            for (int i = 0; i < (size + 1); i++) {
                                System.out.print(space);
                            }
                            System.out.print(vertical);
                            System.out.print(space);
                        }
                    } else if (number == '0') {
                        System.out.print(vertical);
                        for (int i = 0; i < (size); i++) {
                            System.out.print(space);
                        }
                        System.out.print(vertical);
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
