import java.util.ArrayList;

/**
 * @author Ali Çolak
 * 3.04.2021
 */
public class Assignment2_20190808064 {

    public static void main(String[] args) {


        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        Department d3 = new Department("MAT", "Matematik Fakultesi");
        Department d4 = new Department("TDB", "Edebiyat Fakultesi");


        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", 124L, d2, 3);
        Teacher t3 = new Teacher("Mehmet Galip Zorba", "mehmetgalipzorba@akdeniz.edu.tr", 125L, d, 2);
        Teacher t4 = new Teacher("Melih Günay", "melihgunay@akdeniz.edu.tr", 126L, d, 4);
        Teacher t5 = new Teacher("Ayşe Yılmaz Ceylan", "ayseyılmazceylan@akdeniz.edu.tr", 127L, d3, 3);
        Teacher t6 = new Teacher("Taha Yiğit Alkan", "tahayigitalkan@akdeniz.edu.tr", 128L, d, 1);
        Teacher t7 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Teacher t8 = new Teacher("Türk Dili Hocası", "tdhocası@akdeniz.edu.tr", 129L, d4, 2);
        System.out.println(t);
        System.out.println(t2);
        System.out.println(t3);
        d.setChair(t4);
        d2.setChair(t2);
        d3.setChair(t5);
        d4.setChair(t8);
        System.out.println(d.getChair());
        System.out.println(d2.getChair());
        System.out.println(d3.getChair());
        System.out.println(d4.getChair());
        System.out.println(t4.getDepartment().getName());
        System.out.println(d.getChair());

        System.out.println("*********");
        d.setChair(t7);
        System.out.println(t4.getDepartment().getName());
        System.out.println(d.getChair());
        System.out.println("******");


        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t7);
        Course c3 = new Course(d, 101, "Programming Lab", 2, t6);
        Course c4 = new Course(d2, 107, "Physics", 5, t2);
        Course c5 = new Course(d3, 163, "Mathematics", 6, t5);
        Course c6 = new Course(d, 181, "Natural Science", 5, t4);
        Course c7 = new Course(d, 183, "English Writing Skills", 4, t3);
        Course c8 = new Course(d4, 101, "Türk Dili Edebiyatı", 2, t8);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c1.courseCode());
        System.out.println(c1.getTeacher());


        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        Student s2 = new Student("Sefa Altun", "sefaaltun@akdeniz.edu.tr", 457L, d);
        s.addCourse(c1, 76);
        s.addCourse(c2, 91);
        s.addCourse(c3, 75);
        s.addCourse(c4, 75);
        s.addCourse(c5, 91);
        s.addCourse(c6, 59);
        s.addCourse(c7, 72);
        s.addCourse(c8, 91);
        System.out.println(s.getGPA());
        System.out.println(s.courseGPAPoints(c1));
        System.out.println(s.courseGradeLetter(c1));
        System.out.println(s.courseResult(c1));
        s.addCourse(c1, 95);
        System.out.println(s.courseResult(c1));
        System.out.println(s.getGPA());





    }

}

class Department {

    private String ID;
    private String name;
    private Teacher chair;

    public Department(String ID, String name) {
        setID(ID);
        this.name = name;
        this.chair = null;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if (ID.length() == 3 || ID.length() == 4) {
            this.ID = ID;
        } else {
            throw new InvalidIDException(ID);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getChair() {
        return chair;
    }

    public void setChair(Teacher chair) {
        if (chair == null) {
            this.chair = null;
        } else if (chair.getDepartment().equals(this)) {
            this.chair = chair;
        } else throw new DepartmentMismatchException(this, chair);
    }
}

class Course {

    private Department department;
    private Teacher teacher;
    private int number;
    private String title;
    private int AKTS;

    public Course(Department department, int number, String title, int AKTS, Teacher teacher) {

        this.department = department;
        this.teacher = teacher;
        setNumber(number);
        this.title = title;
        setAKTS(AKTS);
        setTeacher(teacher);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.getDepartment().equals(department)) {
            this.teacher = teacher;
        } else throw new DepartmentMismatchException(this, teacher);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if ((number > 99 && number < 500) || (number > 4999 && number < 6000) || (number > 6999 && number < 8000)) {
            this.number = number;
        } else throw new InvalidNumberException(number);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (AKTS > 0) {
            this.AKTS = AKTS;
        } else throw new InvalidAKTSException(AKTS);
    }

    public String courseCode() {
        return department.getID() + " " + number;
    }

    @Override
    public String toString() {
        return department.getID() + " " + number + " - " + title + " (" + AKTS + ")";
    }
}

abstract class Person {

    private Department department;
    private String name;
    private String email;
    private long ID;

    public Person(String name, String email, long ID, Department department) {
        this.department = department;
        this.name = name;
        setEmail(email);
        this.ID = ID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else throw new InvalidEmailException(email);
    }

    public long getID() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return name + " (" + ID + ") - " + email;
    }
}

class Teacher extends Person {

    private int rank;

    public Teacher(String name, String email, long ID, Department department, int rank) {
        super(name, email, ID, department);
        if (rank > 0 && rank <= 4) {
            this.rank = rank;
        } else {
            throw new InvalidRankException(rank);
        }
    }

    public int getRank() {
        return rank;
    }

    @Override
    public void setDepartment(Department department) {
        if (this.getDepartment().getChair() == this) {
            this.getDepartment().setChair(null);
        }
        super.setDepartment(department);
    }

    public void promote() {
        if (rank < 4 && rank >= 1) {
            rank++;
        } else throw new InvalidRankException(rank);
    }

    public void demote() {
        if (rank <= 4 && rank > 1) {
            rank--;
        } else throw new InvalidRankException(rank);
    }

    public String getTitle() {
        if (rank == 1) {
            return "Lecturer";
        } else if (rank == 2) {
            return "Assistant Professor";
        } else if (rank == 3) {
            return "Associate Professor";
        } else {
            return "Professor";
        }
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {

    private ArrayList<Course> courses;
    private ArrayList<Double> grades;


    public Student(String name, String email, long ID, Department department) {
        super(name, email, ID, department);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getAKTS() {
        int passedAKTS = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (grades.get(i) >= 60) {
                passedAKTS += courses.get(i).getAKTS();
            }
        }
        return passedAKTS;
    }

    public int getAttemptedAKTS() {
        int attemptedAKTS = 0;
        for (Course cours : courses) {
            attemptedAKTS += cours.getAKTS();
        }
        return attemptedAKTS;
    }

    public void addCourse(Course course, double grade) {

        if (grade >= 0 && grade <= 100) {
            if (courses.contains(course)) {

                int index = courses.indexOf(course);
                grades.set(index, grade);

            } else {
                courses.add(course);
                grades.add(grade);
            }
        } else throw new InvalidGradeException(grade);
    }

    public double courseGPAPoints(Course course) {
        if (courses.contains(course)) {
            int index = courses.indexOf(course);
            double grade = grades.get(index);
            if (grade < 35) return 0.0;
            else if (grade < 46) return 0.5;
            else if (grade < 53) return 1.0;
            else if (grade < 60) return 1.5;
            else if (grade < 67) return 2.0;
            else if (grade < 74) return 2.5;
            else if (grade < 81) return 3.0;
            else if (grade < 88) return 3.5;
            else return 4.0;
        } else throw new CourseNotFoundException(this, course);

    }

    public String courseGradeLetter(Course course) {
        if (courses.contains(course)) {
            int index = courses.indexOf(course);
            double grade = grades.get(index);
            if (grade < 35) return "FF";
            else if (grade < 46) return "FD";
            else if (grade < 53) return "DD";
            else if (grade < 60) return "DC";
            else if (grade < 67) return "CC";
            else if (grade < 74) return "CB";
            else if (grade < 81) return "BB";
            else if (grade < 88) return "BA";
            else return "AA";
        } else throw new CourseNotFoundException(this, course);

    }

    public String courseResult(Course course) {
        if (courses.contains(course)) {
            int index = courses.indexOf(course);
            double grade = grades.get(index);
            if (grade < 46) return "Failed";
            else if (grade < 60) return "Conditionally Passed";
            else return "Passed";
        } else throw new CourseNotFoundException(this, course);

    }

    public double getGPA() {
        double GPA = 0;
        for (Course course : courses) {
            GPA += course.getAKTS() * courseGPAPoints(course);
        }
        return GPA / getAttemptedAKTS();
    }

    @Override
    public String toString() {
        return super.toString() + " -GPA: " + getGPA();
    }
}

class GradStudent extends Student {

    private String thesis;

    public GradStudent(String name, String email, long ID, Department department, String thesis) {
        super(name, email, ID, department);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public double courseGPAPoints(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
            if (grade < 70) return 1.5;
            else if (grade < 75) return 2.0;
            else if (grade < 80) return 2.5;
            else if (grade < 85) return 3.0;
            else if (grade < 90) return 3.5;
            else return 4.0;
        } else throw new CourseNotFoundException(this, course);
    }

    @Override
    public String courseGradeLetter(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
            if (grade < 70) return "DC";
            else if (grade < 75) return "CC";
            else if (grade < 80) return "CB";
            else if (grade < 85) return "BB";
            else if (grade < 90) return "BA";
            else return "AA";
        } else throw new CourseNotFoundException(this, course);
    }

    @Override
    public String courseResult(Course course) {
        if (getCourses().contains(course)) {
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
            if (grade < 70) return "Failed";
            else return "Passed";
        } else throw new CourseNotFoundException(this, course);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

class CourseNotFoundException extends RuntimeException {

    private Student student;
    private Course course;

    public CourseNotFoundException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " + student.getID() + " has not yet taken " + course.courseCode();
    }
}

class DepartmentMismatchException extends RuntimeException {

    private Department department;
    private Teacher person;
    private Course course;

    public DepartmentMismatchException(Course course, Teacher person) {
        this.person = person;
        this.course = course;
        this.department = null;
    }

    public DepartmentMismatchException(Department department, Teacher person) {
        this.department = department;
        this.person = person;
        this.course = null;
    }

    @Override
    public String toString() {
        if (course == null) {
            return "DepartmentMismatchException: " + person.getName() + "(" + person.getID() + ") cannot be chair of " +
                    department.getID() + " because he/she is currently assigned to " + person.getDepartment().getID();
        } else {
            return "DepartmentMismatchException: " + person.getName() + "(" + person.getID() + ") cannot teach " +
                    course.courseCode() + " because he/she is currently assigned to " + person.getDepartment().getID();
        }
    }
}

class InvalidGradeException extends RuntimeException {

    private double grade;

    public InvalidGradeException(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "InvalidGradeException: " + grade;
    }
}

class InvalidRankException extends RuntimeException {

    private int rank;

    public InvalidRankException(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "InvalidRankException:" + rank;
    }
}

class InvalidEmailException extends RuntimeException {

    private String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "InvalidEmailException: Person.email - attempted to assign " + email + " to a String that must have the format {text}@{text}.{text}";
    }
}

class InvalidIDException extends RuntimeException {

    private String ID;

    public InvalidIDException(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "InvalidIDException: Department.ID - attempted to assign " + ID + " to ID must be 3 or 4 characters";
    }
}

class InvalidNumberException extends RuntimeException {

    private int number;

    public InvalidNumberException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "InvalidNumberException: Course.number - attempted to asssign " + number + " to number must be in the range 100-499 or 5000-5999 or 7000-7999";
    }
}

class InvalidAKTSException extends RuntimeException {

    private int AKTS;

    public InvalidAKTSException(int AKTS) {
        this.AKTS = AKTS;
    }

    @Override
    public String toString() {
        return "InvalidAKTSException : Course.AKTS - attempted to assign " + AKTS + " to AKTS must be positive";
    }
}