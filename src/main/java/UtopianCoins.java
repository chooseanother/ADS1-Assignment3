import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UtopianCoins {
    private static int[] coins = {1,7,10,22};
    private static HashMap<Integer,Integer> map = new HashMap<>();

    static int coinChangeDynamic(int value){
        int min = Integer.MAX_VALUE;
        if(value <= 0){
            return 0;
        }
        if(Arrays.stream(coins).anyMatch(coin -> coin == value)){
            return 1;
        }
        for (int coin : coins) {
            if (value > coin) {
                int amount;
                if (!map.containsKey(value-coin)){
                    amount = coinChangeDynamic(value - coin);
                    map.put(value-coin,amount);
                }else {
                    amount = map.get(value-coin);
                }
                if (amount + 1 < min) {
                    min = amount + 1;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int x = 564;
        System.out.println(coinChangeDynamic(x));
        //System.out.println(coinChangeBrute(x));
    }


    static int coinChangeBrute(int value){
        int min = Integer.MAX_VALUE;
        if(value <= 0){
            return 0;
        }
        if(Arrays.stream(coins).anyMatch(coin -> coin == value)){
            return 1;
        }
        for (int coin : coins) {
            if (value > coin) {
                int amount = coinChangeDynamic(value - coin);
                if (amount + 1 < min) {
                    min = amount + 1;
                }
            }
        }
        return min;
    }
}



