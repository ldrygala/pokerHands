import java.util.Comparator;
import java.util.Map;

/**
 * Created by ldrygala on 2015-03-26.
 */
public class OccurrenceComparator implements Comparator<CardFigures> {
    private Map<CardFigures, Integer> map;

    public OccurrenceComparator(Map<CardFigures, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(CardFigures o1, CardFigures o2) {
        int compareTo = map.get(o1).compareTo(map.get(o2));
        if (compareTo == 0) {
            return -Integer.compare(o1.getPrio(), o2.getPrio());
        } else {
            return -compareTo;
        }
    }
}
