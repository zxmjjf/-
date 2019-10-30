package main.java.com.sampletest;

public class Job {
    private String name;
    private String industry;
    private double wages;

    public void setName(String name) {
        this.name = name;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public Job() {

    }

    public Job(String name, String industry, double wages) {
        this.name = name;
        this.industry = industry;
        this.wages = wages;
    }

    @Override
    public String toString() {
        return name + "\t" + industry + "\t" + wages;
    }
}
