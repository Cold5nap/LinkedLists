
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*#27.
        Реализовать процедуру случайного перемешивания элементов списка.
*/
public class MixLinkedList {

    public static MyLinkedList<Integer> mixedListOfIntegerV2(MyLinkedList<Integer> list) throws Exception {
        Random random = new Random();
        MyLinkedList<Integer> newList = new MyLinkedList<>();
        List<Integer> randomIndexes = new ArrayList<>();

        for (int i =0;i<list.size;i++) {
            Integer valueOfList = list.get(i);
            randomIndexes.add(valueOfList);
        }
        Collections.shuffle(randomIndexes ,random);

        for (int i =0;i<list.size;i++) {
            Integer valueOfRandomIndexes = randomIndexes.get(i);
            newList.addLast(valueOfRandomIndexes);
        }

        return newList;
    }
}
