import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day07 {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,1};

        System.out.println(MergeArrays(nums1, nums2));
    }

    public static String MergeArrays(int[] nums1, int[] nums2) {

        final String failMessage = "It's impossible to merge the arrays";
        List<Integer> newArray = new ArrayList<>();

        //create a newArray with all the nums1 values but zeros
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] != 0) newArray.add(nums1[i]);
        }

        if(nums1.length < newArray.size() + nums2.length) return failMessage;

        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] != 0) newArray.add(nums2[i]);
        }

        Collections.sort(newArray);

        return MessageFormat.format("New merged array: {0}", newArray);
    }
}
