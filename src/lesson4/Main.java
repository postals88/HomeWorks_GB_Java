package lesson4;



public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan", "Ivanov", "Director", 89057941260L, 100000, 54);
        System.out.println("Имя " + employee1.getName() + "\nФамилия " + employee1.getLastName() + "\nДолжность " + employee1.getPosition() + "\nНомер телефона " + employee1.getTelNumber() + "\nЗарплата " + employee1.getSalary() + " рублей \nВозраст " + employee1.getAge() + " года \n");
        Employee employee2 = new Employee("Petr", "Petrov", "Engineer", 89057943342L, 50000, 32);
        System.out.println("Имя " + employee2.getName() + "\nФамилия " + employee2.getLastName() + "\nДолжность " + employee2.getPosition() + "\nНомер телефона " + employee2.getTelNumber() + "\nЗарплата " + employee2.getSalary() + " рублей \nВозраст " + employee2.getAge() + " года\n");
        Employee[] fiveEmployee = new Employee[]{new Employee("Tatiana", "Ivanova", "Secretary", 89045567821L, 60000, 46), new Employee("Andrey", "Andreev", "Engeneer", 89047236764L, 80000, 29), new Employee("Kostya", "Petrov", "Engeneer", 89056734561L, 70000, 47), new Employee("Irina", "Ivanova", "Helper", 89054325674L, 70000, 23), new Employee("Stas", "Andreev", "Engeneer", 89054325674L, 60000, 65)};

        int i;
        for(i = 0; i < fiveEmployee.length; ++i) {
            if (fiveEmployee[i].getAge() > 40) {
                printEmployee(fiveEmployee[i]);
            }
        }

        for(i = 0; i < fiveEmployee.length; ++i) {
            if (fiveEmployee[i].getAge() > 45) {
                fiveEmployee[i].setSalary(fiveEmployee[i].getSalary() + 5000);
                printPlusSalary(fiveEmployee[i]);
            }
        }

    }

    public static void printEmployee(Employee employee) {
        System.out.println("Сотрудник старше 40 лет");
        System.out.println("Имя " + employee.getName() + "\nФамилия " + employee.getLastName() + "\nДолжность " + employee.getPosition() + "\nНомер телефона " + employee.getTelNumber() + "\nЗарплата " + employee.getSalary() + " рублей \nВозраст " + employee.getAge() + "\n");
    }

    public static void printPlusSalary(Employee employeeSalary) {
        System.out.println("Повысили ЗП за возраст на 5000р");
        System.out.println("Имя " + employeeSalary.getName() + "\nФамилия " + employeeSalary.getLastName() + "\nДолжность " + employeeSalary.getPosition() + "\nНомер телефона " + employeeSalary.getTelNumber() + "\nЗарплата " + employeeSalary.getSalary() + " рублей \nВозраст " + employeeSalary.getAge() + "\n");
    }
}


