package homework.h01;

import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("***멋쟁이 전사처럼***");
        System.out.println("캐릭터 이름을 지어주세요.");
        String name = s.next();
        int hp = 50; // 내 에너지
        int damage = 0; // 내 피해량
        int ultimateSkill = 1; // 필살기 기술 수량
        int enemyHp = 0; // 적군 에너지
        int enemyDamage = 0; // 적군 피해량
        System.out.println(name + "님 어서오세요. 게임을 시작합니다.");

        enemyHp = (int)(Math.random() * 90) + 10; // 10 ~ 99

        while(true){ // 조건없이 무한반복, 항상 true라는 소리
            System.out.println(enemyHp + " 체력을 가진 적을 만났다. 어떤 행동을 하시겠습니까?");
            System.out.println("1) 싸운다 2) 도망간다 3) HP를 10 회복한다 4) 필살기 사용");
            int action = s.nextInt();

            switch(action){
                case 1 -> {
                    System.out.println("적과 싸웁니다.");
                    enemyDamage  = (int)(Math.random() * 11); // 0 ~ 10
                    enemyHp -= enemyDamage;
                    damage = (int)(Math.random() * 11); // 0 ~ 10
                    hp -= damage;
                    System.out.println("적에게 " + enemyDamage + "의 데미지를 주고 " + damage + "의 데미지를 입었다.");
                    System.out.println("나의 남은 체력은 " + hp + "입니다.");
                    System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                }
                case 2 -> {
                    damage = (int)(Math.random() * 3); // 0 ~ 2
                    hp -= damage;
                    enemyHp = (int)(Math.random() * 90) + 10; // 10 ~ 99, 적의 체력을 10 ~ 99로 랜덤생성
                    System.out.println("도망간다. 대신 " + damage + "의 체력이 소비되었다.");
                    System.out.println("남은 체력은 " + hp + "입니다.");
                }
                case 3 -> {
                    hp += 10;
                    System.out.println("체력이 10 회복 되었다.");
                    System.out.println("남은 체력은 " + hp + "입니다.");
                }
                case 4 -> {
                    if(ultimateSkill > 0){
                        int chance = (int)(Math.random() * 2); //(Math.random() * 2)= 0 ~ 1.999.., int했으니까 0 ~ 1
                        enemyDamage = enemyHp * chance;        // chance는 필살기 성공이 0아니면 1이라는 소리, 실패 아님 성공
                        enemyHp -= enemyDamage;               //chance가 0이면 적데미지가0이고 적에너지에 그 0차감, 적에너지 변화없음
                        damage = 0;
                        ultimateSkill--;
                        System.out.println("궁극의 필살기를 사용했다.");
                        System.out.println("적에게 " + enemyDamage + "의 데미지를 주고 " + damage + "의 데미지를 입었다.");
                        System.out.println("나의 남은 체력은 " + hp + "입니다.");
                        System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                    }else{
                        System.out.println("사용할 수 있는 필살기가 없습니다.");
                    }
                }
            }

            if(hp <= 0 || enemyHp <= 0){
                break;
            }
        }

        if(hp <= 0){
            System.out.println("당신은 사망했습니다. - The end -");
        }else if(enemyHp <= 0){
            System.out.println("전투에 승리했습니다. - The end -");
        }
    }
}