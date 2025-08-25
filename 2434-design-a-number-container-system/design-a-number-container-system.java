class NumberContainers {
    private HashMap<Integer,Integer> indexTonumbers;
    private HashMap<Integer, TreeSet<Integer>> numberToindices;
    public NumberContainers() {
        indexTonumbers = new HashMap<>();
        numberToindices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexTonumbers.containsKey(index)){
            int oldNumber = indexTonumbers.get(index);
            if(numberToindices.containsKey(oldNumber)){
                numberToindices.get(oldNumber).remove(index);
                if(numberToindices.get(oldNumber).isEmpty()){
                    numberToindices.remove(oldNumber);
                }
            }
        }
        indexTonumbers.put(index,number);
        numberToindices.putIfAbsent(number, new TreeSet<>());
        numberToindices.get(number).add(index);
    }
    
    public int find(int number) {
        if(numberToindices.containsKey(number) && !numberToindices.get(number).isEmpty()){
            return numberToindices.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */