package WHLive.messages;

import WHLive.model.User;

public class GetAllUsersResponse extends BaseResponse {
    private Iterable<User> users;

    public GetAllUsersResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public GetAllUsersResponse(Iterable<User> users) {
        this.users = users;
    }

    public Iterable<User> getUsers() {
        return users;
    }

    public void setUsers(Iterable<User> users) {
        this.users = users;
    }
}
