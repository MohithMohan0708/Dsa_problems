class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++){
            int num = groupSizes[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            }
            else{
                map.put(num, new ArrayList<>());
                map.get(num).add(i);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int size = entry.getKey();
            List<Integer> arr = entry.getValue();
            if(arr.size()/size == 1){
                ans.add(arr);
            }
            else{
                int div = arr.size()/size;
                int index = 0;
                while(div!=0){
                    List<Integer> curr = new ArrayList<>();
                    for(int i = 0; i < size; i++){
                        curr.add(arr.get(index+i));
                    }
                    ans.add(curr);
                    div-=1;
                    index+=size;
                }
            }
        }
        return ans;
    }
}