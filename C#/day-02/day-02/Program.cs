class Day02
{
    public static void Main()
    {
        Console.WriteLine("Write the phrase that contains Nemo:");
        string word = Console.ReadLine();

        var nemoPosition = FindingNemo(word);
        
        if (nemoPosition == 0)
        {
            Console.WriteLine("I can't find Nemo :(");
        } else 
        { 
            Console.WriteLine(string.Format("I found Nemo at {0}!", nemoPosition));
        }
    }

    public static int FindingNemo(string phrase)
    {
        const string NEMO = "Nemo";
        if (phrase == null) { return 0; }

        string[] words = phrase.Split(" ");

        for (int i = 1; i <= words.Length; i++)
        {
            if (words[i-1] == NEMO) return i;
        }

        return 0;
    }
}