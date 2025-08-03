import java.util.Scanner;
public class BestTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true) {
            information();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneySpend = scanner.nextLine();
                    int spend = Integer.parseInt(moneySpend);
                    spendings+=spend;
                    break;
                case 3:
                    int taxA = taxEarnings(earnings);
                    int taxB = taxEarningsMinusSpendings(earnings, spendings);
                    if (taxA < taxB) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxA + " рублей");
                        System.out.println("Налог на другой системе: "+ taxB + " рублей");
                        System.out.println("Экономия: " + (taxB- taxA) + " рублей");
                    } else if (taxA > taxB) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxB + " рублей");
                        System.out.println("Налог на другой системе: " + taxA + " рублей");
                        System.out.println("Экономия: " + (taxA - taxB) + " рублей");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    } break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }


    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else return 0;
    }


    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }


    public static void information() {
        System.out.println("----------------------------------------");
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
        System.out.println("Чтобы завершить программу введите - end");
    }
}
