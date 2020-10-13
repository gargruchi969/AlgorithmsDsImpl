package self.test;

import java.util.ArrayList;
import java.util.List;

public class LISSolution {
	public static void main(String[] args) {
		int[] nums = {4,10,4,3,8,9};
		lengthOfLIS(nums);
	}
	public static int findPos(List<Integer> list, int target, int l, int r){
        while(l<r){
            int mid = (l+r)/2;
            if(list.get(mid)==target||(target<list.get(mid)&&(mid-1)<0)||(target<list.get(mid)&&target>list.get(mid-1)))
                return mid;
            else if(target>list.get(mid))
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }
    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(list.size()==0){
                list.add(nums[i]);
            }else if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else if(nums[i]<list.get(list.size()-1)){
                int pos = findPos(list, nums[i], 0, list.size()-1);
                list.set(pos, nums[i]);
            }
        }
        return list.size();
    }
}
