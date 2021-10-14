import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-483,-464,-417,-372,-315,-303,-283,-282,-267,-265,-262,-256,-254,-248,-247,-245,-200,-200,-194,-192,-183,-155,-83,-69,-59,-44,-42,-40,-24,-18,-14,-11,0,4,10,28,38,59,87,126,135,147,151,152,162,187,211,214,218,248,274,282,287,288,329,331,338,364,366,384,405,476,477,488
            };
        System.out.println(fourSum(nums, 1563));
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> nummap = new HashMap<>();
        int purpose = 0;
        for(int i =0; i < nums.length; ++i){
            nummap.put(nums[i], i);
        }        
        for(int pa = 0; pa < nums.length - 3 ; ++pa){
            if(pa > 0 && nums[pa - 1] == nums[pa]){
                continue;
            }
            for(int pb = pa + 1; pb < nums.length - 2 ; ++pb){
                if(pb > pa + 1 && nums[pb - 1] == nums[pb]){
                    continue;
                }
                for(int pc = pb + 1; pc < nums.length - 1 ; ++pc){
                    if(pc > pb + 1 && nums[pc - 1] == nums[pc]){
                        continue;
                    }
                    purpose = target - nums[pa] - nums[pb] - nums[pc];
                    if(nummap.containsKey(purpose) &&  nummap.get(purpose) > pc){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[pa]);
                        l.add(nums[pb]);
                        l.add(nums[pc]);
                        l.add(purpose);
                        output.add(l);
                    }
                }
            }
            
            
        }
        return output;
    }
}
