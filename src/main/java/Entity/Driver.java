package Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverId", nullable = false)
    private int driverId;

    @Column(name = "canDriveSpecialGoods",columnDefinition="BOOLEAN DEFAULT false")
    boolean canDriveSpecialGoods;

    @Column(name = "canDriveMoreThan12People",columnDefinition="BOOLEAN DEFAULT false")
    boolean canDriveMoreThan12People;

    @Column(name = "canDriveFlamableGoods",columnDefinition="BOOLEAN DEFAULT false")
    boolean canDriveFlamableGoods;
    @Column(name = "salary")
    double salary;
    @ManyToMany(mappedBy = "drivers")
    private Set<TransportCompany> transportCompanies;

    @OneToMany(mappedBy ="driver" )
    List<Transport> transportsList;

    public Driver() {
    }

    public Driver(boolean canDriveSpecialGoods, boolean canDriveMoreThan12People, boolean canDriveFlamableGoods, double salary) {
        this.driverId = driverId;
        this.canDriveSpecialGoods = canDriveSpecialGoods;
        this.canDriveMoreThan12People = canDriveMoreThan12People;
        this.canDriveFlamableGoods = canDriveFlamableGoods;
        this.salary = salary;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public boolean isCanDriveSpecialGoods() {
        return canDriveSpecialGoods;
    }

    public void setCanDriveSpecialGoods(boolean canDriveSpecialGoods) {
        this.canDriveSpecialGoods = canDriveSpecialGoods;
    }

    public boolean isCanDriveMoreThan12People() {
        return canDriveMoreThan12People;
    }

    public void setCanDriveMoreThan12People(boolean canDriveMoreThan12People) {
        this.canDriveMoreThan12People = canDriveMoreThan12People;
    }

    public boolean isCanDriveFlamableGoods() {
        return canDriveFlamableGoods;
    }

    public void setCanDriveFlamableGoods(boolean canDriveFlamableGoods) {
        this.canDriveFlamableGoods = canDriveFlamableGoods;
    }

    public Set<TransportCompany> getTransportCompanies() {
        return transportCompanies;
    }

    public void setTransportCompanies(Set<TransportCompany> transportCompanies) {
        this.transportCompanies = transportCompanies;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", canDriveSpecialGoods=" + canDriveSpecialGoods +
                ", canDriveMoreThan12People=" + canDriveMoreThan12People +
                ", canDriveFlamableGoods=" + canDriveFlamableGoods +
                ", salary=" + salary +
                '}';
    }
}
