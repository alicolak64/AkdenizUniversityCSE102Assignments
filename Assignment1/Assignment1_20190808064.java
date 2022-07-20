/**
 * @author Ali Çolak
 * 22.03.2021
 */
public class Assignment1_20190808064 {
    
    public static void main(String[] args) {

        Course course = new Course( "CSE" , 102 , "Programming 2" , 6 );
        System.out.println ( course.courseCode() + " - " + course.getTitle() );
        System.out.println(course);

        Teacher teacher = new Teacher ( "Joseph Ledet" , "josephledet@akdeniz.edu.tr" , 123L , "CSE" , 1 );
        System.out.println(teacher);

        Student student = new Student( "Test Student" , "me@somewhere.com" , 456L , "CSE" , 33 );
        System.out.println(student);

        student.passCourse(course);
        System.out.println(student.getAKTS());

        teacher.promote();
        teacher.promote();
        System.out.println("King : "+teacher);
        
    }
    
}

class Course{

    private String department;
    private int number;
    private String title;
    private int AKTS;

    public Course(String department, int number, String title, int AKTS) {
        setDepartment(department);
        setNumber(number);
        this.title = title;
        setAKTS(AKTS);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if ( department.length()==3 || department.length()==4 ){
            this.department = department;
        } else throw new RuntimeException();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if ( ( number>99 && number<500 ) || ( number>4999 && number<6000 ) || ( number>6999 && number<8000 ) ) {
            this.number=number;
        } else throw new RuntimeException();
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
        if (AKTS>0){
            this.AKTS=AKTS;
        } else throw new RuntimeException();
    }

    public String courseCode(){
        return department + " " +number;
    }

    @Override
    public String toString() {
        return department + " " + number + " - " + title + " (" + AKTS + ")" ;
    }
}

class Person{

    private String name;
    private String email;
    private long ID;
    private String department;

    public Person(String name, String email, long ID, String department) {
        this.name = name;
        setEmail(email);
        this.ID = ID;
        setDepartment(department);
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
        if ( email.contains("@") && email.contains(".") ){
            this.email=email;
        } else throw new RuntimeException();
    }

    public long getID() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if ( department.length()==3 || department.length()==4 ){
            this.department = department;
        }  else throw new RuntimeException();
    }

    @Override
    public String toString() {
        return name + " (" + ID + ") - " + email ;
    }
    
}

class Teacher extends Person{
    
    private int rank;

    public Teacher(String name, String email, long ID, String department, int rank) {
        super(name, email, ID, department);
        setRank(rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if ( rank>0 && rank<4 ){
            this.rank=rank;
        } else throw new RuntimeException();
    }
    public String getTitle(){
        if ( rank==1 ){
            return "Assistant Professor";
        }else if (rank==2){
            return "Associate Professor";
        }else {
            return "Professor";
        }
    }

    public void promote(){
        if (rank<3 && rank>=1){
            rank++;
        }  else throw new RuntimeException();
    }

    public void demote(){
        if (rank<=3 && rank>1){
            rank--;
        }  else throw new RuntimeException();
    }

    @Override
    public String toString() {
        return getTitle() +" "+super.toString();
    }

}

class Student extends Person{

    private int AKTS;

    public Student(String name, String email, long ID, String department, int AKTS) {
        super(name, email, ID, department);
        setAKTS(AKTS);
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (AKTS>=0){
            this.AKTS=AKTS;
        }  else throw new RuntimeException();
    }

    public void passCourse(Course course){
        AKTS+=course.getAKTS();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

class GradStudent extends Student{

    private String thesis;

    public GradStudent(String name, String email, long ID, String department, int AKTS, String thesis) {
        super(name, email, ID, department, AKTS);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}