package sky.pro.java.homework26;

public class Department extends Employee {
    private final int departmentId;
    private final double salary;

    public Department(String firstName, String lastName, int departmentId, double salary) {
        super(firstName, lastName);
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "departmentId=" + departmentId +
                ", salary=" + salary +
                "} ";
    }
}
