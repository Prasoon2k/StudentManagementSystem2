import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(
            "ID: " + id +
            " | Name: " + name +
            " | Marks: " + marks
        );
    }
}

public class StudentManagementSystem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Students");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Average Marks");
            System.out.println("7. Highest Marks");
            System.out.println("8. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                // 1. ADD STUDENTS
                case 1:

                    System.out.print("Enter number of students: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {

                        System.out.println();
                        System.out.println("Enter details of Student " + (i + 1));

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        Student s = new Student(id, name, marks);

                        students.add(s);

                        System.out.println("Student added successfully!");
                    }

                    break;


                // 2. DISPLAY STUDENTS
                case 2:

                    System.out.println();
                    System.out.println("========== STUDENT DETAILS ==========");

                    if (students.isEmpty()) {

                        System.out.println("No students available.");

                    } else {

                        for (Student s : students) {
                            s.display();
                        }
                    }

                    break;


                // 3. SEARCH STUDENT
                case 3:

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.id == searchId) {

                            System.out.println();
                            System.out.println("Student Found!");

                            s.display();

                            found = true;

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;


                // 4. DELETE STUDENT
                case 4:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {

                        if (students.get(i).id == deleteId) {

                            students.remove(i);

                            System.out.println(
                                "Student deleted successfully!"
                            );

                            deleted = true;

                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found.");
                    }

                    break;


                // 5. UPDATE STUDENT
                case 5:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student s : students) {

                        if (s.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new marks: ");
                            double newMarks = sc.nextDouble();

                            s.name = newName;
                            s.marks = newMarks;

                            System.out.println(
                                "Student updated successfully!"
                            );

                            updated = true;

                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }

                    break;


                // 6. AVERAGE MARKS
                case 6:

                    if (students.isEmpty()) {

                        System.out.println("No students available.");

                    } else {

                        double total = 0;

                        for (Student s : students) {

                            total = total + s.marks;
                        }

                        double average =
                            total / students.size();

                        System.out.println(
                            "Average Marks: " + average
                        );
                    }

                    break;


                // 7. HIGHEST MARKS
                case 7:

                    if (students.isEmpty()) {

                        System.out.println("No students available.");

                    } else {

                        Student highest = students.get(0);

                        for (Student s : students) {

                            if (s.marks > highest.marks) {

                                highest = s;
                            }
                        }

                        System.out.println();
                        System.out.println("========== HIGHEST MARKS ==========");

                        highest.display();
                    }

                    break;


                // 8. EXIT
                case 8:

                    System.out.println("Exiting Student Management System...");

                    sc.close();

                    return;


                // INVALID CHOICE
                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}