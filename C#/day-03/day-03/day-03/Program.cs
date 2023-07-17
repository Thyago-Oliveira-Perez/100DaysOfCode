class Day03 
{ 
    public static void Main()
    {
        List<string> skewers = new() { 
            "--oooo-ooo--",
            "--xx--x--xx--",
            "--o---o--oo--",
            "--xx--x--ox--",
            "--xx--x--ox--" 
        };

        int[] result = CountSkewers(skewers);

        Console.WriteLine(string.Format("skewers\nvegetable: {0} non-vegetable: {1}", result[0], result[1]));
    }

    public static int[] CountSkewers(List<string> skewers)
    {
        int qtdV = 0;
        int qtdM = 0;

        foreach (string skewer in skewers) 
        {
            bool vegetable = skewer.Contains("o");
            bool meat = skewer.Contains("x");

            if (vegetable && meat || !vegetable && meat) 
            { 
                qtdM++;
            }

            if (vegetable && !meat)
            {
                qtdV++;
            }
        }
        // [vegetarian skewers, non-vegetarian skewers]
        return new int[] { qtdV, qtdM };
    }
}