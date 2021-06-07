public class Employee {

    private final String fullName; // final значит поле изменять нельзя и метод setter не доступен, только getter
    private final String position;
    private final String email;
    private final String phone;
    private final float salary;
    private final int age;
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

    public int getAge() { // final значит поле изменять нельзя и метод setter не доступен, только getter
        return age;
    }

    public void info() {
      System.out.printf("fullMame = %s, position = %s, email = %s, phone = %s, salary = %f, age = %d", fullName, position, email, phone, salary, age);
   }

}
