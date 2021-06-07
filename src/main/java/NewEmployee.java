public class NewEmployee {

    public static void main(String[] args) {
        Employee p1 = new Employee("Иванов Иван Иваныч", "космонавт", "space@gmail.com", "+7-777-777-77-77", 10000.5F, 37 );
        p1.info();
        personArray();
    }

    public static void personArray(){
                Employee[] persArray = new Employee[5];
                persArray[0] = new Employee("Иванов Иван Иваныч", "космонавт", "space@gmail.com", "+7-777-777-77-77", 10000.5F, 37 );
                persArray[1] = new Employee("Петров Иван Иваныч", "инженер", "space5@gmail.com", "+7-777-777-77-99", 10000.5F, 41 );
                persArray[2] = new Employee("Сидоров Иван Иваныч", "космонавт", "space@gmail.com", "+7-777-777-77-77", 10000.5F, 37 );
                persArray[3] = new Employee("Пупкин Иван Иваныч", "старший инженер", "space3@gmail.com", "+7-777-777-77-50", 10000.5F, 45 );
                persArray[4] = new Employee("Шмаков Иван Иваныч", "космонавт", "space@gmail.com", "+7-777-777-77-77", 10000.5F, 37 );
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                System.out.println();
                System.out.println("Этот сотрудник старше 40: ");
                persArray[i].info();
            }
        }
    }


}
