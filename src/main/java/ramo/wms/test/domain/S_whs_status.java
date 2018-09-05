package ramo.wms.test.domain;

public class S_whs_status {
    private String whs_id;
    private Boolean is_inout;
    private Boolean is_whslock;
    private String lock_id;
    private Boolean whs_wanringid;
    private String env_id;
    private String whs_info;
    private String whs_allvol;
    private String whs_availvol;

    public S_whs_status() {

    }

    public String getWhs_id() {
        return whs_id;
    }

    public void setWhs_id(String whs_id) {
        this.whs_id = whs_id;
    }

    public Boolean getIs_inout() {
        return is_inout;
    }

    public void setIs_inout(Boolean is_inout) {
        this.is_inout = is_inout;
    }

    public Boolean getIs_whslock() {
        return is_whslock;
    }

    public void setIs_whslock(Boolean is_whslock) {
        this.is_whslock = is_whslock;
    }

    public String getLock_id() {
        return lock_id;
    }

    public void setLock_id(String lock_id) {
        this.lock_id = lock_id;
    }

    public Boolean getWhs_wanringid() {
        return whs_wanringid;
    }

    public void setWhs_wanringid(Boolean whs_wanringid) {
        this.whs_wanringid = whs_wanringid;
    }

    public String getEnv_id() {
        return env_id;
    }

    public void setEnv_id(String env_id) {
        this.env_id = env_id;
    }

    public String getWhs_info() {
        return whs_info;
    }

    public void setWhs_info(String whs_info) {
        this.whs_info = whs_info;
    }

    public String getWhs_allvol() {
        return whs_allvol;
    }

    public void setWhs_allvol(String whs_allvol) {
        this.whs_allvol = whs_allvol;
    }

    public String getWhs_availvol() {
        return whs_availvol;
    }

    public void setWhs_availvol(String whs_availvol) {
        this.whs_availvol = whs_availvol;
    }
}
