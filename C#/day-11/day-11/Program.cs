class Day11
{
    public static void Main()
    {
        //ShowResult(RestoreIpAddresses("25525511135"));
        //ShowResult(RestoreIpAddresses("0000"));
        //ShowResult(RestoreIpAddresses("1111"));
        //ShowResult(RestoreIpAddresses("010010"));
        ShowResult(RestoreIpAddresses("101023"));
    }

    public static void ShowResult(List<string> result)
    {
        result.ForEach((string combination) =>
        {
            Console.WriteLine(combination);
        });
    }

    public static List<string> RestoreIpAddresses(string input)
    {
        int lenght = input.Length;

        if (lenght < 4 || lenght > 12)
        {
            throw new Exception("Invalid input");
        }

        List<string> answear = new();

        for (int w = 1; w <= 3; w++)
        {
            for (int x = 1; x <= 3; x++)
            {
                for (int y = 1; y <= 3; y++)
                {
                    for (int z = 1; z <= 3; z++)
                    {
                        if (!(w + x + y + z > input.Length || w + x + y + z < input.Length))
                        {
                            string part1 = input[..w];
                            string part2 = input.Substring(w, x);
                            string part3 = input.Substring(w + x, y);
                            string part4 = input.Substring(w + x + y, z);

                            if (IsValid(part1) && IsValid(part2) && IsValid(part3) && IsValid(part4))
                            {
                                answear.Add(part1 + "." + part2 + "." + part3 + "." + part4);
                            }
                        }
                    }
                }
            }
        }

        return answear;
    }

    public static bool IsValid(string part)
    {
        if ((int.Parse(part) < 256) && (int.Parse(part) >= 0))
        {
            if (part.Length > 1 && part[0] == '0')
            {
                return false;
            }
            return true;
        }
        return false;
    }
}