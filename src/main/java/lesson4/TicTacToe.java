package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final String HEADER_FIRST_SIMBOL = "_";
    public static final String SPACE_MAP_SIMBOL = " ";
    private static final int SIZE = 3;
        public static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {
        do {
            System.out.println("\n\nИгра анчинается!");
            initMAP();
            printMAP();
            playGame();
        } while (isContinueGame());
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "н", "у", "да", "+" -> true;
            default -> false;
        };
    }


    private static void initMAP() {
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMAP() {
        printHeaderMap();
        printBodyMap();
    }



    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SIMBOL + SPACE_MAP_SIMBOL);
        for (int i = 0; i < SIZE; i++){
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i <SIZE; i++){
            printMapNumber(i);
            for (int j = 0; j <SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP_SIMBOL);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SIMBOL);
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMAP();
             if (checkEND(DOT_HUMAN)) {
                break;
            }




            aiTurn();
            printMAP();
            if (checkEND(DOT_AI)) {
                break;
            }
            //првоерка на конец игры

        }
    }




    private static void humanTurn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;

            System.out.print("Введите координату столбца: ");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)){
                break;
            }

            System.out.printf("Ошибка! Ячейка с координатами %s:%s уже используется%n", rowNumber + 1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
            return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void aiTurn() {
        System.out.println("\nХОД КОМПЬЮТЕРА!");
        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);

            columnNumber = random.nextInt(SIZE);


            } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
    }

    private static boolean checkEND(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN){
                System.out.println("УРА! Вы победили!");
            } else {
                System.out.println("Жестянка одержала победу...");
            }

            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }



    private static boolean checkWin(char symbol) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symbol) {
                    hor++;
                } else if (MAP[i][j] != symbol && hor < DOTS_TO_WIN) {
                    hor = 0;
                }
                if (MAP[j][i] == symbol) {
                    ver++;
                }   else if (MAP[j][i] != symbol && ver < DOTS_TO_WIN) {
                    ver = 0;
                }
            }
            if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[i][k] == symbol) {
                        diagMain++;
                    } else if (MAP[i][k] != symbol && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вправо " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[k][i] == symbol) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (MAP[k][i] != symbol && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вниз " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < SIZE) {
                    if (MAP[l][k] == symbol) {
                        diagReverse++;
                    } else if (MAP[l][k] != symbol && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси вниз " + diagReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - j - i;
                if (k >= 0) {
                    if (MAP[i][k] == symbol) {
                        diagReverse++;
                    } else if (MAP[i][k] != symbol && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси влево " + diagReverse);
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean checkDraw() {
        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
            }
        }

        }
        return true;
    }
}



