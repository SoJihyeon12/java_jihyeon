package homework.h01;

import java.util.Scanner;

public class GameKDH {

    static final int MAX_HP = 100;

    static String name;
    static int hp = 100;
    static int atk = 10;
    static int def = 0;

    static int roleDice(String str) {
        int dice = (int) (Math.random() * 20) + 1;

        System.out.println("d20을 굴립니다. " + str);
        System.out.println(dice + "이(가) 나왔습니다.\n");
        return dice;
    }

    static void fightMonster(String monster, int monHp, int monAtk) {
        Scanner sc = new Scanner(System.in);
        int dice = 0;
        int select = 0;
        System.out.println(monster + "이(가) 나타났습니다!\n");

        while (true) {
            System.out.println(name + "-> 체력: " + hp + "\t공격력: " + atk + "\t방어력: " + def);
            System.out.println(monster + "-> 체력: " + monHp + "\t공격력: " + monAtk);
            System.out.println(name + "님, 무엇을 하시겠습니까?");
            System.out.println("1.공격한다\t2.도망친다");
            boolean isEnd = false;

            select = sc.nextInt();  // sc가 fightMonster 내의 객체라 main의 sc와 간섭이 일어나지 않는다
            switch (select) {
                case 1 -> {
                    dice = roleDice("18 이상이 나오면 " + atk + " x 2, 10 이상이면 " + atk + "의 데미지를 줍니다.");
                    if (dice >= 18) {
                        monHp -= (atk * 2);
                        System.out.println(monster + "에게 " + atk + " x 2의 데미지!!!\n");
                    }
                    else if (dice >= 10){
                        monHp -= atk;
                        System.out.println(monster + "에게 " + atk + "의 데미지!\n");
                    }
                    else {
                        System.out.println(monster + "이(가) 공격을 피했습니다...\n");
                    }
                }
                case 2 -> {
                    dice = roleDice("15 이상이 나오면 전투에서 도망칩니다.");
                    if (dice >= 15) {
                        System.out.println("전투에서 도망쳤다!\n");
                        isEnd = true;
                    }
                    else {
                        System.out.println("도망칠 수 없었다...\n");
                    }
                }
                default -> {
                    System.out.println("선택지 내에서 선택해 주세요.\n");
                    continue;
                }
            }

            if (!isEnd && monHp > 0) {
                System.out.println(monster + "의 공격입니다.");
                dice = roleDice("13 이상이 나오면 적에게 맞습니다.");
                if (dice >= 13) {
                    if (monAtk > def) {
                        hp -= (monAtk - def);
                        System.out.println(name + "에게 " + (monAtk - def) + "의 데미지...\n");
                    }
                    else {
                        System.out.println(name + "은 데미지를 입지 않았다.\n");
                    }
                }
                else {
                    System.out.println(monster + "의 공격을 피했습니다!\n");
                }
            }

            if (hp <= 0) {
                System.out.println(name + "의 눈 앞은 깜깜해졌다...\n");
                isEnd = true;
            }
            if (monHp <= 0) {
                System.out.println(monster + "를(을) 물리쳤다!!!\n");
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
    }

    static void meetMonster() {
        int action = (int) (Math.random() * 9) + 1;

        switch (action) {
            case 1, 2, 3 -> fightMonster("슬라임", 20, 10);
            case 4, 5 -> fightMonster("고블린", 60, 20);
            case 6 -> fightMonster("드래곤", 120, 50);
        }
    }

    static void recovery() {
        int dice = (int) (Math.random() * 7) + 1;
        int recoveryHp = 0;

        recoveryHp = switch (dice) {
            case 1 -> 80;
            case 2, 3 -> 50;
            case 4, 5, 6 -> 20;
            default -> 0;   // 7
        };

        hp += recoveryHp;
        if (hp > MAX_HP) {
            hp = MAX_HP;
        }

        System.out.println("체력을 " + recoveryHp + "만큼 회복합니다.");
        System.out.println("현재 체력은 " + hp + "입니다.\n");
    }

    static void findItem() {
        int dice = (int) (Math.random() * 10) + 1;
        System.out.println("물약을 발견했다!");

        switch (dice) {
            case 1, 2, 3, 4 -> {
                atk += 10;
                System.out.println("공격력 엘릭서를 마셨다. 공격력이 10 올랐다!\n");
            }
            case 5 -> {
                atk += 30;
                System.out.println("전설 공격력 엘릭서를 마셨다. 공격력이 30 올랐다!!!\n");
            }
            case 6, 7, 8, 9 -> {
                def += 10;
                System.out.println("방어력 엘릭서를 마셨다. 방어력이 5 올랐다!\n");
            }
            case 10 -> {
                def += 10;
                System.out.println("전설 방어력 엘릭서를 마셨다. 방어력이 20 올랐다!!!\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("*** RPG GAME ***");
        System.out.println("캐릭터 이름을 지어 주세요.");

        Scanner sc = new Scanner(System.in);
        name = sc.next();
        sc.nextLine();  // next의 개행 간섭으로 한번 개행을 비워야 한다.
        System.out.println(name + "님 환영합니다!");

        int MAX_TURN = (int) (Math.random() * 6) + 5;
        int curTurn = 1;

        System.out.println("당신은 " + MAX_TURN + "턴을 버티면 게임을 클리어 하게 됩니다.");
        System.out.println("그럼 행운을 빕니다.\n");

        int action = 0;

        for (; curTurn <= MAX_TURN; curTurn++) {
            System.out.println("현재 " + curTurn + "턴 입니다.");
            System.out.println(name + "-> 체력: " + hp + "\t공격력: " + atk + "\t방어력: " + def);
            System.out.println("...진행하려면 엔터(Enter)를 눌러주세요...");
            sc.nextLine();
            action = (int) (Math.random() * 9) + 1;

            switch (action) {
                case 1, 2, 3, 4, 5 -> meetMonster();
                case 6, 7, 8 -> recovery();
                case 9 -> findItem();
            }

            if (hp == 0) {
                System.out.println("--- GAME OVER ---");
                break;
            }
        }

        if (hp != 0) {
            System.out.println("축하드립니다! 무사히 생존하셨습니다!!!\n");
            System.out.println("--- HAPPY END ---");
        }
    }
}