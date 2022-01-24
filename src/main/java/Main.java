import DAO.DriverDAO;
import DAO.TransportCompanyDAO;
import DAO.TransportDAO;
import Entity.ReadFile;
import Entity.WriteFIleForTransports;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
/*
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle();
        List<Vehicle> vehicleList = new LinkedList<>();
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);
        vehicleList.add(vehicle3);
        //VehicleDAO.saveOrUpdateVehicle(vehicle1);
        //VehicleDAO.saveOrUpdateVehicle(vehicle2);
        //VehicleDAO.saveOrUpdateVehicle(vehicle3);

       // Driver driver1 = new Driver(true,true,true,2000);
       // Driver driver2 = new Driver(true,true,true,500);
        Driver driver3 = new Driver(true,true,true,2200);
        Set<Driver> driverList = new HashSet<Driver>();
//        DriverDAO.saveOrUpdateDriver(driver1);
  //      DriverDAO.saveOrUpdateDriver(driver2);
          DriverDAO.saveOrUpdateDriver(driver3);
        Transport transport = new Transport("varna","Sofia", LocalDate.of( 2022 , 1 , 1 ), LocalDate.of( 2022 , 1 , 1 ),12 ,150);
       // TransportDAO.saveTransport(transport);

       // List<Transport> transportList = new LinkedList<Transport>();
        //transportList.add(transport);
       // TransportCompany transportCompany1 = new TransportCompany("ekont",vehicleList,driverList,transportList);

        //TransportCompanyDAO.saveOrUpdateTransportCompany(transportCompany1);

        //List<TransportCompany> transportCompanies = new LinkedList<TransportCompany>();

*/
        //show all transports for company by ID of the company
        //TransportCompanyDAO.getTransportCompanyTransports(1).stream().forEach(System.out::println);

        //showing all drivers in a company by company id
        //TransportCompanyDAO.getTransportCompanyDrivers(1).stream().forEach(System.out::println);




        //зад 7 a) За компаниите по име и приходи.
        //по име
        System.out.println("filtered by name");
        TransportCompanyDAO.companiesWithNameEqualTo("ekont").stream().forEach(System.out::println);
        //По приходи в диапазон
        System.out.println("filtered by income");
        TransportCompanyDAO.TransportCompaniesIncomeFilterBetween(1000,2000).stream().forEach(System.out::println);
        //sorted by name
        System.out.println("sort by name");
        TransportCompanyDAO.TransportCompaniesSortedByNameAscending().stream().forEach(System.out::println);
        //sorted by income
        System.out.println("sort by income");
        TransportCompanyDAO.TransportCompaniesSortedByIncomeAscending().stream().forEach(System.out::println);
        //зад 7 б) за шофьорите по квалификаци и заплата.
        //по квалификаци
        System.out.println("filter by qualifications");
        DriverDAO.driversFilterForQualifications(true,true,true).stream().forEach(System.out::println);
        //заплата
        System.out.println("filter by salary");
        DriverDAO.driversSalaryFilterBetween(1000,2000).stream().forEach(System.out::println);
        //sort by qualifications
        System.out.println("sort by qualification");
        DriverDAO.driversSortedByQualificationsAscending().stream().forEach(System.out::println);
        //sort by salary
        System.out.println("sort by salary");
        DriverDAO.driversSortedBySalaryAscending().stream().forEach(System.out::println);
        //c  for transport by destination

        System.out.println("sort by starting destination");
        TransportDAO.TransportsSortedByStartDestinationAscending().stream().forEach(System.out::println);
        System.out.println("sort by ending destination");
        TransportDAO.TransportsSortedByEndDestinationAscending().stream().forEach(System.out::println);

        System.out.println("Filter by starting destination");
        TransportDAO.TransportsFrom("varna").stream().forEach(System.out::println);
        System.out.println("Filter by ending destination");
        TransportDAO.TransportsTo("sofia").stream().forEach(System.out::println);

        //zad8
        //writing and reading the file for transports
        WriteFIleForTransports.writeFile("transport.csv");
        ReadFile.readFile("transport.csv");

        //zad 10

        System.out.println("Number of transports"+TransportDAO.CheckUpForTransports());
        System.out.println("Price of all transports"+TransportDAO.CheckSumPrices());

        //from date to date sum of income
        System.out.println("Sum of transport prices for january"+ TransportCompanyDAO.incomeForTransportCompaniesBetween(1,LocalDate.of( 2022 , 2 , 1) ,LocalDate.of( 2022 , 1 , 1 )));

        System.out.println("All income a driver has aquired to the company he is in: " + DriverDAO.DriversEarnedFromTransports(4));
    }

}
