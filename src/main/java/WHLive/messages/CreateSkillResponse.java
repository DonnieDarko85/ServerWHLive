package WHLive.messages;

import WHLive.model.Skill;

public class CreateSkillResponse extends BaseResponse {
    private Iterable<Skill> skills;

    public CreateSkillResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public CreateSkillResponse(Iterable<Skill> skills) {
        this.skills = skills;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }
}
