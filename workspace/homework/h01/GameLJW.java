package homework.h01;

import java.util.Scanner;

public class GameLJW {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("***멋사***");
        System.out.println("캐릭터 이름을 입력하세요.");
        String name = s.next();
        int hp = 100; // 내 에너지
        int damage = 0; // 내 피해량
        int skill = 3; // 아이템 수량
        int enemyHp = 0; // 적군 에너지
        int enemyDamage = 0; // 적군 피해량
        int way = 0;
        int potion = 10;
        System.out.println(name + "님 어서오세요.");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i+"층");
            System.out.println("길을 선택하세요.");
            System.out.println("1.왼쪽  2.중간  3.오른쪽");
            int alley = s.nextInt();

            enemyHp = (int) (Math.random() * 41) + 10; // 10 ~ 99
            way = (int) (Math.random() * 5);

            if(way==0) {
                System.out.println("10골드를 발견했습니다.");
            }
            else if(way==1) {
                System.out.println("아무것도 없습니다. 다음 길을 선택하십시오.");
            }
            while (way >= 2) {
                System.out.println("나의 HP: "+hp);
                System.out.println("적의 HP: " + enemyHp + " \n\t\t\t\t행동 선택");
                System.out.println("1. 공격  2. 도주  3. HP 10 회복  4. 스킬 사용");
                int action = s.nextInt();

                switch (action) {
                    case 1 -> {     // 전투
                        System.out.println("공격");
                        enemyDamage = (int) (Math.random() * 11);
                        enemyHp -= enemyDamage;
                        damage = (int) (Math.random() * 11);
                        hp -= damage;
                        System.out.println("적에게 준 데미지: " + enemyDamage + "받은 데미지: " + damage);
                    }
                    case 2 -> {       // 도주
                        int run = (int) (Math.random() * 2);
                        if (run > 0) {     // 도주 성공
                            damage = (int) (Math.random() * 3);
                            hp -= damage;
                            enemyHp = (int) (Math.random() * 90) + 10; // 10 ~ 99
                            System.out.println(damage + "의 피해를 입고 도주 성공");
                            System.out.println("남은 체력: " + hp);
                        } else {     // 도주 실패
                            damage = (int) (Math.random() * 3);
                            hp -= damage;
                            System.out.println("도주에 실패했습니다. 체력 손실: " + damage);
                            System.out.println("남은 체력: " + hp);
                        }
                    }
                    case 3 -> {     // 회복
                        if(potion<=0) {
                            System.out.println("포션이 없습니다. 다른 행동을 선택하세요.");
                            break;
                        }
                        potion--;
                        hp += 10;
                        damage = (int) (Math.random() * 3);
                        hp -= damage;
                        System.out.println("공격당했습니다. 체력 손실: " + damage);
                        System.out.println("포션을 사용했습니다. 체력 10 회복. 남은 포션 개수: "+potion);
                        System.out.println("남은 체력: " + hp);
                    }
                    case 4 -> {
                        if (skill > 0) {
                            int chance = (int) (Math.random() * 3);
                            enemyDamage = enemyHp * chance;
                            enemyHp -= enemyDamage;
                            damage = 0;
                            skill--;
                            System.out.println("스킬 사용");
                            System.out.println("적에게 " + enemyDamage + "의 데미지를 주고 " + damage + "의 데미지를 입었다.");
                            System.out.println("나의 남은 체력은 " + hp + "입니다.");
                            System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                        } else {
                            System.out.println("스킬 사용이 불가능합니다.");
                        }
                    }
                }

                if (hp <= 0 || enemyHp <= 0) {
                    break;
                }
            }

            if (hp <= 0) {
                System.out.println("당신은 사망했습니다. - The end -");
                break;
            } else if (enemyHp <= 0) {
                System.out.println("전투에 승리했습니다. 계속 진행합니다.");
            }
        }
        System.out.println("축하합니다. 던전 밖으로 나왔습니다.");
    }
}