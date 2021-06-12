import java.util.*;

public class MinimumSum {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(12, "john", 1));
        people.add(new Person(12, "john", 2));
        people.add(new Person(12, "john", 3));
        people.add(new Person(12, "john", 4));
        people.add(new Person(12, "john", 5));
        people.add(new Person(12, "john", 6));
        MinimumSum q2 = new MinimumSum();
        System.out.println(q2.findMinOperationSum(people));
    }

    private long findMinOperationSum(List<Person> personList) {
        long sum = 0;
        PriorityQueue<Person> pq = new PriorityQueue<Person>(personList.size(), new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return (int)(p1.getHeight() - p2.getHeight());
            }
        });

        personList.stream().forEach(pq::add);

        while(pq.size()>1) {
            Person p1 = pq.poll();
            Person p2 = pq.poll();
            sum += p1.getHeight() + p2.getHeight();
            pq.add(new Person(0, "", (p1.getHeight()) + p2.getHeight()));
        }
        return sum;
    }
}
