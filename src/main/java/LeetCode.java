import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode {

    public void printLol() {
        System.out.println("Lol");
    }

    public boolean hasDuplicate(int[] nums) {
        int[] a = nums;
        IntStream b = Arrays.stream(a).sorted();
        System.out.println(Arrays.toString(b.toArray()));
        System.out.println("true");
        return true;
    }


}
