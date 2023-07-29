using System.Numerics;

class Day10
{
    public static void Main()
    {
        Console.WriteLine($"Output: {CalculateCatalanNumber(3)}");
    }

    public static int CalculateCatalanNumber(int n)
    {
        int numerator = Factorial(2 * n);
        int denominator = Factorial(n + 1) * Factorial(n);

        return numerator / denominator;
    }

    private static int Factorial(int n)
    {
        if (n <= 1)
        {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }
}