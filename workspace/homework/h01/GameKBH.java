package homework.h01;

import java.util.Scanner;

public class GameKBH {
    static void main() {
        System.out.println("*** Escape from Mage ***");

        Scanner sc = new Scanner(System.in);
        System.out.print("플레이어 이름: ");
        String name = sc.next();
        System.out.println("환영합니다. " + name + "님\n");

        int turn = 0, max_turn = 5;
        int action = 0;
        // 기초 능력치
        int userHp = 100, userAtk = 25, userDef = 10, userLck = 10, itemAmount = 5;
        while (true) {
            sc.nextLine();
            if (turn == 0) {
                System.out.print("아무거나 입력하여 게임 시작");
            } else if (turn == max_turn) {
                System.out.print("아무거나 입력하여 마지막 턴 진행");
            }
            else {
                System.out.print("아무거나 입력하여 다음 턴 진행");
            }

            sc.nextLine();

            if (turn == max_turn) {
                System.out.println("\n보스 출현!!!");
                System.out.println("아무거나 입력하여 진행\n");
                sc.next();
            } else {
                System.out.println("\n몬스터 조우!!!");
                System.out.print("1) 전투시작 2) 도망간다 \n입력: ");
                action = sc.nextInt();
            }

            int combatResult = 1;
            switch (action) {
                case 1 -> {
                    combatResult = combat(userHp, userAtk, userDef, userLck, itemAmount, turn, max_turn);
                }
                case 2 -> {
                    int token = (int) (Math.random()*100 + 1) + userLck;
                    if (token > 50) {
                        System.out.println("몬스터에게 들키지 않고 도망가는데 성공했습니다.\n");
                        combatResult = 2;
                    } else {
                        System.out.println("앗! 몬스터에게 발각되었습니다!\n");
                        combat(userHp, userAtk, userDef, userLck, itemAmount, turn, max_turn);
                    }
                }
                default -> {}
            }

            if (combatResult == 0) {
                System.out.println("Game Over...\n");
                break;
            } else if (combatResult == 1) {
                if (turn == max_turn) {
                    System.out.println("탈출 성공!\n");
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                System.out.println("능력치가 상승하였습니다!\n");
                System.out.println("기존 능력치");
                System.out.printf("체력: %d\t공격력: %d\t방어력: %d\t행운: %d\n", userHp, userAtk, userDef, userLck);
                userHp += Math.max(20, (int) (Math.random()*50) + 1);
                userAtk += Math.max(10, (int) (Math.random()*20) + 1);
                userDef += Math.max(10, (int) (Math.random()*20) + 1);
                userLck += Math.max(5, (int) (Math.random()*25) + 1);
                if(userHp > 250) userHp = 250;
                if(userAtk > 100) userAtk = 100;
                if(userDef > 75) userDef = 75;
                if(userLck > 60) userLck = 60;
                System.out.println("현재 능력치");
                System.out.printf("체력: %d\t공격력: %d\t방어력: %d\t행운: %d\n", userHp, userAtk, userDef, userLck);
                System.out.println();
            }
            turn++;
        }
    }

    static int combat(int userHp, int userAtk, int userDef, int userLck, int itemAmount, int turn, int max_turn) {
        Scanner sc = new Scanner(System.in);
        int action;

        System.out.println("전투 개시!");
        System.out.println();

        int maxUserHp = userHp, basicUserDef = userDef;

        String mobType = "몬스터";
        int mobHp = Math.max(50, (int) (Math.random()*100) + 1) + ((turn - 1) * 25),
                mobAtk = Math.max(25, (int) (Math.random()*25) + 1) + ((turn - 1) * 5),
                mobDef = Math.max(20, (int) (Math.random()*20) + 1) + ((turn - 1) * 5);

        if (turn == max_turn) {
            mobHp = 500; mobAtk = 100; mobDef = 60;
            mobType = "보스";
        }

        while (true) {
            System.out.printf("내 체력: %d\t\t%s 체력: %d\n", userHp, mobType, mobHp);

            System.out.printf("1) 공격한다\t2) 방어한다\t3)포션 사용(소지갯수: %d)\n입력: ", itemAmount);
            action = sc.nextInt();
            System.out.println();

            int token = (int) (Math.random()*100) + 1;
            int totalDmg = 0;
            switch (action) {
                case 1 -> {
                    System.out.println("플레이어의 공격!");
                    int userDmg = Math.max((int) (userAtk*0.5), (int) (Math.random() * userAtk) + 1);
                    if (token > 100 - userLck) {
                        userDmg = (int) (userAtk * 1.5);
                        System.out.println("크리티컬!!!");
                    }
                    totalDmg =  (int) (userDmg*(1 - (mobDef/100.0)));
                    System.out.printf("%s에게 %d의 데미지를 주었다.\n", mobType, totalDmg);
                    mobHp -= totalDmg;
                    System.out.println();

                }
                case 2 -> {
                    System.out.println("방어!! 방어력이 50% 상승!");
                    System.out.printf("기존: %d -> ", userDef);
                    userDef *= 1.5;
                    System.out.printf("현재: %d\n", userDef);

                }
                case 3 -> {
                    if (userHp == maxUserHp) {
                        System.out.println("이미 최대 체력이다.");
                    } else if (itemAmount == 0) {
                        System.out.println("회복 아이템이 없다.");
                    }
                    else {
                        System.out.println("포션을 사용하여 체력을 회복하였다.");
                        System.out.printf("기존: %d -> ", userHp);
                        userHp += Math.max(20, 20 * turn);
                        if (userHp > maxUserHp) {
                            userHp = maxUserHp;
                        }
                        System.out.printf("현재: %d\n", userHp);
                        itemAmount--;
                    }
                }
            }

            if (mobHp <= 0) {
                System.out.printf("%s가 쓰러졌다!\n", mobType);
                return 1;
            }

            System.out.print("아무거나 입력하여 진행");
            String nextStep = sc.next();
            System.out.println();

            System.out.printf("%s의 공격!\n", mobType);
            int mobDmg = Math.max(10, (int) (Math.random() * mobAtk));
            token = (int) (Math.random() * 100) + 1;
            if (token > 90) {
                System.out.println("크리티컬!!!");
                mobDmg = (int) (mobAtk * 1.5);
            }
            totalDmg = (int) (mobDmg*(1 - (userDef/100.0)));
            System.out.printf("%d의 데미지를 받았다.\n", totalDmg);
            userHp -= totalDmg;
            userDef = basicUserDef;
            System.out.println();

            if (userHp <= 0) {
                System.out.println("You Died...\n");
                return 0;
            }
        }


    }
}
