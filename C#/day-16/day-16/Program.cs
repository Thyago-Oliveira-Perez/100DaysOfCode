class Day16
{
    public static void Main()
    {
        Console.WriteLine(NimGame(1)); // should win
        Console.WriteLine(NimGame(2)); // should win
        Console.WriteLine(NimGame(4)); // should lose
        Console.WriteLine(NimGame(5)); // should lose
        Console.WriteLine(NimGame(6)); // should lose
        Console.WriteLine(NimGame(7)); // should win
        Console.WriteLine(NimGame(10)); // should lose
    }

    public static bool NimGame(int numStones)
    {
        return (int)Math.Ceiling((double)numStones / 3) % 2 != 0;
    }
}