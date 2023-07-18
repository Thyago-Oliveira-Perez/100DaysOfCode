class Day04
{
    public static void Main()
    {
        Console.WriteLine(string.Format("Number of progress days: {0}", GetNumberOfProgressDays(new int[] { 3, 4, 1, 2 })));
        Console.WriteLine(string.Format("Number of progress days: {0}", GetNumberOfProgressDays(new int[] { 10, 11, 12, 9, 10 })));
        Console.WriteLine(string.Format("Number of progress days: {0}", GetNumberOfProgressDays(new int[] { 6, 5, 4, 3, 2, 9 })));
        Console.WriteLine(string.Format("Number of progress days: {0}", GetNumberOfProgressDays(new int[] { 9, 9 })));
    }

    public static int GetNumberOfProgressDays(int[] days)
    {
        int progressDays = 0;
        int acc;

        for (int i = 0; i < days.Length; i++)
        {
            if (i - 1 < 0)
            {
                continue;
            }

            acc = days[i-1];

            if (acc < days[i])
            {
                progressDays++;
            }
        }

        return progressDays;
    }
}