package Resources;

public class MaxProjectsClient {
    private String name;
    private int projectCount;

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "Resources.MaxProjectsClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
