package homework;

import java.util.AbstractMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    private final NavigableMap<Customer, String> storageMap = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> entry = storageMap.firstEntry();
        if (entry != null) {
            return new AbstractMap.SimpleEntry<>(entry.getKey().copy(), entry.getValue());
        }
        return null;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = storageMap.higherEntry(customer);
        if (entry != null) {
            return new AbstractMap.SimpleEntry<>(entry.getKey().copy(), entry.getValue());
        }
        return null;
    }

    public void add(Customer customer, String data) {
        storageMap.put(customer, data);
    }
}
