package exams.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String dismissStudent(Student student) {
        for (Student currStudent : this.students) {
            if (currStudent.getFirstName().equals(student.getFirstName())) {
                this.students.remove(currStudent);
            } else {
                return "Student not found";
            }
        }
        return null;
    }

    public String registerStudent(Student student) {
        if (this.students.size() > 0) {
            for (Student currStudent : this.students) {
                if (student.getFirstName().equals(currStudent.getFirstName())) {
                    return "Student is already in the exams.exams.university";
                }
            }
            this.students.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        } else
        return "No seats in the exams.exams.university";
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentsCount() {
        return this.students.size();
    }

    public int getCapacity() {
        return this.capacity;
    }
}
