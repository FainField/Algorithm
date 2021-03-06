/**
 * Created by lichao on 06/07/2017.
 * 八皇后问题 回溯方法
 */
public class P212 implements IAlgorithm{
    private int maxValue = 8;
    private int[] result = new int[maxValue];
    private int total = 0;
    @Override
    public void exe() {
        nonRecursive();
//        recursive(0);
    }
    private void recursive(int k){
        if (k == maxValue) {
            out();
            return;
        }
        for (int i = 0; i < maxValue; i++) {
            if(check(k, i)){
                result[k] = i;
                recursive(k + 1);
            }
        }
    }
    private void nonRecursive(){
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int k = 0;
        while (k >= 0) {
            result[k] = result[k] + 1;
            while (result[k] < maxValue && !check(k, result[k])) {
                result[k] = result[k] + 1;
            }
            if (result[k] < maxValue) {
                    if (k == 7) {
                        out();
                    }else{
                        k = k + 1;
                    }
            }else{
                result[k] = -1;
                k = k - 1;
            }
        }
    }
    private boolean check(int who,int where){
        for (int i = 0; i < who; i++) {
            if (Math.abs(i - who) == Math.abs(result[i] - where) || result[i] == where && where <= 7) {
                return false;
            }
        }
        return true;
    }
    private void out(){
        System.out.print(++total + ": ");

        for (int i : result) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }
}
