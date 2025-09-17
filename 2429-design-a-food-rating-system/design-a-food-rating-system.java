class Tuple {
    String food;
    String cuisine;
    int rating;
    Tuple(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    private Map<String, Tuple> foodMap;
    private Map<String, PriorityQueue<Tuple>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Tuple t = new Tuple(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], t);

            cuisineMap.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> {
                if (a.rating == b.rating) {
                    return a.food.compareTo(b.food);
                }
                return Integer.compare(b.rating, a.rating);
            }));

            cuisineMap.get(cuisines[i]).offer(t);
        }
    }

    public void changeRating(String food, int newRating) {
        Tuple old = foodMap.get(food);
        Tuple updated = new Tuple(food, old.cuisine, newRating);
        foodMap.put(food, updated);
        cuisineMap.get(old.cuisine).offer(updated);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Tuple> pq = cuisineMap.get(cuisine);
        while (!pq.isEmpty()) {
            Tuple top = pq.peek();
            Tuple current = foodMap.get(top.food);
            if (top.rating == current.rating) {
                return top.food;
            }
            pq.poll();
        }
        return "null";
    }
}