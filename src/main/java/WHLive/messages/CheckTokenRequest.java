package WHLive.messages;

public class CheckTokenRequest extends BaseRequest {
    private String token;

    CheckTokenRequest(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
