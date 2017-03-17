import java.util.Arrays;
import java.util.List;

public class Player {

    public static final List<String> scoreList = Arrays.asList("0", "15", "30", "40");
    private int point;
    String name;

    public Player(String name) {
        this.name = name;
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void winPoint() {
        this.point = this.point + 1;
    }

    public String getScore() {
        return scoreList.get(point);
    }
}
