package homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {

    final private Deque<Customer> reverseStorage = new ArrayDeque<>() {
    };

    public void add(Customer customer) {
        reverseStorage.push(customer);
    }

    public Customer take() {
        return reverseStorage.pop();
    }
}
