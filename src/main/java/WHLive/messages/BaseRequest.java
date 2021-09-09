package WHLive.messages;

public class BaseRequest {
    private String sessionToken;

    BaseRequest(){}

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
