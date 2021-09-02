package WHLive.messages;

public class CreatePGResponse extends BaseResponse {
    private Long id;

    public CreatePGResponse(Long id, boolean isError, String errorMessage ){
        this.id = id;
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
