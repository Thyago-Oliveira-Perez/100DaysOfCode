class Day06
{

    public static void Main()
    {
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(12)));
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(29)));
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(11)));
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(0)));
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(1)));
        Console.WriteLine(string.Format("Next prime: {0}", NextPrime(2)));
    }

    private static int NextPrime(int number)
    {
        while (!IsPrime(number))
        {
            number++;
        }

        return number;
    }

    private static bool IsPrime(int number)
    {
        int i = 1;
        int factors = 0;

        while (i <= number)
        {
            if (number % i == 0)
            {
                factors++;
            }
            i++;
        }

        if (factors == 2) return true;

        return false;
    }
}