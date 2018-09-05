package ramo.wms.test.domain;



public class S_whs_record {
    private int recordtl_id;
    private String whs_id;
    private String matl_id;
    private String difference1;
    private String difference2;
    private int quantity;
    private String danwei;
    private String wh_intime;
    private Boolean is_matllock;
    private String lock_id;
    private String pr_id;
    private int matl_statusid;
    private String picihao;


    public int getRecordtl_id() {
        return recordtl_id;
    }

    public void setRecordtl_id(int recordtl_id) {
        this.recordtl_id = recordtl_id;
    }

    public String getWhs_id() {
        return whs_id;
    }

    public void setWhs_id(String whs_id) {
        this.whs_id = whs_id;
    }

    public String getMatl_id() {
        return matl_id;
    }

    public void setMatl_id(String matl_id) {
        this.matl_id = matl_id;
    }

    public String getDifference1() {
        return difference1;
    }

    public void setDifference1(String difference1) {
        this.difference1 = difference1;
    }

    public String getDifference2() {
        return difference2;
    }

    public void setDifference2(String difference2) {
        this.difference2 = difference2;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getWh_intime() {
        return wh_intime;
    }

    public void setWh_intime(String wh_intime) {
        this.wh_intime = wh_intime;
    }

    public Boolean getIs_matllock() {
        return is_matllock;
    }

    public void setIs_matllock(Boolean is_matllock) {
        this.is_matllock = is_matllock;
    }

    public String getLock_id() {
        return lock_id;
    }

    public void setLock_id(String lock_id) {
        this.lock_id = lock_id;
    }

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    public int getMatl_statusid() {
        return matl_statusid;
    }

    public void setMatl_statusid(int matl_statusid) {
        this.matl_statusid = matl_statusid;
    }

    public String getPicihao() {
        return picihao;
    }

    public void setPicihao(String picihao) {
        this.picihao = picihao;
    }
}
