package Entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {


    Transport transport = new Transport("varna","Sofia", LocalDate.of( 2022 , 1 , 1 ), LocalDate.of( 2022 , 1 , 1 ),12 ,150);

    @Test
    void getTransportId() {
        assertEquals(transport.getTransportId(),0);
    }


    @Test
    void getPrice() {
        assertEquals(transport.getPrice(),12);
    }

    @Test
    void setPrice() {
        transport.setPrice(100);
        assertEquals(transport.getPrice(),100);
    }


    @Test
    void setTransportId() {
        transport.setTransportId(10);
        assertEquals(transport.getTransportId(),10);
    }

    @Test
    void getStartingDestination() {
        assertEquals(transport.getStartingDestination(),"varna");
    }

    @Test
    void setStartingDestination() {
        transport.setStartingDestination("sofia");
        assertEquals(transport.getStartingDestination(),"sofia");

    }

    @Test
    void getEndingDestination() {
        assertEquals(transport.getEndingDestination(),"Sofia");

    }

    @Test
    void setEndingDestination() {
        transport.setEndingDestination("test");
        assertEquals(transport.getEndingDestination(),"test");
    }



    @Test
    void getGoods() {

        assertEquals(transport.getGoods(),null);
    }

    @Test
    void getNumOfPeople() {

        assertEquals(transport.getNumOfPeople(),150);
    }

    @Test
    void setNumOfPeople() {
        transport.setNumOfPeople(100);
        assertEquals(transport.getNumOfPeople(),100);

    }

    @Test
    void testToString() {
        assertEquals(transport.toString(),"Transport{transportId=0, startingDestination='varna', endingDestination='Sofia', dateOfGoing=2022-01-01, dateOfArrival=2022-01-01, goods=null, numOfPeople=150, price=12.0}");
    }
}