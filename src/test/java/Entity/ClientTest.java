package Entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
Client client = new Client();
TransportCompany transportCompany = new TransportCompany();
    Transport transport = new Transport("varna","Sofia", LocalDate.of( 2022 , 1 , 1 ), LocalDate.of( 2022 , 1 , 1 ),12 ,150);
    @Test
    void payThrowsException() throws Exception {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            client.pay(transportCompany,transport);
        });
    }
}