package ramo.wms.test.domain;

public class E_login {
    private Integer logintl_id;
    private String user_name;
    private String  user_password;
    private String  login_source;
    private int ch_id;
    private Boolean is_online;
    private String image_file;
    private  String nickname;
    private String  phone;
    private String   email;
    private int dept_id;

    public Integer getLogintl_id() {
        return logintl_id;
    }

    public void setLogintl_id(Integer logintl_id) {
        this.logintl_id = logintl_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getLogin_source() {
        return login_source;
    }

    public void setLogin_source(String login_source) {
        this.login_source = login_source;
    }

    public int getCh_id() {
        return ch_id;
    }

    public void setCh_id(int ch_id) {
        this.ch_id = ch_id;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public String getImage_file() {
        return image_file;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
}
