package ramo.wms.test.domain;

public class E_matl_structure1 {
    private String matl_structid;
    private String matl_structparent;
    private String matl_structname;
    private Boolean is_mulu;
    private String ch_ids;

    public String getCh_ids() {
        return ch_ids;
    }

    public void setCh_id(String ch_ids) {
        this.ch_ids = ch_ids;
    }

    public String getMatl_structid() {
        return matl_structid;
    }

    public void setMatl_structid(String matl_structid) {
        this.matl_structid = matl_structid;
    }

    public String getMatl_structparent() {
        return matl_structparent;
    }

    public void setMatl_structparent(String matl_structparent) {
        this.matl_structparent = matl_structparent;
    }

    public String getMatl_structname() {
        return matl_structname;
    }

    public void setMatl_structname(String matl_structname) {
        this.matl_structname = matl_structname;
    }

    public Boolean getIs_mulu() {
        return is_mulu;
    }

    public void setIs_mulu(Boolean is_mulu) {
        this.is_mulu = is_mulu;
    }
}
