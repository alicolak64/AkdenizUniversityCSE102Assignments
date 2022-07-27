import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Assert;

/**
 * @author Ali Çolak
 * 4.05.2021
 */
public class Assignment03Tests_20190808064 {


    @Test
    public void departmentConstructorTest1(){
        Department department =new Department("CSE", "Computer Engineering");
        Assert.assertEquals("CSE",department.getID());
    }

    @Test
    public void departmentConstructorTest2(){
        Department department =new Department("CSE", "Computer Engineering");
        Assert.assertEquals("Computer Engineering",department.getName());
    }

    @Test
    public void departmentInvalidIdTest(){
        try {
            Department department =new Department("CSE12", "Computer Engineering");
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }

    }

    @Test
    public void departmentSetIdTest (){
        Department department =new Department("CSE", "Computer Engineering");
        department.setID("CSE2");
        Assert.assertEquals("CSE2",department.getID());
    }

    @Test
    public void departmentSetNameTest (){
        Department department =new Department("CSE", "Computer Engineering");
        department.setName("Computer Engineering2");
        Assert.assertEquals("Computer Engineering2",department.getName());
    }

    @Test
    public void departmentSetChairTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        department.setChair(t);
        Assert.assertEquals(t,department.getChair());
    }

    @Test
    public void departmentNullChairTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        department.setChair(t);
        t.setDepartment(department2);
        assertNull(department.getChair());
    }

    @Test
    public void departmentMismatchExceptionTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        try {
            department2.setChair(t);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("DepartmentMismatchException: Joseph Ledet(123) cannot be chair of FİZ because he/she is currently assigned to CSE",e.toString());
        }
    }

    @Test
    public void departmentMismatchExceptionTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department2, 2);
        try {
            department.setChair(t);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof DepartmentMismatchException);
        }
    }

    @Test
    public void courseConstructorTest1 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals(department,c1.getDepartment());
    }

    @Test
    public void courseConstructorTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals(t,c1.getTeacher());
    }

    @Test
    public void courseConstructorTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals(101,c1.getNumber());
    }

    @Test
    public void courseConstructorTest4 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals("Programming 1",c1.getTitle());
    }

    @Test
    public void courseConstructorTest5 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals(4,c1.getAKTS());
    }

    @Test
    public void courseSetDepartmentTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        t.setDepartment(department2);
        c1.setDepartment(department2);
        Assert.assertEquals(department2,c1.getDepartment());
    }

    @Test
    public void courseSetTeacherTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Taha Yiğit Alkan", "tahayigitalkan@akdeniz.edu.tr", 128L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        c1.setTeacher(t2);
        Assert.assertEquals(t2,c1.getTeacher());
    }

    @Test
    public void courseSetNumberTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        c1.setNumber(102);
        Assert.assertEquals(102,c1.getNumber());
    }

    @Test
    public void courseSetTitleTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        c1.setTitle("Programming 2");
        Assert.assertEquals("Programming 2",c1.getTitle());
    }

    @Test
    public void courseSetAKTSTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        c1.setAKTS(6);
        Assert.assertEquals(6,c1.getAKTS());
    }

    @Test
    public void courseCourseCodeTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals("CSE 101",c1.courseCode());
    }

    @Test
    public void courseToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        Assert.assertEquals("CSE 101 - Programming 1 (4)",c1.toString());
    }

    @Test
    public void courseDepartmentMismatchExceptionTest1 () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Taha Yiğit Alkan", "tahayigitalkan@akdeniz.edu.tr", 128L, department2, 1);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        try {
            c1.setTeacher(t2);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof DepartmentMismatchException);
        }
    }

    @Test
    public void courseDepartmentMismatchExceptionTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Taha Yiğit Alkan", "tahayigitalkan@akdeniz.edu.tr", 128L, department2, 1);
        Course c1 = new Course(department, 101, "Programming 1", 4, t);
        try {
            c1.setTeacher(t2);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("DepartmentMismatchException: Taha Yiğit Alkan(128) cannot teach CSE 101 because he/she is currently assigned to FİZ",e.toString());
        }
    }

    @Test
    public void courseInvalidNumberTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        try {
            Course c1 = new Course(department, 501, "Programming 1", 4, t);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    public void courseInvalidAKTSTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        try {
            Course c1 = new Course(department, 101, "Programming 1", 0, t);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    public void personConstructorTest1 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("Joseph Ledet",p.getName());
        Assert.assertEquals("Joseph Ledet",p.getName());
    }

    @Test
    public void personConstructorTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("josephledet@akdeniz.edu.tr",p.getEmail());
    }

    @Test
    public void personConstructorTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals(123L,p.getID());
    }

    @Test
    public void personConstructorTest4 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals(department,p.getDepartment());
    }

    @Test
    public void personSetNameTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setName("Taha Yiğit Alkan");
        Assert.assertEquals("Taha Yiğit Alkan",p.getName());
    }

    @Test
    public void personSetEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setEmail("tahayigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("tahayigitalkan@akdeniz.edu.tr",p.getEmail());
    }

    @Test
    public void personSetIDTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setId(124L);
        Assert.assertEquals(124L,p.getID());
    }

    @Test
    public void personSetDepartmentTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setDepartment(department2);
        Assert.assertEquals(department2,p.getDepartment());
    }

    @Test
    public void personToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("Joseph Ledet (123) - josephledet@akdeniz.edu.tr",p.toString());
    }

    @Test
    public void personInvalidEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            Person p = new Person("Joseph Ledet", "josephledetakdeniz.edu.tr", 123L, department) {
            };
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }

    }

    @Test
    public void teacherConstructorTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        assertTrue(t instanceof Person);
    }

    @Test
    public void teacherConstructorTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Joseph Ledet",t.getName());
    }

    @Test
    public void teacherConstructorTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("josephledet@akdeniz.edu.tr",t.getEmail());
    }

    @Test
    public void teacherConstructorTest4 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(123L,t.getID());
    }

    @Test
    public void teacherConstructorTest5 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(department,t.getDepartment());
    }

    @Test
    public void teacherConstructorTest6 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(2,t.getRank());
    }

    @Test
    public void teacherSetDepartmentTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setDepartment(department2);
        Assert.assertEquals(department2,t.getDepartment());
    }

    @Test
    public void teacherSetNameTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setName("Taha Yiğit Alkan");
        Assert.assertEquals("Taha Yiğit Alkan",t.getName());
    }

    @Test
    public void teacherSetEmailTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setEmail("tahayigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("tahayigitalkan@akdeniz.edu.tr",t.getEmail());
    }

    @Test
    public void teacherSetIDTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setId(124L);
        Assert.assertEquals(124L,t.getID());
    }

    @Test
    public void teacherGetTitleTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Assistant Professor",t.getTitle());
    }

    @Test
    public void teacherDemoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        Assert.assertEquals(1,t.getRank());
    }

    @Test
    public void teacherDemoteTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        Assert.assertEquals("Lecturer",t.getTitle());
    }

    @Test
    public void teacherPromoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        Assert.assertEquals(3,t.getRank());
    }

    @Test
    public void teacherPromoteTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        Assert.assertEquals("Associate Professor",t.getTitle());
    }

    @Test
    public void teacherPromoteTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        t.promote();
        Assert.assertEquals("Professor",t.getTitle());
    }

    @Test
    public void teacherToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Assistant Professor Joseph Ledet (123) - josephledet@akdeniz.edu.tr",t.toString());
    }

    @Test
    public void teacherInvalidEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            Teacher t = new Teacher("Joseph Ledet", "josephledetakdeniz.edu.tr", 123L, department, 2);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }

    }

    @Test
    public void teacherInvalidRankTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 6);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void teacherInvalidRankTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 6);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("InvalidRankException:6",e.toString());
        }
    }

    @Test
    public void teacherInvalidPromoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        t.promote();
        try {
            t.promote();
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void teacherInvalidDemoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        try {
            t.demote();
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void studentConstructorTest1 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        assertTrue(s instanceof Person);
    }

    @Test
    public void studentConstructorTest2 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        Assert.assertEquals("Ali Çolak",s.getName());
    }

    @Test
    public void studentConstructorTest3 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        Assert.assertEquals("alicolak@akdeniz.edu.tr",s.getEmail());
    }

    @Test
    public void studentConstructorTest4 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        Assert.assertEquals(456L,s.getID());
    }

    @Test
    public void studentConstructorTest5 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        Assert.assertEquals(d,s.getDepartment());
    }

    @Test
    public void studentSetDepartmentTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department);
        s.setDepartment(department2);
        Assert.assertEquals(department2,s.getDepartment());
    }

    @Test
    public void studentSetNameTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department);
        s.setName("Taha Yiğit Alkan");
        Assert.assertEquals("Taha Yiğit Alkan",s.getName());
    }

    @Test
    public void studentSetEmailTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department);
        s.setEmail("tahayigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("tahayigitalkan@akdeniz.edu.tr",s.getEmail());
    }

    @Test
    public void studentSetIDTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department);
        s.setId(124L);
        Assert.assertEquals(124L,s.getID());
    }

    @Test
    public void studentGetAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", 124L, d2, 3);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d2, 107, "Physics", 5, t2);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,85);
        s.addCourse(c2,35);
        Assert.assertEquals(4,s.getAKTS());
    }

    @Test
    public void studentGetAttemptedAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", 124L, d2, 3);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d2, 107, "Physics", 5, t2);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,85);
        s.addCourse(c2,35);
        Assert.assertEquals(9,s.getAttemptedAKTS());
    }

    @Test
    public void studentAddCourseTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t2);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,75);
        s.addCourse(c1,98);
        s.addCourse(c2,76);
        Assert.assertEquals(6,s.getAttemptedAKTS());
    }

    @Test
    public void studentCourseGPAPointsTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,89);
        Assert.assertEquals(4.0,s.courseGPAPoints(c1),0.0001);
    }

    @Test
    public void studentCourseGradeLetterTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,89);
        Assert.assertEquals("AA",s.courseGradeLetter(c1));
    }

    @Test
    public void studentCourseResultTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,89);
        Assert.assertEquals("Passed",s.courseResult(c1));
    }

    @Test
    public void studentGetGPATest(){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t2);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,78);
        s.addCourse(c2,92);
        Assert.assertEquals(3.33,s.getGPA(),0.01);
    }

    @Test
    public void studentToStringTest (){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t2);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        s.addCourse(c1,78);
        s.addCourse(c2,75);
        Assert.assertEquals("Ali Çolak (456) - alicolak@akdeniz.edu.tr -GPA: 3.0",s.toString());
    }

    @Test
    public void studentInvalidEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            Student s = new Student("Ali Çolak", "alicolakakdeniz.edu.tr", 456L, department);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    public void studentInvalidGradeTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        try {
            s.addCourse(c1,125);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidGradeException);
        }
    }

    @Test
    public void studentInvalidGradeTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        try {
            s.addCourse(c1,125);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("InvalidGradeException: 125.0",e.toString());
        }
    }

    @Test
    public void studentCourseNotFoundExcepitonTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        try {
            s.courseGPAPoints(c1);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof CourseNotFoundException);
        }
    }

    @Test
    public void studentCourseNotFoundExcepitonTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Student s = new Student("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d);
        try {
            s.courseGPAPoints(c1);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("CourseNotFoundException: 456 has not yet taken CSE 101",e.toString());
        }
    }
    @Test
    public void gradStudentConstructorTest1 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        assertTrue(g instanceof Student);
    }

    @Test
    public void gradStudentConstructorTest2 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        Assert.assertEquals("Ali Çolak",g.getName());
    }

    @Test
    public void gradStudentConstructorTest3 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        Assert.assertEquals("alicolak@akdeniz.edu.tr",g.getEmail());
    }

    @Test
    public void gradStudentConstructorTest4 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        Assert.assertEquals(456L,g.getID());
    }

    @Test
    public void gradStudentConstructorTest5 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        Assert.assertEquals(d,g.getDepartment());
    }

    @Test
    public void gradStudentConstructorTest6 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        Assert.assertEquals("Programming",g.getThesis());
    }

    @Test
    public void gradStudentSetDepartmentTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department,"Programming");
        g.setDepartment(department2);
        Assert.assertEquals(department2,g.getDepartment());
    }

    @Test
    public void gradStudentSetNameTest() {
        Department department =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department,"Programming");
        g.setName("Taha Yiğit Alkan");
        Assert.assertEquals("Taha Yiğit Alkan",g.getName());
    }

    @Test
    public void gradStudentSetEmailTest() {
        Department department =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department,"Programming");
        g.setEmail("tahayigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("tahayigitalkan@akdeniz.edu.tr",g.getEmail());
    }

    @Test
    public void gradStudentSetIDTest() {
        Department department =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department,"Programming");
        g.setId(124L);
        Assert.assertEquals(124L,g.getID());
    }

    @Test
    public void gradStudentSetThesisTest() {
        Department department =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, department,"Programming");
        g.setThesis("Big Data");
        Assert.assertEquals("Big Data",g.getThesis());
    }

    @Test
    public void gradStudentGetAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", 124L, d2, 3);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d2, 107, "Physics", 5, t2);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,85);
        g.addCourse(c2,35);
        Assert.assertEquals(4,g.getAKTS());
    }


    @Test
    public void gradStudentGetAttemptedAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Deniz Kaya", "denizkaya@akdeniz.edu.tr", 124L, d2, 3);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d2, 107, "Physics", 5, t2);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,85);
        g.addCourse(c2,35);
        Assert.assertEquals(9,g.getAttemptedAKTS());
    }

    @Test
    public void gradStudentAddCourseTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,75);
        g.addCourse(c1,98);
        Assert.assertEquals(4,g.getAKTS());
    }

    @Test
    public void gradStudentCourseGPAPointsTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,89);
        Assert.assertEquals(3.5,g.courseGPAPoints(c1),0.0001);
    }


    @Test
    public void gradStudentCourseGradeLetterTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,89);
        Assert.assertEquals("BA",g.courseGradeLetter(c1));
    }

    @Test
    public void gradStudentCourseResultTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,89);
        Assert.assertEquals("Passed",g.courseResult(c1));
    }


    @Test
    public void gradStudentGetGPATest(){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t2);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,78);
        g.addCourse(c2,92);
        Assert.assertEquals(3.0,g.getGPA(),0.01);
    }


    @Test
    public void gradStudentToStringTest (){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Teacher t2 = new Teacher("Taner Danışman", "tanerdanisman@akdeniz.edu.tr", 128L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        Course c2 = new Course(d, 105, "Introduction Computer Science", 2, t2);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        g.addCourse(c1,78);
        g.addCourse(c2,75);
        Assert.assertEquals("Ali Çolak (456) - alicolak@akdeniz.edu.tr -GPA: 2.5",g.toString());
    }

    @Test
    public void gradStudentInvalidEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            GradStudent g = new GradStudent("Ali Çolak", "alicolakakdeniz.edu.tr", 456L, department,"Programming");
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    public void gradStudentInvalidGradeTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        try {
            g.addCourse(c1,125);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidGradeException);
        }
    }

    @Test
    public void gradStudentInvalidGradeTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        try {
            g.addCourse(c1,125);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("InvalidGradeException: 125.0",e.toString());
        }
    }

    @Test
    public void gradStudentCourseNotFoundExcepitonTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        try {
            g.courseGPAPoints(c1);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof CourseNotFoundException);
        }
    }

    @Test
    public void gradStudentCourseNotFoundExcepitonTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", 4, t);
        GradStudent g = new GradStudent("Ali Çolak", "alicolak@akdeniz.edu.tr", 456L, d,"Programming");
        try {
            g.courseGPAPoints(c1);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("CourseNotFoundException: 456 has not yet taken CSE 101",e.toString());
        }
    }
}