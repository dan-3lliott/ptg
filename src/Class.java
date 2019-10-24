public class Class {
    //variable declaration
    private String name;
    private String classType;
    private int terms;
    private int grade; //grades 9-12 represented by numbers 0-3
    private boolean pass;
    //constructor
    public Class(String name, String classType, int terms, int grade, boolean pass) {
        this.name = name;
        this.classType = classType;
        this.terms = terms;
        this.grade = grade;
        this.pass = pass;
    }
    //get and set methods
    public String getName() {
        return name;
    }
    public String getClassType() {
        return classType;
    }
    public int getTerms() {
        return terms;
    }
    public int getGrade() {
        return grade;
    }
    public boolean isPass() {
        return pass;
    }
    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
