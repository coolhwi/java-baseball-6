package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = new ArrayList<>();
        int game = 1;

        while(computer.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(game==1) {
            // 컴퓨터, 사용자 숫자 넣어주기
            List<Integer> user = new ArrayList<>();
            int strike=0;
            int ball =0;
            int finsh=0;

            System.out.print("숫자를 입력해주세요:");

            String user_num = readLine();

            for(int i=0; i<user_num.length() ; i++){   // user 배열에 charAt을 이용해서 하나씩 넣기
                user.add(user_num.charAt(i)-'0');
            }


            // 예외 처리
            if(user.size()<3 || user.size()>3){
                throw new IllegalArgumentException("숫자 입력 수가 잘못 되었습니다.");
            }

            System.out.println("computer == "+computer);
            System.out.println("user == "+user);


            //숫자 다 넣었고 -> 이제 컴퓨터 값을 사용자 값이랑 비교해주기
            for(int i=0; i<3 ; i++){
                for(int j=0; j<3 ; j++){
                    if((computer.get(i) == user.get(j)) && i==j){
                        strike++;
                    }
                    if((computer.get(i) == user.get(j)) && i!=j){
                        ball++;
                    }
                }
            }
            if(strike ==0 && ball ==0){
                System.out.println("낫싱");
            }
            else if(strike==3){
                finsh=3;
                System.out.println("3스트라이크");

            }
            else{
                System.out.println(ball+"볼"+" "+strike+"스트라이크");
            }
            if(finsh==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! ");
                System.out.println("게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                game = Integer.parseInt(readLine());
                if(game==1){
                    computer = new ArrayList<>();
                    while(computer.size() <3){
                        int randomNumber = Randoms.pickNumberInRange(1,9);
                        if(!computer.contains(randomNumber)){
                            computer.add(randomNumber);
                        }
                    }
                }
            }

        }




    }
}
