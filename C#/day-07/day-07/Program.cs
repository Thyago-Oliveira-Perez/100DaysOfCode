class Day07
{

    public static void Main()
    {
        Console.WriteLine(
            string.Format("Merged arrays: {0}",
                string.Join(", ", MergeArrays(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3))
                )
            );
    }

    public static int[] MergeArrays(int[] nums1, int numElements1, int[] nums2, int numElements2)
    {
        int nums1Length = nums1.Length;
        
        if (nums1Length != (numElements1 + numElements2))
        {
            throw new Exception("Invalid array!");
        }

        int j = 0;

        //MERGE
        for (int i = 0; i < nums1Length; i++)
        {
           if (nums1[i] == 0)
           {
                nums1[i] = nums2[j];
                j++;
           }
        }

        //Sort
        for (int i = 0; i < nums1Length; i++)
        {
            if (i + 1 < nums1Length && nums1[i] > nums1[i+1])
            {
                int aux = nums1[i];
                nums1[i] = nums1[i+1];
                nums1[i+1] = aux;
            }
        }

        return nums1;
    }
}