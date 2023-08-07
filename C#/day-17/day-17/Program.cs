class Day17
{
    public static void Main()
    {
        Console.WriteLine(FreedPrisioners(new int[] { 1, 1, 0, 0, 0, 1, 0 }));
        Console.WriteLine(FreedPrisioners(new int[] { 1, 1, 1 }));
        Console.WriteLine(FreedPrisioners(new int[] { 0, 0, 0 }));
        Console.WriteLine(FreedPrisioners(new int[] { 0, 1, 1, 1 }));
    }

    public static int FreedPrisioners(int[] cells)
    {
        var freePrisoners = 0;

        if (cells[0] == 0) return freePrisoners; 

        for (var i = 0; i < cells.Length; i++)
        {
            if (cells[i] == 1)
            {
                freePrisoners++;
                cells = HandleCells(cells);
            }
        }

        return freePrisoners;
    }

    public static int[] HandleCells(int[] cells)
    {
        for (var i = 0; i < cells.Length; i++)
        {
            if (cells[i] == 0)
            {
                cells[i] = 1;
            }
            else if (cells[i] == 1)
            {
                cells[i] = 0;
            }
        }

        return cells;
    }
}