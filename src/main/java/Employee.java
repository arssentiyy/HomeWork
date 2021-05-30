public class Employee {

   String fullName;
   String position;
   String email;
   String phone;
   float salary;
   int age;
   public static int count;

   public Employee(String fullName, String position, String email, String phone, float salary, int age) {
      count++;
      this.fullName = fullName;
      this.position = position;
      this.email = email;
      this.phone = phone;
      this.salary = salary;
      this.age = age;
   }

   public void info() {
      System.out.printf("fullMame = %s, position = %s, email = %s, phone = %s, salary = %f, age = %d", fullName, position, email, phone, salary, age);
   }

}
