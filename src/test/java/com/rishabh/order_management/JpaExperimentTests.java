package com.rishabh.order_management;

import com.rishabh.order_management.Model.Order;
import com.rishabh.order_management.Model.User;
import com.rishabh.order_management.Repository.OrderRepository;
import com.rishabh.order_management.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaExperimentTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;
    @AfterEach
    void cleanup() {
        orderRepository.deleteAll();
        userRepository.deleteAll();
    }
    /*
    WHY?
Tum @Transactional use nahi kar rahe.
So:
rollback nahi hoga
data DB mein rahega
Har test clean hona chahiye.
     */


//    Experiment: 1
    /*
@Test
void saveUserWithoutId_usingRepository() {

    User user = new User();
    user.setName("Rishabh");
    user.setEmail("r@test.com");

    User savedUser = userRepository.save(user);

    assertNotNull(savedUser.getId());
}
*/
    //exper : 4

void saveUserWithOrders() {

    User user = new User();
    user.setName("Rishabh");
    user.setEmail("orders@test.com");

    Order o1 = new Order();
    o1.setProductName("Laptop");
    o1.setPrice(50000);
    o1.setQuantity(1);

    Order o2 = new Order();
    o2.setProductName("Phone");
    o2.setPrice(20000);
    o2.setQuantity(2);

    user.addOrder(o1);
    user.addOrder(o2);

    User savedUser = userRepository.save(user);

    entityManager.flush();

    assertNotNull(savedUser.getId());

    assertEquals(2, savedUser.getOrders().size());
}
}