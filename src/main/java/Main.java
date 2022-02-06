import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbConnectionService dbConnectionService = new DbConnectionService();
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (number != 0){
            System.out.println("1=> product malumotlari 2 => pc ma'lumotlari 3 => laptop ma'lumotlari  4 => printer ma'lumotlari 5=> barcha masulotlar price buyicha o'sish");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    dbConnectionService.getproduct();
                    break; 
                case 2:
                    dbConnectionService.getPc();
                    break;
                case 3:
                    dbConnectionService.getLoptop();
                    break;
                case 4:
                    dbConnectionService.getPrinter();
                    break;
                case 5:
                    dbConnectionService.getusish();
                    break;
                default:
                    System.out.println("Hech qanday ma'lumot yo'q");
            }
        }
    }
}
