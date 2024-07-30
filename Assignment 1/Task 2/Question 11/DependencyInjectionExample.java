// Step 2: Define Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate finding a customer in the database
        // In a real application, this would involve database queries
        if (id == 1) {
            return "John Doe";
        } else {
            return "Customer not found";
        }
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to find a customer
        System.out.println(customerService.getCustomerName(1)); // Output: John Doe
        System.out.println(customerService.getCustomerName(2)); // Output: Customer not found
    }
}
