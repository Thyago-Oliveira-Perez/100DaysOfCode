class Day05
{

    public static void Main()
    {
        Console.WriteLine(FindSocks("AA"));
        Console.WriteLine(FindSocks("AAB"));
        Console.WriteLine(FindSocks("ABABC"));
        Console.WriteLine(FindSocks("CABBACCC"));
    }

    public static int FindSocks(string socks)
    {
        if (socks == "") return 0;

        int numOfPairs = 0;
        Dictionary<char, int> pairOfSocks = new Dictionary<char, int>();

        foreach (char sock in socks)
        {
            if (!pairOfSocks.ContainsKey(sock))
            {
               pairOfSocks.Add(sock, 1);
            } else
            {
                pairOfSocks[sock]++;
            }


            if (pairOfSocks[sock] % 2 == 0)
            {
                numOfPairs++;
            }
        }

        return numOfPairs;
    }
}