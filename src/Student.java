import java.util.*;

public class Student {
    //variable declaration
    private String[] notes; //grades 9-12 represented by indexes 0-3
    private String eduPlan;
    private String college;
    private String careerPath;
    private String ethnicity;
    private boolean regents;
    private boolean ncaa;
    private boolean firstGen;
    private String gender;
    private String major;
    private double gpa;
    private List<Class> classes = new ArrayList<>();
    //constructor
    public Student(String[] notes, String eduPlan, String college, String careerPath, String ethnicity, boolean regents, boolean ncaa, boolean firstGen, String gender, String major, double gpa) {
        this.notes = notes;
        this.eduPlan = eduPlan;
        this.college = college;
        this.careerPath = careerPath;
        this.ethnicity = ethnicity;
        this.regents = regents;
        this.ncaa = ncaa;
        this.firstGen = firstGen;
        this.gender = gender;
        this.major = major;
        this.gpa = gpa;
    }
    //get and set methods
    public String[] getNotes() {
        return notes;
    }
    public void setNotes(String[] notes) {
        this.notes = notes;
    }
    public String getEduPlan() {
        return eduPlan;
    }
    public void setEduPlan(String eduPlan) {
        this.eduPlan = eduPlan;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getCareerPath() {
        return careerPath;
    }
    public void setCareerPath(String careerPath) {
        this.careerPath = careerPath;
    }
    public String getEthnicity() {
        return ethnicity;
    }
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
    public boolean isRegents() {
        return regents;
    }
    public void setRegents(boolean regents) {
        this.regents = regents;
    }
    public boolean isNcaa() {
        return ncaa;
    }
    public void setNcaa(boolean ncaa) {
        this.ncaa = ncaa;
    }
    public boolean isFirstGen() {
        return firstGen;
    }
    public void setFirstGen(boolean firstGen) {
        this.firstGen = firstGen;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
