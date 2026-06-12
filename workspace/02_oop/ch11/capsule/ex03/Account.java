package ch11.capsule.ex03;

public class Account {
    // 잔고
    private int balance;

    public int getBalance() {
        return balance;
    }

    // 입금(amount 만큼 balance를 증가)
    public void deposit(int amount){
        if(amount > 0){
            this.balance += amount;
            System.out.println(amount + "원이 입금 되었습니다. 잔고는 " + balance + "원 입니다.");
        }else{
            System.out.println("입금액이 잘못 되었습니다.");
        }
    }

    // 출금(amount 만큼 balance를 감소, 잔고가 부족한지 체크 필요)
    public void withdraw(int amount){
        if(balance >= amount) {
            this.balance -= amount;
            System.out.println(amount + "원이 출금 되었습니다. 잔고는 " + balance + "원 입니다.");
        }else{
            System.out.println("잔고가 부족합니다. 잔고는 " + balance + "원 입니다.");
        }
    }
}