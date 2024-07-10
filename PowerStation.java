package PowerStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PowerStation {
    private String name;
    private double energyProduced; // in megawatts

    public PowerStation(String name, double energyProduced) {
        this.name = name;
        this.energyProduced = energyProduced;
    }

    public String getName() {
        return name;
    }

    public double getEnergyProduced() {
        return energyProduced;
    }

    public void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }

    @Override
    public String toString() {
        return "PowerStation{" +
                "name='" + name + '\'' +
                ", energyProduced=" + energyProduced +
                '}';
    }
}

class PowerHouseManagementSystem {
    private List<PowerStation> powerStations;

    public PowerHouseManagementSystem() {
        powerStations = new ArrayList<>();
    }

    public void addPowerStation(PowerStation powerStation) {
        powerStations.add(powerStation);
    }

    public void removePowerStation(String name) {
        powerStations.removeIf(station -> station.getName().equals(name));
    }

    public PowerStation getPowerStation(String name) {
        for (PowerStation station : powerStations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public void displayPowerStations() {
        for (PowerStation station : powerStations) {
            System.out.println(station);
        }
    }

    public double getTotalEnergyProduced() {
        double total = 0;
        for (PowerStation station : powerStations) {
            total += station.getEnergyProduced();
        }
        return total;
    }

    public static void main(String[] args) {
        PowerHouseManagementSystem system = new PowerHouseManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Power Station");
            System.out.println("2. Remove Power Station");
            System.out.println("3. Display Power Stations");
            System.out.println("4. Get Total Energy Produced");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Power Station Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Energy Produced (in MW):");
                    double energy = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    system.addPowerStation(new PowerStation(name, energy));
                    break;
                case 2:
                    System.out.println("Enter Power Station Name to Remove:");
                    String removeName = scanner.nextLine();
                    system.removePowerStation(removeName);
                    break;
                case 3:
                    system.displayPowerStations();
                    break;
                case 4:
                    System.out.println("Total Energy Produced: " + system.getTotalEnergyProduced() + " MW");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
