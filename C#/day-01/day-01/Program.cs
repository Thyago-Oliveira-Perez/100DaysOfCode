class Day01
{
    public static void Main()
    {
        Console.WriteLine("Type your age:");

        try
        {
            var ageInYears = Int32.Parse(Console.ReadLine());
            
            if (ageInYears < 0) throw new Exception();

            Console.WriteLine(
                String.Format("This is your age in days: {0}", CalcAge(ageInYears))
            );
        }
        catch (Exception ex)
        {
            Console.WriteLine("Input must be a valid number! Positive and not null.");
        }
    }

    public static int CalcAge(int ageInYears)
    {
        const int YEAR_LENGTH = 365;

        return ageInYears * YEAR_LENGTH;
    }
}