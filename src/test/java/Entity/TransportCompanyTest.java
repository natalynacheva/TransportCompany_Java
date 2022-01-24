package Entity;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportCompanyTest {
    Vehicle vehicle1 = new Vehicle(1);
    Vehicle vehicle2 = new Vehicle(2);
    Vehicle vehicle3 = new Vehicle(3);
    List<Vehicle> vehicleList = new ArrayList<>();
    Set<Driver> driverList = new HashSet<Driver>();
    List<Transport> transportList = new LinkedList<Transport>();
    TransportCompany transportCompany1 = new TransportCompany(1,"ekont",vehicleList,driverList,transportList);
    @Test
    void pay() {
        transportCompany1.pay(10);
        assertEquals(transportCompany1.getIncome(),10);
    }

    @Test
    void getId() {
        assertEquals(transportCompany1.getId(),1);
    }

    @Test
    void setId() {
        transportCompany1.setId(10);
        assertEquals(transportCompany1.getId(),10);
    }

    @Test
    void getIncome() {
        assertEquals(transportCompany1.getIncome(),0);
    }

    @Test
    void setIncome() {
        transportCompany1.setIncome(100);
        assertEquals(transportCompany1.getIncome(),100);

    }

    @Test
    void getName() {
        assertEquals(transportCompany1.getName(),"ekont");
    }

    @Test
    void setName() {
        transportCompany1.setName("ekont1");
        assertEquals(transportCompany1.getName(),"ekont1");
    }
    @Test
    void testToString() {
        assertEquals(transportCompany1.toString(),"TransportCompany{" +
                "id=" + transportCompany1.getId() +
                ", name='" + transportCompany1.getName() + '\'' +
                ", income=" + transportCompany1.getIncome() +
                '}');
    }
}