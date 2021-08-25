package WHLive.messages;

public class LoginRequest extends BaseRequest{
    private String tessera;
    private String password;

    LoginRequest(){}

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTessera() {
        return tessera;
    }

    public String getPassword() {
        return password;
    }
}