import java.util.Arrays;

public class CopyArray {
    public static void useSystemArraycopy() {
        System.out.println("\n>>> Using System.arraycopy");

        // deep copy for primitive object types
        int[] arrOld1 = {23, 43, 55};
        int[] arrCopied1 = new int[arrOld1.length];
        System.arraycopy(arrOld1, 0, arrCopied1, 0, 3);
        arrOld1[0] = 10;
        System.out.printf("The 1st element of old array is %s\n", arrOld1[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied1[0]);

        String[] arrOld2 = {"Brian", "Effie", "Emily", "Jessie"};
        String[] arrCopied2 = Arrays.copyOf(arrOld2, arrOld2.length);
        System.arraycopy(arrOld2, 0, arrCopied2, 0, 2);
        arrOld2[0] = "BrianSu";
        System.out.printf("The 1st element of old array is %s\n", arrOld2[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied2[0]);

        // shallow copy for non-primitive object types
        Employee[] employees1 = new Employee[3];
        employees1[0] = new Employee("Brian", "M");
        employees1[1] = new Employee("Effie", "F");
        employees1[2] = new Employee("Emily", "F");
        Employee[] copiedemployees1 = new Employee[employees1.length];
        System.arraycopy(employees1, 0, copiedemployees1, 0, employees1.length);
        employees1[0].setName(employees1[0].getName() + "_Changed");
        System.out.printf("The 1st employee's name of old array is %s\n", employees1[0].name);
        System.out.printf("The 1st employee's name of new array is %s\n", copiedemployees1[0].name);
    }

    public static void useArraysCopyOf() {
        System.out.println("\n>>> Using Arrays.copyOf");

        // deep copy for primitive object types
        int[] arrOld2 = {23, 43, 55, 12};
        int[] arrCopied2 = Arrays.copyOf(arrOld2, arrOld2.length);
        arrOld2[0] = 11;
        System.out.printf("The 1st element of old array is %s\n", arrOld2[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied2[0]);

        String[] arrOld3 = {"Brian", "Effie", "Emily", "Jessie"};
        String[] arrCopied3 = Arrays.copyOf(arrOld3, arrOld3.length);
        arrOld3[0] = "BrianSu";
        System.out.printf("The 1st element of old array is %s\n", arrOld3[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied3[0]);

        // shallow copy for non-primitive object types
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Brian", "M");
        employees[1] = new Employee("Effie", "F");
        employees[2] = new Employee("Emily", "F");
        Employee[] copiedEmployees = Arrays.copyOf(employees, employees.length);
        employees[0].setName(employees[0].getName() + "_Changed");
        System.out.printf("The 1st employee's name of old array is %s\n", employees[0].name);
        System.out.printf("The 1st employee's name of new array is %s\n", copiedEmployees[0].name);
    }

    public static void useObjectClone() {
        System.out.println("\n>>> Using Object.clone");

        // deep copy for primitive object types
        int[] arrOld2 = {23, 43, 55, 12};
        int[] arrCopied2 = arrOld2.clone();
        arrOld2[0] = 18;
        System.out.printf("The 1st element of old array is %s\n", arrOld2[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied2[0]);

        String[] strArray = {"orange", "red", "green'"};
        String[] copiedArray = strArray.clone();
        strArray[0] = "watermelon";
        System.out.printf("The 1st element of old array is %s\n", strArray[0]);
        System.out.printf("The 1st element of new array is %s\n", copiedArray[0]);

        // shallow copy for non-primitive object types
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Brian", "M");
        employees[1] = new Employee("Effie", "F");
        employees[2] = new Employee("Emily", "F");
        Employee[] copiedEmployees = employees.clone();
        employees[0].setName(employees[0].getName() + "_Changed");
        System.out.printf("The 1st employee's name of old array is %s\n", employees[0].name);
        System.out.printf("The 1st employee's name of new array is %s\n", copiedEmployees[0].name);
    }

    public static void useArraysStream() {
        System.out.println("\n>>> Using Arrays.stream");

        // deep copy
        int[] arrOld2 = {23, 43, 55, 12};
        int[] arrCopied2 = Arrays.stream(arrOld2).toArray();
        arrOld2[0] = 12;
        System.out.printf("The 1st element of old array is %s\n", arrOld2[0]);
        System.out.printf("The 1st element of new array is %s\n", arrCopied2[0]);

        String[] strArray = {"orange", "red", "green'"};
        String[] copiedArray = Arrays.stream(strArray).toArray(String[]::new);
        strArray[0] = "watermelon";
        System.out.printf("The 1st element of old array is %s\n", strArray[0]);
        System.out.printf("The 1st element of new array is %s\n", copiedArray[0]);

        // shallow copy for non-primitive object types
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Brian", "M");
        employees[1] = new Employee("Effie", "F");
        employees[2] = new Employee("Emily", "F");
        Employee[] copiedEmployees = Arrays.stream(employees).toArray(Employee[]::new);
        employees[0].setName(employees[0].getName() + "_Changed");
        System.out.printf("The 1st employee's name of old array is %s\n", employees[0].name);
        System.out.printf("The 1st employee's name of new array is %s\n", copiedEmployees[0].name);
    }

    public static void main(String[] args) {
        useSystemArraycopy();
        
        useArraysCopyOf();

        useObjectClone();

        useArraysStream();
    }
}


class Employee {
    String name;
    String gender;

    public Employee(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
