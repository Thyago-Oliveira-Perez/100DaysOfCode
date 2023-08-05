class Day15
{
    public static void Main()
    {
        Console.WriteLine(IsAnagram("anagram", "nagaram"));
        Console.WriteLine(IsAnagram("rat", "car"));
    }

    public static bool IsAnagram(string word, string word2)
    {
        if (word.Length != word2.Length) return false;

        var wordArray = word.ToCharArray();
        Array.Sort(wordArray);

        var word2Array = word2.ToCharArray();
        Array.Sort(word2Array);

        for (var i = 0; i < wordArray.Length; i++)
        {
            if (wordArray[i] != word2Array[i])
            {
                return false;
            }
        }

        return true;
    }
}