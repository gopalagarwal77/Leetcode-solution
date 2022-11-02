class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               // count++;
                return true;
            }
            else{
                map.put(nums[i],1);
            }
        }
        return false;
    }
}