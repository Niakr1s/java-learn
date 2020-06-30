package chapter7;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        testChanger(new ListChangerByIterator());
        testChanger(new ListChangerInLoop());
        testChanger(new ListChangerReplaceAll());
    }

    private static void testChanger(ListChanger changer) {
        List<String> list = makeList();
        changer.change(list);
        System.out.println(list);
    }

    private static List<String> makeList() {
        List<String> res = new ArrayList<>();
        res.add("one");
        res.add("two");
        res.add("three");
        return res;
    }
}

interface ListChanger {
    void change(List<String> list);
}

class ListChangerReplaceAll implements ListChanger {
    @Override
    public void change(List<String> list) {
        list.replaceAll(String::toUpperCase);
    }
}
class ListChangerInLoop implements ListChanger {
    @Override
    public void change(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toUpperCase());
        }
    }
}

class ListChangerByIterator implements ListChanger {
    @Override
    public void change(List<String> list) {
        int idx = 0;
        for (String s : list) {
            list.set(idx, s.toUpperCase());
            idx++;
        }
    }
}