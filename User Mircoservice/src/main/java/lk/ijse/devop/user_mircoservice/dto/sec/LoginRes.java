package lk.ijse.devop.user_mircoservice.dto.sec;

public class LoginRes {
    private String email;
    private String token;

    public LoginRes(String email) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
