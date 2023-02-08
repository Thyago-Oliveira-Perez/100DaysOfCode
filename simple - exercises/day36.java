public class day36 {

    public static void main(String[] args) {

        ToLCD(123456, 2);
        ToLCD(67890, 3);
    }

    public static void ToLCD (int num, int size) {

        final String horizontal = "-";
        final String vertical = "|";
        char[] numbers = Integer.toString(num).toCharArray();

        for (int o = 0 ; o < ((size * 2) + 3) ; o++) {
            if (o == 0 || o == (size + 1) || o == (size * 2) + 2) {
                for (char number : numbers) {
                    if (number == '1') {
                        CreateSpaces(size, 4);
                    } else if (number == '2') {
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, 1);
                    } else if (number == '3') {
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, 1);
                    } else if (number == '4') {
                        if (o == (size + 1)) {
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            CreateSpaces(size, 0);
                        } else {
                            CreateSpaces(size, 2);
                        }
                    } else if (number == '5') {
                        CreateSpaces(1, 0);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, 0);
                    } else if (number == '6') {
                        CreateSpaces(1, 0);

                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, -1);
                    } else if (number == '7') {
                        if (o == 0) {
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            CreateSpaces(1, 0);
                        } else {
                            CreateSpaces(size, 1);
                        }
                    } else if (number == '8') {
                        CreateSpaces(1, 0);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, -1);
                    } else if (number == '9') {
                        CreateSpaces(1, 0);
                        for (int i = 0; i < size; i++) {
                            System.out.print(horizontal);
                        }
                        CreateSpaces(size, -1);
                    } else if (number == '0') {
                        if (o != (size + 1)) {
                            CreateSpaces(1, 0);
                            for (int i = 0; i < size; i++) {
                                System.out.print(horizontal);
                            }
                            CreateSpaces(size, -1);
                        }
                    }
                }
                System.out.print("\n");
            } else {
                for (char number : numbers) {
                    if (number == '1') {
                        CreateSpaces(size, 1);
                        System.out.print(vertical);
                    } else if (number == '2') {
                        if (o < (size + 1)) {
                            CreateSpaces(size, 2);
                            System.out.print(vertical);
                        } else {
                            CreateSpaces(size, -1);
                            System.out.print(vertical);
                        }
                    } else if (number == '3') {
                        if (o < (size + 1)) {
                            CreateSpaces(size, 2);
                            System.out.print(vertical);
                            CreateSpaces(size, -1);
                        } else {
                            CreateSpaces(size, 5);
                            System.out.print(vertical);
                            CreateSpaces(size, -1);
                        }
                    } else if (number == '4') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            CreateSpaces(size, 0);
                        } else {
                            CreateSpaces(size, 1);
                        }
                        System.out.print(vertical);
                        CreateSpaces(size, -1);
                    } else if (number == '5') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            CreateSpaces(size, 2);
                        } else {
                            CreateSpaces(size, 1);
                            System.out.print(vertical);
                            CreateSpaces(size, -1);
                        }
                    } else if (number == '6') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            CreateSpaces(size, 0);
                        } else {
                            System.out.print(vertical);
                            CreateSpaces(size, 0);
                            System.out.print(vertical);
                        }
                    } else if (number == '7') {
                        if (o < (size + 1)) {
                            CreateSpaces(size, 2);
                            System.out.print(vertical);
                        } else {
                            CreateSpaces(size, 1);
                            System.out.print(vertical);
                        }
                    } else if (number == '8') {
                        System.out.print(vertical);
                        CreateSpaces(size, 0);
                        System.out.print(vertical);
                        CreateSpaces(1, 0);
                    } else if (number == '9') {
                        if (o < (size + 1)) {
                            System.out.print(vertical);
                            CreateSpaces(size, 0);
                            System.out.print(vertical);
                            CreateSpaces(0, 1);
                        } else {
                            CreateSpaces(size, 1);
                            System.out.print(vertical);
                            CreateSpaces(0, 1);
                        }
                    } else if (number == '0') {
                        System.out.print(vertical);
                        CreateSpaces(size, 0);
                        System.out.print(vertical);
                    }
                }
                System.out.print("\n");
            }
        }
    }

    public static void CreateSpaces (int size, int spaces) {
        final String space = " ";

        int length = size + spaces;

        for (int i = 0; i < length ; i++) {
            System.out.print(space);
        }
    }
}
