package Entity;
import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;


    @ManyToOne
    @JoinColumn(name = "transportCompanyId")
    private TransportCompany transportCompany;

    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicle() {

    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public TransportCompany getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(TransportCompany transportCompany) {
        this.transportCompany = transportCompany;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", transportCompany=" + transportCompany +
                '}';
    }
}
