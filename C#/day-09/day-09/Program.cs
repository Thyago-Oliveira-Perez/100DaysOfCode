class Day09
{
    public static void Main()
    {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        Console.Write(GetTrappedRainWater(height , height.Length));
    }

    private static int GetTrappedRainWater(int[] arr, int n)
    {
        int res = 0;

        for (int i = 1; i < n - 1; i++)
        {
            int left = arr[i];
            for (int j = 0; j < i; j++)
            {
                left = Math.Max(left, arr[j]);
            }

            int right = arr[i];
            for (int j = i + 1; j < n; j++)
            {
                right = Math.Max(right, arr[j]);
            }

            res += Math.Min(left, right) - arr[i];
        }
        return res;
    }
}