package practice1;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {2, -1, 3, 4, -9, -4, 0, 6, 0, 8};
        String s = "";
        for(int a : array){
            if(a > 0){
                s = "Первое число положительное";
            }
            if(a < 0){
                s = "Первое число отрицательное";
            }
        }
        System.out.println(s);
    }
}
