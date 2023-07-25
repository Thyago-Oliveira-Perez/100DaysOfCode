class Day08
{
    public static void Main()
    {
        Console.WriteLine(string.Format("output:"));
        MappedDigits("23").ForEach(e => Console.WriteLine(e));
    }

    public static List<string> MappedDigits(string digits)
    {
        List<string> mappedValues = new();

        Dictionary<int, string[]> mappedDigits = new()
        {
            { 2, new string[] {"a","b","c" } },
            { 3, new string[] {"d","e","f" } },
            { 4, new string[] {"g","h","i" } },
            { 5, new string[] {"j","k","l" } },
            { 6, new string[] {"m","n","o" } },
            { 7, new string[] {"p","q","r", "s" } },
            { 8, new string[] {"t","u","v" } },
            { 9, new string[] {"w","x","y", "z" } },
        };

        List<string[]> selectedDigits = new();

        char[] digitsInt = digits.ToCharArray();
        
        foreach(char digit in digitsInt)
        {
            selectedDigits.Add(mappedDigits[int.Parse(digit.ToString())]);
        }

        for (int i = 0; i < selectedDigits.Count; i++)
        {
            for (int j = 0; j < selectedDigits[i].Length; j++)
            {
                if (i+1 < selectedDigits.Count)
                {
                    for (int o = 0; o < selectedDigits[i+1].Length; o++)
                    {
                        mappedValues.Add(string.Format("{0}{1}", selectedDigits[i][j], selectedDigits[i + 1][o]));
                    }
                } 
            }
        }

        return mappedValues;
    }
}