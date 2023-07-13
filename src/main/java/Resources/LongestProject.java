package Resources;

public class LongestProject {
    private Integer id;
    private int monthCount;

    public Integer getId() {
        return id;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "Resources.LongestProject{" +
                "id=" + id +
                ", monthCount=" + monthCount +
                '}';
    }
}
