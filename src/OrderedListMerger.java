import java.util.ArrayList;
import java.util.List;

public class OrderedListMerger {
    public static List<Integer> merge(List<Integer> L1, List<Integer> L2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < L1.size() && j < L2.size()) {
            if (L1.get(i) <= L2.get(j)) {
                merged.add(L1.get(i++));
            } else {
                merged.add(L2.get(j++));
            }
        }
        while (i < L1.size()) merged.add(L1.get(i++));
        while (j < L2.size()) merged.add(L2.get(j++));
        return merged;
    }
}
