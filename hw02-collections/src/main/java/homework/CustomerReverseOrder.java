package homework;

import java.util.Stack;

public class CustomerReverseOrder {

    final private Stack<Customer> reverseStorage = new Stack<>();

    public void add(Customer customer) {
        reverseStorage.push(customer);
    }

    public Customer take() {
        return reverseStorage.pop();
    }
}
