package ramo.wms.test.domain;

public class E_ch_authority {
    private int ch_id;
    private String ch_authorityname;
    private String authority_ids;

    public String getAuthority_ids() {
        return authority_ids;
    }

    public void setAuthority_ids(String authority_ids) {
        this.authority_ids = authority_ids;
    }

    public int getCh_id() {
        return ch_id;
    }

    public void setCh_id(int ch_id) {
        this.ch_id = ch_id;
    }

    public String getCh_authorityname() {
        return ch_authorityname;
    }

    public void setCh_authorityname(String ch_authorityname) {
        this.ch_authorityname = ch_authorityname;
    }

    public int getAutority_id() {
        return autority_id;
    }

    public void setAutority_id(int autority_id) {
        this.autority_id = autority_id;
    }

    private int autority_id;

}

