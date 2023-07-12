public class day54 {

    public static void main(String[] args) {
        System.out.println(RgbToHex("rgb(0,128,192)"));
        System.out.println(RgbToHex("rgb(45,255,192)"));
        System.out.println(RgbToHex("rgb(0,0,0)"));
    }

    public static String RgbToHex (String rgb) {

        StringBuilder hexValue = new StringBuilder("#");

        String[] values = rgb.substring(4, rgb.length() - 1).split(",");

        for (String value : values) {
            int colorValue = Integer.parseInt(value);
            if (colorValue == 0) {
                hexValue.append(Integer.toString(colorValue, 16)).append(Integer.toString(colorValue, 16));
            } else {
                hexValue.append(Integer.toString(colorValue, 16));
            }
        }

        return hexValue.toString();
    }
}
