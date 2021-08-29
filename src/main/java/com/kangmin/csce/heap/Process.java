package main.java.com.kangmin.csce.heap;

/**
 * Program of Process Class
 * instance variable name, Type String
 * instance variable priority, Type int
 * instance variable time, Type double
 * Method toString()was override;
 * Method equals()defined;
 * compareTo()defined
 */

public class Process {
    //Instance variables
    private int priority;
    private double time;
    private String name;

    //Default constructor
    public Process() {
        this.priority = 0;
        this.time = 0.0;
        this.name = "no name";
    }

    //Parameterized constructor
    Process(String aName, int aPriority, double aTime) {
        this.setName(aName);
        this.setPriority(aPriority);
        this.setTime(aTime);
    }

    //Accessors
	private String getName() {
        return name;
    }

    private int getPriority() {
        return priority;
    }

    double getTime() {
        return time;
    }

    //Mutators
	private void setName(String aName) {
        this.name = aName;
    }

    private void setPriority(int aPriority) {
		this.priority = Math.max(aPriority, 0);
    }

    private void setTime(double aTime) {
        if (aTime > 0)
            this.time = aTime;
        else
            this.time = 0.0;
    }


    //Method Process.toString, overwrite toString for printing purpose
    public String toString() {
        return this.getName() + " " + this.getPriority() + " " + this.getTime();
    }


    //Method equals
    public boolean equals(Process aProcess) {
        return this.name.equals(aProcess.getName()) &&
                this.priority == (aProcess.getPriority()) &&
                (Math.abs(this.time - aProcess.getTime()) < 0.000001);
    }


    //Method compareTo
    public int compareTo(Process aProcess) {
		return Integer.compare(this.priority, aProcess.getPriority());
    }

}//end of Process Class
