package Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "transportCompany")

public class TransportCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportCompanyId", nullable = false)
    public int id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="income")
    private double income;
    @OneToMany(mappedBy = "transportCompany")
    public List<Vehicle> vehicles;

    @ManyToMany
    @JoinTable(
            name = "Transport_company_drivers",
            joinColumns = {@JoinColumn(name = "transportCompanyId")},
            inverseJoinColumns = {@JoinColumn(name = "driverId")}
    )
    public Set<Driver> drivers;

    @OneToMany(mappedBy = "transportCompany")
    public List<Transport> transports;

    @ManyToMany
    @JoinTable(
            name = "Transport_company_clients",
            joinColumns = {@JoinColumn(name = "transportCompanyId")},
            inverseJoinColumns = {@JoinColumn(name = "clientsId")}
    )
    private Set<Client> clients;
    public TransportCompany() {}
    public TransportCompany(int id, String name, List<Vehicle> vehicles, Set<Driver> drivers, List<Transport> transports) {
        this.id = id;
        this.name = name;
        this.vehicles = vehicles;
        this.drivers = drivers;
        this.transports = transports;
        this.income = 0;
    }

    public TransportCompany(String name, List<Vehicle> vehicles, Set<Driver> drivers, List<Transport> transports) {
        this.name = name;
        this.income = 0;
        this.vehicles = vehicles;
        this.drivers = drivers;
        this.transports = transports;
    }

    public void pay(double amount) {
        this.income+=amount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "TransportCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", income=" + income +
                '}';
    }
}
