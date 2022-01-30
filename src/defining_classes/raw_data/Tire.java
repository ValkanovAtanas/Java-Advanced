package defining_classes.raw_data;

public class Tire {
    private int tire1Age;
    private int tire2Age;
    private int tire3Age;
    private int tire4Age;
    private double tire1Pressure;
    private double tire2Pressure;
    private double tire3Pressure;
    private double tire4Pressure;

    public Tire(int tire1Age, double tire1Pressure, int tire2Age, double tire2Pressure, int tire3Age, double tire3Pressure, int tire4Age, double tire4Pressure) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public boolean isPressureLowerThanOne () {
        if (this.tire1Pressure < 1) {
            return true;
        } else if (this.tire2Pressure < 1) {
            return true;
        } else if (this.tire3Pressure < 1) {
            return true;
        } else if (this.tire4Pressure < 1) {
            return true;
        }
        return false;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public int getTire4Age() {
        return tire4Age;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }
}
