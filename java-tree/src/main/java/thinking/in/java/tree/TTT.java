package thinking.in.java.tree;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/11 21:24
 */
public class TTT {

    static Object object;

    static volatile Long sum;

    public boolean add(Long aid,Long cash){

        synchronized (this) {
            sum= cash+sum;
        }
        return false;
    }

    public boolean delete(Long aid,Long cash){

        if(sum<cash){
            return false;
        }

        synchronized (this) {
            if(sum<cash){
                return false;
            }
            sum= sum-cash;

        }
        return false;
    }

}
