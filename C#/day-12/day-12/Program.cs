class Day12
{
    public static void Main()
    {
        Console.WriteLine(LandscapeType(new int[] { 3, 4, 5, 4, 3 }));
        Console.WriteLine(LandscapeType(new int[] { 9, 7, 3, 1, 2, 4 }));
        Console.WriteLine(LandscapeType(new int[] { 9, 8, 9 }));
        Console.WriteLine(LandscapeType(new int[] { 9, 8, 9, 8 }));
    }

    public static string LandscapeType(int[] points)
    {
        if (IsMountain(points))
        {
            return "mountain";
        }

        if (IsValey(points))
        {
            return "valey";
        }

        return "neither";
    }

    public static bool IsValey(int[] points)
    {
        int trough = points.Min();
        int troughIndex = points.ToList().IndexOf(trough);

        if (trough == points[0] || trough == points[^1])
        {
            return false;
        }

        for (int i = 0; i < troughIndex; i++)
        {
            if (points[i] < points[i + 1])
            {
                return false;
            }
        }

        for (int i = troughIndex; i < points.Length - 1; i++)
        {
            if (points[i] > points[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    public static bool IsMountain(int[] points)
    {
        int peak = points.Max();
        int peakIndex = points.ToList().IndexOf(peak);

        if (peak == points[0] || peak == points[^1])
        {
            return false;
        }

        for (int i = 0; i < peakIndex; i++)
        {
            if (points[i] > points[i + 1])
            {
                return false;
            }
        }

        for (int i = peakIndex; i < points.Length - 1; i++)
        {
            if (points[i] < points[i + 1])
            {
                return false;
            }
        }

        return true;
    }
}