package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {
    Vehicle vehicle = new Vehicle(1);
    @Test
    void getVehicleId() throws NoSuchFieldException, IllegalAccessException  {

        assertEquals(vehicle.getVehicleId(),1);
    }

    @Test
    void setVehicleId() {
        vehicle.setVehicleId(10);
        assertEquals(vehicle.getVehicleId(),10);
    }

    @Test
    void testToString() {
        assertEquals(vehicle.toString(),"Vehicle{" +
                "vehicleId=" + vehicle.getVehicleId() +
                ", transportCompany=" + vehicle.getTransportCompany() +
                '}');
    }
}