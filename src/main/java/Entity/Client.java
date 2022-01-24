package Entity;

import DAO.ClientDAO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId", nullable = false)
    private int driverId;
    @ManyToMany(mappedBy = "clients")
    private Set<TransportCompany> transportCompanies;
    @Column(name = "isPaid",nullable = true)
    boolean paid;


    void pay(TransportCompany transportCompany, Transport transport){

        if(this.transportCompanies.contains(transportCompany)) {
            this.paid = true;
            transportCompany.pay(transport.getPrice());
        }
        else throw new NullPointerException();
        ClientDAO.saveOrUpdateClient(this);
    }

}
