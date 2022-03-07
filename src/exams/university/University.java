package exams.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {
            sb.append("==Student: First Name = ")
                    .append(student.getFirstName())
                    .append(", Last Name = ")
                    .append(student.getLastName())
                    .append(", Best Subject = ")
                    .append(student.getBestSubject())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String dismissStudent(Student student) {
        for (Student currStudent : this.students) {
            if (currStudent.equals(student)) {
                this.students.remove(currStudent);
                this.capacity++;
                return "Removed student " + student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student not found";
    }

    public String registerStudent(Student student) {
        if (this.capacity > 0) {
            for (Student currStudent : this.students) {
                if (student.getFirstName().equals(currStudent.getFirstName())) {
                    return "Student is already in the university";
                }
            }
            this.students.add(student);
            this.capacity--;
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        } else
        return "No seats in the university";
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
