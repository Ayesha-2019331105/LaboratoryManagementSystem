package LaboratoryManagement;

public class User {
    private String courseName;
    private String expName;
    private Integer groupNo;
    private String materials;
    private String report;

    public User(String courseName, String expName, Integer groupNo, String materials, String report) {
        this.courseName = courseName;
        this.expName = expName;
        this.groupNo = groupNo;
        this.materials = materials;
        this.report = report;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getExpName() {
        return expName;
    }

    public Integer getGroupNo() {
        return groupNo;
    }

    public String getMaterials() {
        return materials;
    }

    public String getReport() {
        return report;
    }
}
