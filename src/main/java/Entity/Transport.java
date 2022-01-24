package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportId;
    @Column
    private String startingDestination;
    @Column
    private String endingDestination;
    @Column
    private LocalDate dateOfGoing;
    @Column
    private LocalDate dateOfArrival;
    @OneToOne
    @JoinColumn(name = "goodsId")
    private Goods goods;

    @Column(name="numOfPeople")
    private int numOfPeople;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "transportCompanyId")
    TransportCompany transportCompany;

    @ManyToOne
    @JoinColumn(name="driverId")
    Driver driver;
    public Transport() {

    }

    public Transport( String startingDestination, String endingDestination, LocalDate dateOfGoing, LocalDate dateOfArrival, Goods goods, double price) {
        this.startingDestination = startingDestination;
        this.endingDestination = endingDestination;
        this.dateOfGoing = dateOfGoing;
        this.dateOfArrival = dateOfArrival;
        this.goods = goods;
        //cant have people and goods at the same place
        this.numOfPeople = 0;
        this.price = price;
    }
    public Transport( String startingDestination, String endingDestination, LocalDate dateOfGoing, LocalDate dateOfArrival, double price,int numOfPeople) {
        this.startingDestination = startingDestination;
        this.endingDestination = endingDestination;
        this.dateOfGoing = dateOfGoing;
        this.dateOfArrival = dateOfArrival;
        //cant have people and goods at the same place
        this.goods = null;
        this.numOfPeople = numOfPeople;
        this.price = price;
    }
    public int getTransportId() {
        return transportId;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TransportCompany getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(TransportCompany transportCompany) {
        this.transportCompany = transportCompany;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public String getStartingDestination() {
        return startingDestination;
    }

    public void setStartingDestination(String startingDestination) {
        this.startingDestination = startingDestination;
    }

    public String getEndingDestination() {
        return endingDestination;
    }

    public void setEndingDestination(String endingDestination) {
        this.endingDestination = endingDestination;
    }

    public LocalDate getDateOfGoing() {
        return dateOfGoing;
    }

    public void setDateOfGoing(LocalDate dateOfGoing) {
        this.dateOfGoing = dateOfGoing;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Goods getGoods() {
        return goods;
    }



    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportId=" + transportId +
                ", startingDestination='" + startingDestination + '\'' +
                ", endingDestination='" + endingDestination + '\'' +
                ", dateOfGoing=" + dateOfGoing +
                ", dateOfArrival=" + dateOfArrival +
                ", goods=" + goods +
                ", numOfPeople=" + numOfPeople +
                ", price=" + price +
                '}';
    }
}
