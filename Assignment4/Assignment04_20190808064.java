import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ali Çolak
 * 22.05.2021
 */
public class Assignment04_20190808064 {

    public static void main(String[] args) {



        Semester s1= new Semester(1,2020);
        Semester s2= new Semester(2,2021);
        Semester s3= new Semester(3,2021);
        Semester s4= new Semester(1,2022);
        Semester s5= new Semester(2,2023);
        Semester s6= new Semester(3,2023);

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


        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t7);
        Course c3 = new Course(d, 102, "Programming Lab", 2, t6);
        Course c4 = new Course(d2, 107, "Physics", 5, t2);
        Course c5 = new Course(d3, 163, "Mathematics", 6, t5);
        Course c6 = new Course(d, 181, "Natural Science", 5, t4);
        Course c7 = new Course(d, 183, "English Writing Skills", 4, t3);
        Course c8 = new Course(d4, 101, "Türk Dili Edebiyatı", 2, t8);

        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);

        s.addCourse(c1,s6,60);
        s.addCourse(c2,s6,50);
        s.addCourse(c3,s1,60);
        s.addCourse(c4,s5,70);
        s.addCourse(c5,s3,70);
        s.addCourse(c6,s1,90);
        s.addCourse(c7,s3,30);
        s.addCourse(c3,s2,70);
        s.addCourse(c3,s3,80);
        s.addCourse(c3,s4,90);
        s.addCourse(c8,s6,68);
        System.out.println(s.listGrades(c3));

        System.out.println(s.transcript());

        /*




        Department cse = new Department("CSE","Computer Engineering");
        Teacher teacher = new Teacher("jwl","jwl@akdeniz.tr",123L,cse,3);
        System.out.println(teacher);
        Student s= new Student("Ali","ali@akdeniz.tr",456L,cse);
        Semester s1=new Semester(1,2020);
        Course c101= new Course(cse,101,"Programming 1",6,teacher);
        Semester s2=new Semester(2,2021);
        Course c102 = new Course(cse,102,"Programming 2",4,teacher);
        Course c204 = new Course(cse,204,"Database Systems",6,teacher);

        s.addCourse(c101,s1,80);
        s.addCourse(c102,s2,30);
        s.addCourse(c204,s2,70);
        s.addCourse(c101,s2,70);
        System.out.println("List Grades for CSE 101:\n" + s.listGrades(c101));
        System.out.println("List Grades for Spring 2021:\n" + s.listGrades(s2));
        System.out.println("Student Transcript:\n" + s.transcript());


         */

        /*

        Department department = new Department("CSE", "Computer Programming");
        Teacher teacher = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 456L, department, 3);
        System.out.println(teacher);
        Student student = new Student("Assignment 4 STUDENT", "me@somewhere.com", 456L, department);
        Semester s1 = new Semester(1, 2020);
        Course course1 = new Course(department, 101, "Programming 1", 6, teacher);
        Semester s2 = new Semester(2, 2021);
        Semester s3 = new Semester(2, 2022);
        Semester s4 = new Semester(1, 2022);
        Course course2 = new Course(department, 102, "Programming 2", 4, teacher);
        Course course3 = new Course(department, 204, "Data Base Systems", 6, teacher);
        Course course4 = new Course(department, 105, "Data Base Systems", 6, teacher);
        Course course5 = new Course(department, 106, "Data Base Systems", 6, teacher);
        Course course6 = new Course(department, 107, "Data Base Systems", 6, teacher);

        student.addCourse(course1, s1, 80);
        student.addCourse(course2, s2, 30);
        student.addCourse(course2, s1, 30);
        System.out.println(student.getAttemptedAKTS());
        student.addCourse(course3, s2, 70);
        student.addCourse(course4,s3,70);
        student.addCourse(course5,s1,70);
        student.addCourse(course6,s4,70);
        System.out.println("List Grades for CSE 101:\n" + student.listGrades(course1));
        System.out.println("List Grades for Spring 2021:\n" + student.listGrades(s2));
        System.out.println("Student Transcript:\n" + student.transcript());

        GradStudent gs = new GradStudent("Assignment 4 GRADSTUDENT",
                "me@somewhere.com", 789L, department, "MDE");
        gs.addCourse(course1, s1, 85);
        gs.addCourse(course2, s1, 40);
        gs.setTeachingAssistant(course1);
        System.out.println("Teaching Assistant:\n" + gs.getTeachingAssistant());
        gs.setTeachingAssistant(course2);
        System.out.println("Teaching Assistant:\n" + gs.getTeachingAssistant());
        System.out.println(student.transcript());

         */




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
        if (rank > 0 && rank <= 5) {
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
            return "Adjunct Instructor";
        } else if (rank == 2) {
            return "Lecturer";
        } else if (rank == 3) {
            return "Assistant Professor";
        } else if (rank == 4) {
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
    private ArrayList<Semester> semesters;
    private ArrayList<Course> repeatCourses ;
    private ArrayList<Double> repeatGrades ;
    private ArrayList<Semester> repeatSemesters;


    public Student(String name, String email, long ID, Department department) {
        super(name, email, ID, department);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
        semesters = new ArrayList<>();
        repeatCourses = new ArrayList<>();
        repeatGrades = new ArrayList<>();
        repeatSemesters = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
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
        for (Course course : courses) {
            attemptedAKTS += course.getAKTS();
        }
        return attemptedAKTS;
    }

    public void addCourse(Course course, Semester semester, double grade) {

        if (grade >= 0 && grade <= 100) {
            if (courses.contains(course)) {

                int index = courses.indexOf(course);

                if ((semesters.get(index).getYear() < semester.getYear() ||
                        (semesters.get(index).getYear() == semester.getYear() && semesters.get(index).getSeasonNumber() < semester.getSeasonNumber()))
                        && (grades.get(index) <= grade)) {

                    Course tempCourse = courses.get(index);
                    double tempGrade = grades.get(index);
                    Semester tempSemester = semesters.get(index);

                    repeatCourses.add(tempCourse);
                    repeatGrades.add(tempGrade);
                    repeatSemesters.add(tempSemester);

                    grades.set(index,grade);
                    semesters.set(index,semester);

                } else if ((semesters.get(index).getYear() < semester.getYear() ||
                        (semesters.get(index).getYear() == semester.getYear() && semesters.get(index).getSeasonNumber() < semester.getSeasonNumber()))
                        && (grades.get(index) > grade)) {

                    repeatCourses.add(course);
                    repeatGrades.add(grade);
                    repeatSemesters.add(semester);

                }
            } else {
                courses.add(course);
                grades.add(grade);
                semesters.add(semester);
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

    public String listGrades (Semester semester) {

        if (semesters.contains(semester)) {
            ArrayList<Course> semesterCourses = new ArrayList<>();
            ArrayList<Double> semesterGrades = new ArrayList<>();
            ArrayList<Course> repeatSemesterCourses = new ArrayList<>();
            ArrayList<Double> repeatSemesterGrades = new ArrayList<>();

            for (int i = 0; i < courses.size(); i++) {
                if (semesters.get(i).equals(semester)) {
                    semesterCourses.add(courses.get(i));
                    semesterGrades.add(grades.get(i));
                }
            }

            for (int i = 0; i < repeatCourses.size(); i++) {
                if (repeatSemesters.get(i).equals(semester)) {
                    repeatSemesterCourses.add(repeatCourses.get(i));
                    repeatSemesterGrades.add(repeatGrades.get(i));
                }
            }

            String s = "";
            int i = 1;
            for (Course course:semesterCourses) {
                if (i<semesterCourses.size() || repeatSemesterCourses.size()>0){
                    s += course.courseCode()+" - "+courseGradeLetter(course)+"\n";
                    i++;
                } else {
                    s += course.courseCode()+" - "+courseGradeLetter(course) ;
                    i++;
                }
            }

            int j = 1;
            for (int k = 0; k < repeatSemesterCourses.size(); k++) {
                Course course = repeatSemesterCourses.get(k);
                double grade = repeatSemesterGrades.get(k);
                String gradeLetter;
                if (grade < 35) gradeLetter = "FF";
                else if (grade < 46) gradeLetter = "FD";
                else if (grade < 53) gradeLetter = "DD";
                else if (grade < 60) gradeLetter = "DC";
                else if (grade < 67) gradeLetter = "CC";
                else if (grade < 74) gradeLetter = "CB";
                else if (grade < 81) gradeLetter = "BB";
                else if (grade < 88) gradeLetter = "BA";
                else gradeLetter = "AA";

                if (j<repeatSemesterCourses.size()){
                    s += course.courseCode()+" - "+gradeLetter+"\n";
                    j++;
                } else {
                    s += course.courseCode()+" - "+gradeLetter ;
                    j++;
                }

            }

            return s;
        } else throw new SemesterNotFoundException(this,semester);

    }

    public String listGrades (Course course) {
        if (courses.contains(course)) {
            int index = courses.indexOf(course);
            String s= "";
            for (int i = 0; i < repeatCourses.size(); i++) {
                if (repeatCourses.get(i).equals(course)) {
                    double grade = repeatGrades.get(i);
                    String gradeLetter;
                    if (grade < 35) gradeLetter = "FF";
                    else if (grade < 46) gradeLetter = "FD";
                    else if (grade < 53) gradeLetter = "DD";
                    else if (grade < 60) gradeLetter = "DC";
                    else if (grade < 67) gradeLetter = "CC";
                    else if (grade < 74) gradeLetter = "CB";
                    else if (grade < 81) gradeLetter = "BB";
                    else if (grade < 88) gradeLetter = "BA";
                    else gradeLetter = "AA";
                    s+=repeatSemesters.get(i)+" - "+ gradeLetter+"\n";

                }
            }
            s+=semesters.get(index)+" - "+courseGradeLetter(course);

            return s;
        } else throw new CourseNotFoundException(this,course);
    }

    public String transcript() {

        String s ="";

        ArrayList<Semester> tempSemesters = new ArrayList<>();
        for (Semester semester:semesters) {
            if (!tempSemesters.contains(semester)) {
                tempSemesters.add(semester);
            }

        }
        for (Semester semester:repeatSemesters) {
            if (!tempSemesters.contains(semester)) {
                tempSemesters.add(semester);
            }

        }
        Collections.sort(tempSemesters, new Comparator<Semester>() {
            @Override
            public int compare(Semester o1, Semester o2) {
                if (o1.getYear()<o2.getYear() || (o1.getYear()==o2.getYear() && o1.getSeasonNumber()<o2.getSeasonNumber())) {
                    return -1;
                } else if (o1.getYear() > o2.getYear() || (o1.getYear()==o2.getYear() && o1.getSeasonNumber() > o2.getSeasonNumber())) {
                    return 1;
                } else return 0 ;
            }
        });


        for (Semester semester:tempSemesters) {
            ArrayList<Course> semesterCourses = new ArrayList<>();
            ArrayList<Double> semesterGrades = new ArrayList<>();
            ArrayList<Course> repeatSemesterCourses = new ArrayList<>();
            ArrayList<Double> repeatSemesterGrades = new ArrayList<>();
            double semesterGPA = 0;
            int semesterAKTS = 0;
            s+=semester+"\n";
            for (int i = 0; i < courses.size(); i++) {
                if (semesters.get(i).equals(semester)) {
                    s+="   "+ courses.get(i).courseCode()+" - "+courseGradeLetter(courses.get(i))+"\n";
                    semesterCourses.add(courses.get(i));
                    semesterGrades.add(grades.get(i));
                }
            }
            for (int i = 0; i < repeatCourses.size(); i++) {
                if (repeatSemesters.get(i).equals(semester)) {
                    double grade = repeatGrades.get(i);
                    String gradeLetter;
                    if (grade < 35) gradeLetter = "FF";
                    else if (grade < 46) gradeLetter = "FD";
                    else if (grade < 53) gradeLetter = "DD";
                    else if (grade < 60) gradeLetter = "DC";
                    else if (grade < 67) gradeLetter = "CC";
                    else if (grade < 74) gradeLetter = "CB";
                    else if (grade < 81) gradeLetter = "BB";
                    else if (grade < 88) gradeLetter = "BA";
                    else gradeLetter = "AA";
                    s+="   "+ repeatCourses.get(i).courseCode()+" - "+gradeLetter+"\n";
                    repeatSemesterCourses.add(repeatCourses.get(i));
                    repeatSemesterGrades.add(repeatGrades.get(i));
                }
            }

            for (Course course : semesterCourses) {
                semesterGPA += course.getAKTS() * courseGPAPoints(course);
                semesterAKTS += course.getAKTS();
            }

            for (int i = 0; i < repeatSemesterCourses.size(); i++) {
                Course course = repeatSemesterCourses.get(i);
                double grade = repeatSemesterGrades.get(i);
                double gpa;
                if (grade < 35) gpa =  0.0;
                else if (grade < 46) gpa =  0.5;
                else if (grade < 53) gpa =  1.0;
                else if (grade < 60) gpa =  1.5;
                else if (grade < 67) gpa =  2.0;
                else if (grade < 74) gpa =  2.5;
                else if (grade < 81) gpa =  3.0;
                else if (grade < 88) gpa =  3.5;
                else gpa =  4.0;
                semesterGPA += course.getAKTS() * gpa;
                semesterAKTS += course.getAKTS();
            }

            semesterGPA = semesterGPA / semesterAKTS;
            s+="GPA: - "+semesterGPA+"\n\n";
        }
        s+="Overall GPA: "+getGPA();
        return s;
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
    private Course teachingCourse;

    public GradStudent(String name, String email, long ID, Department department, String thesis) {
        super(name, email, ID, department);
        this.thesis = thesis;
        this.teachingCourse = null ;
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
            if (grade < 70) return 0.0;
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
            if (grade < 70) return "FF";
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

    public void setTeachingAssistant (Course course) {
        if (getCourses().contains(course)){
            int index = getCourses().indexOf(course);
            double grade = getGrades().get(index);
            if (grade >= 80){
                teachingCourse = course;
            } else throw new CourseNotFoundException(this,course);
        } else throw new CourseNotFoundException(this,course);

    }

    public Course getTeachingAssistant() {
        return teachingCourse;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

class Semester {

    private int year;
    private int season;

    public Semester(int season, int year) {
        this.season = season;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getSeasonNumber() {
        return season;
    }

    public String getSeason() {
        if (season == 1) {
            return "Fall";
        } else if (season == 2) {
            return "Spring";
        } else {
            return "Summer";
        }
    }

    @Override
    public String toString() {
        return getSeason() + " – " + year;
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

class SemesterNotFoundException extends RuntimeException {
    private Student student;
    private Semester semester;

    public SemesterNotFoundException(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterNotFoundException: " + student.getID() + " has not taken any courses in " + semester ;
    }
}