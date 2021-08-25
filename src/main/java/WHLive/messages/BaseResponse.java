package WHLive.messages;

public abstract class BaseResponse {
    private boolean isError;
    private String errorMessage;

    public boolean isError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        isError = isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
