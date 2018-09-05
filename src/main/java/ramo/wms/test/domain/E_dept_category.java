package ramo.wms.test.domain;

public class E_dept_category {
    private int dept_id;
    private String dept_name;
    private String subdept_ids;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getSubdept_ids() {
        return subdept_ids;
    }

    public void setSubdept_ids(String subdept_ids) {
        this.subdept_ids = subdept_ids;
    }
}
