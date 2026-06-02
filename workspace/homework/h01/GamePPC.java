package homework.h01;

import java.util.Scanner;

public class GamePPC {
    public static  void  main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("***전투력 키우기***");
        System.out.println("캐릭터 이름을 지어주세요!!!");
        String name = s.next();
        int hp = 100; //체력
        int damage = 0;   // 받은 피해량
        int enemyHp = 10; // 적군 체력
        int bossEnemyHp = 2*enemyHp;// 보스체력
        int enemyDamage = 0; // 적군 받은 피해량
        int bossEnemyDamage = 0; // 보스가 받는 피해량
        int ultimateskill = 1; // 필살기 횟수

        System.out.println(name + "님 어서오세요. 게임을 시작합니다.");

        enemyHp = (int)(Math.random() * 100 + 20); // 10 ~ 119
        if(enemyHp > 100){
            bossEnemyHp = enemyHp * 2; // 5% 확률로 2배의 체력이 되는 보스몹을 소환
        }
        while(true){

            if(enemyHp <=100){
                System.out.println(enemyHp + " 체력을 가진 적을 만났다. 어떤 행동을 하겠습니까?");
            }else{
                System.out.println(bossEnemyHp + " 체력을 가진 야생의 보스가 나타났다!!! 어떤 행동을 하겠습니까?");
            }
            System.out.println(" 1) 싸운다 2) 도망간다 3) 아이템을 사용한다 4) 필살기 사용 5) 종료하기)" );
            int action = s.nextInt();

            switch(action){
                case 1 -> {
                    if(enemyHp <= 100) {
                        System.out.println("적과 싸웁니다");
                        enemyDamage = (int)(Math.random() * 11);
                        enemyHp -= enemyDamage;
                        damage = (int)(Math.random() * 11);
                        hp -= damage;
                        System.out.println("적에게 " + enemyDamage + " 만큼의 데미지를 주고"  + damage + "의 데미지를 입었다.");
                        System.out.println("나의 남은 체력은 " + hp + "입니다");
                        System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                        System.out.println();
                    } else {
                        System.out.println("보스와 싸웁니다!!!");
                        bossEnemyDamage = (int)(Math.random() * 11 * 0.9);
                        bossEnemyHp -= bossEnemyDamage;
                        damage = (int)(Math.random() * 11);
                        hp -= damage;
                        System.out.println("적에게 " + bossEnemyDamage + " 만큼의 데미지를 주고"  + damage + "의 데미지를 입었다.");
                        System.out.println("나의 남은 체력은 " + hp + "입니다");
                        System.out.println("적의 남은 체력은 " + bossEnemyHp + "입니다.");
                        System.out.println();
                    }
                }
                case 2 -> {
                    damage = (int)(Math.random() * 10 + 1 );
                    hp -= damage;
                    enemyHp = (int)(Math.random() * 100 + 20); // 10 ~ 119 도망친경우 새로운 몹
                    if(enemyHp > 100){
                        bossEnemyHp = enemyHp * 2; // 확률로 2배의 체력이 되는 보스몹을 소환
                    }
                    System.out.println("도망간다. 대신 " + damage + "의 체력이 소비되었다.");
                    System.out.println("남은 체력은 " + hp + "입니다.");
                    System.out.println();
                }
                case 3 -> {
                    hp += 10;
                    System.out.println("체력이 10만큼 회복되었습니다.");
                    System.out.println("남은 체력은 " + hp + "입니다.");
                    System.out.println();
                }
                case 4 -> {
                    if(ultimateskill > 0){
                        int chance = (int)(Math.random() * 2);
                        enemyDamage = enemyHp * chance;
                        bossEnemyDamage = bossEnemyHp * chance; //보스 체력이 enemyHP에서 파생됨
                        enemyHp -= enemyDamage;
                        bossEnemyHp -= bossEnemyDamage;
                        ultimateskill--;
                        System.out.println(" 내 궁극의 일격을 받아라!!!");
                        if(enemyHp == 0 ){
                            System.out.println("적을 쓰러뜨렸습니다.");
                        }

                    }else{
                        System.out.println("사용 할 수 있는 필살기가 없습니다.");
                        System.out.println();
                    }
                }
                case 5 -> { // 강제 종료
                    System.out.println("정말로 종료하시겠습니까?");
                    System.out.println("1) 종료한다. 2) 계속한다");
                    int confirm = s.nextInt();
                    switch (confirm){
                        case 1 -> {
                            System.out.println("게임을 종료합니다. 나중에 또 만나요^^");
                            System.exit(0);
                        }
                        case 2 -> {
                            break;
                        }
                    }
                }
            }

            if(hp <= 0 || enemyHp <= 0 || bossEnemyHp <= 0 ){
                break;
            }
        }
        if(hp <=0){
            System.out.println("당신은 사망했습니다.");
        }else if (enemyHp <= 0 || bossEnemyHp <= 0){
            System.out.println("전투에서 승리하였습니다.");
        }
    }
}