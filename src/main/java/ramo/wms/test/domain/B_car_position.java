package ramo.wms.test.domain;

public class B_car_position {
    private String carunit_id;
    private String real_location;
    private int level;
    private int unit_typeid;
    private int unit_statusid;

    public String getCarunit_id() {
        return carunit_id;
    }

    public void setCarunit_id(String carunit_id) {
        this.carunit_id = carunit_id;
    }

    public String getReal_location() {
        return real_location;
    }

    public void setReal_location(String real_location) {
        this.real_location = real_location;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUnit_typeid() {
        return unit_typeid;
    }

    public void setUnit_typeid(int unit_typeid) {
        this.unit_typeid = unit_typeid;
    }

    public int getUnit_statusid() {
        return unit_statusid;
    }

    public void setUnit_statusid(int unit_statusid) {
        this.unit_statusid = unit_statusid;
    }
}
