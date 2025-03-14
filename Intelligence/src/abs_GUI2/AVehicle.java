package abs_GUI2;

abstract class AVehicle {
    private final int age;
    public AVehicle(int age) {
        this.age = age;
    }
    public abstract void start();
    public abstract void stop();
    public abstract String getStatusDescription();
    public abstract void flex();
    public int getAge() {return java.time.Year.now().getValue() - age;}
}

class Airplane extends AVehicle{
    private final boolean[] engines;
    private static final int MAX_AGE = 30;

    public Airplane(int age, int quantity) {
        super(age);
        engines = new boolean[quantity];
    }

    public int getTotalOfEngines() {
        return engines.length;
    }

    public int getRunningEngines() {
        int count = 0;
        for (boolean engine : engines) {
            if (engine) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void start() {
        boolean run = true;
        for ( int i = 0; i < getTotalOfEngines(); i++ ) {
            if (!engines[i]) {
                run = false;
                engines[i] = true;
            }
        }
        if(run){
            System.out.println("All engines are already running.");
            return;
        }
        System.out.println("Started " + getRunningEngines() + " out of " + getTotalOfEngines() + " engines.");
    }

    @Override
    public void stop() {
        boolean stopped = true;
        for ( int i = 0; i < getTotalOfEngines(); i++ ) {
            if (engines[i]) {
                engines[i] = false;
                stopped = false;
            }
        }
        if(stopped){
            System.out.println("All engines are already stopped.");
            return;
        }
        System.out.println("Stopped all engines.");
    }

    @Override
    public String getStatusDescription() {return "Running engines: " + getRunningEngines() + " out of " + getTotalOfEngines();}

    @Override
    public void flex() {System.out.println("Airplane consists of " + getTotalOfEngines() + " engines.");}

    public boolean isRetired() {return getAge() > MAX_AGE;}

    public boolean[] getEngines(){return engines;}
}

class main {
    public static void main(String[] args) {
        String[] art = {
                "..............................",
                "..............................",
                "..............77..............",
                ".............:##:.............",
                ".............:##:.............",
                "..........!~7G&&G7~!..........",
                ".......~!!B&@@&&@&&B!!~.......",
                ".....:!P&#BPYY&&YYPB#&P!:.....",
                "....!55J!^:..:##:..:^!J55!....",
                "....::........BB........::....",
                "...........^7P##P7^...........",
                "..........:77~^^~77:..........",
                "..............................",
                ".............................."};

        for (String line : art) {
            System.out.println(line);
        }

        Airplane airplane1 = new Airplane(1980, 4);
        Airplane airplane2 = new Airplane(2020, 2);

        System.out.println("Airplane 1:");
        airplane1.start();
        System.out.println(airplane1.getStatusDescription());
        airplane1.stop();
        airplane1.stop();
        System.out.println(airplane1.getStatusDescription());
        airplane1.stop();
        airplane1.start();
        airplane1.start();
        airplane1.flex();
        System.out.println("Is retired: " + ((airplane1.isRetired()) ? "Yes" : "No"));

        System.out.println("\nAirplane 2:");
        airplane2.start();
        airplane2.stop();
        airplane2.stop();
        System.out.println(airplane2.getStatusDescription());
        airplane2.flex();
        System.out.println("Is retired: " + ((airplane2.isRetired()) ? "Yes" : "No") + "\n");

        AVehicle vehicle1 = airplane1;
        vehicle1.start();
        vehicle1.flex();
        System.out.println(vehicle1.getStatusDescription());

        AVehicle vehicle2 = airplane2;
        vehicle2.flex();

        System.out.println("\nAVehicle 1 age: "+vehicle1.getAge());
        System.out.println("AVehicle 2 age: "+vehicle2.getAge());

        boolean[] engines1 = airplane1.getEngines();
        System.out.print("\nAirplane 1 Engines: ");
        for (boolean engine : engines1) {
            System.out.print(engine + " ");
        }
        System.out.println();

        boolean[] engines2 = airplane2.getEngines();
        System.out.print("Airplane 2 Engines: ");
        for (boolean engine : engines2) {
            System.out.print(engine + " ");
        }
        System.out.println();
    }
}