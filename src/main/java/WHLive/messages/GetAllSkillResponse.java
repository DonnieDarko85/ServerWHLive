package WHLive.messages;

import WHLive.model.Skill;

public class GetAllSkillResponse extends BaseResponse {
    private Iterable<Skill> skills;

    public GetAllSkillResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public GetAllSkillResponse(Iterable<Skill> skills) {
        this.skills = skills;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }
}
