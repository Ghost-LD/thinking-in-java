package leetcode;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/20 20:02
 */
public class Solution6 {

//    public int reverse(int x) {
//        int res = 0;
//        while(x!=0) {
//            //每次取末尾数字
//            int tmp = x%10;
//            //判断是否 大于 最大32位整数
//            if (res>214748364 || (res==214748364 && tmp>7)) {
//                return 0;
//            }
//            //判断是否 小于 最小32位整数
//            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
//                return 0;
//            }
//            res = res*10 + tmp;
//            x /= 10;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(add(1.2,2.01));
        System.out.println(reverse(-123456L));
    }

    public static Long reverse(Long bi) {
        if(bi == null){
            return 0L;
        }
        Long res = 0L ;
        while(bi != 0){
            Long temp = bi % 10 + res * 10;
            if((temp - bi % 10) / 10 != res){
                return 0L ;
            }
            res = temp ;
            bi /= 10 ;
        }
        return res ;
    }


    public Long reverse2(Long x) {
        Long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return  res == res ? res : 0;
    }


    public static double add(double a, double b) {
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.add(b1).doubleValue();
    }

}
