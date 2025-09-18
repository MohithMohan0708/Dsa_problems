class Tuple {
    int userId;
    int taskId;
    int priority;

    Tuple(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

class TaskManager {
    private PriorityQueue<Tuple> pq;
    private HashMap<Integer, Tuple> taskmap;

    public TaskManager(List<List<Integer>> tasks) {
        taskmap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority == b.priority) {
                return Integer.compare(b.taskId, a.taskId);
            }
            return Integer.compare(b.priority, a.priority);
        });

        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Tuple t = new Tuple(userId, taskId, priority);
        taskmap.put(taskId, t);
        pq.offer(t);
    }

    public void edit(int taskId, int newPriority) {
        if (!taskmap.containsKey(taskId)) return;
        Tuple old = taskmap.get(taskId);
        Tuple updated = new Tuple(old.userId, taskId, newPriority);
        taskmap.put(taskId, updated);
        pq.offer(updated);
    }

    public void rmv(int taskId) {
        taskmap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Tuple top = pq.poll();
            Tuple current = taskmap.get(top.taskId);
            if (current != null && current.priority == top.priority && current.userId == top.userId) {
                taskmap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}
