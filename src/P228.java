import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by lichao on 09/07/2017.
 * 作业调度问题
 */
public class P228 implements IAlgorithm {

    @Override
    public void exe() {
        List<Tuple> data = new ArrayList();
        data.add(new Tuple(0, 5, 6));
        data.add(new Tuple(1, 12, 2));
        data.add(new Tuple(2, 4, 14));
        data.add(new Tuple(3, 8, 7));

        TreeSet<Tuple> a = new TreeSet<>((t1, t2)->{
            if (t1.a >= t2.a) {
                return 1;
            }else
                return -1;
        });

        TreeSet<Tuple> b = new TreeSet<>((t1, t2)->{
            if (t1.b >= t2.b) {
                return -1;
            }else
                return 1;
        });

        for (Tuple item:data) {
            if (item.a < item.b) {
                a.add(item);
            }else {
                b.add(item);
            }
        }
        System.out.println(a);
        System.out.println(b);

    }
    public class Tuple {
        public int id;
        public int a;
        public int b;
        public Tuple(int id, int a, int b){
            this.id = id;
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if(((Tuple) obj).id == this.id)
                return true;
            else
                return false;
        }

        @Override
        public String toString() {
            return "id=" + id + ",a=" + a + ",b=" + b;
        }

    }
}
