class Day13
{
    public static void Main()
    {
        Console.WriteLine(CanFit(new int[] { 2, 1, 2, 5, 4, 3, 6, 1, 1, 9, 3, 2 }, 4));
        Console.WriteLine(CanFit(new int[] { 2, 7, 1, 3, 3, 4, 7, 4, 1, 8, 2 }, 4));
    }

    public static bool CanFit(int[] itens, int numBags)
    {
        //each bag can carry up to 10 kilos
        Array.Sort(itens);
        List<int> itensList = itens.ToList();
        int fullBags = 0;

        for (int i = 0; i < numBags; i++)
        {

            int bag = 0;
            bool possibleBag = false;

            while (!possibleBag)
            {
                List<int> passedItens = new List<int>();
                int j;
                for (j = itensList.Count - 1; j >= 0; j--)
                {
                    if ((bag + itensList[j]) <= 10)
                    {
                        bag += itensList[j];
                        passedItens.Add(itensList[j]);
                    }
                }

                passedItens.ForEach((e) => itensList.Remove(e));
                possibleBag = !possibleBag;
            }

            fullBags++;
        }

        return fullBags == numBags && itensList.Count == 0;
    }
}