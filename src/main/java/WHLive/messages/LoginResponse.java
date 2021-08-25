package WHLive.messages;

public class LoginResponse extends BaseResponse{
    private String authToken;
    private String sessionToken;
    private int tessera;
    private String firstName;
    private String lastName;

    public LoginResponse(String authToken, String sessionToken, int tessera, String firstName, String lastName) {
        this.authToken = authToken;
        this.tessera = tessera;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sessionToken = sessionToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String token) {
        this.authToken = token;
    }

    public int getTessera() {
        return tessera;
    }

    public void setTessera(int tessera) {
        this.tessera = tessera;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
