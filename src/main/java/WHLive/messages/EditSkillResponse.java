package WHLive.messages;

import WHLive.model.Skill;

public class EditSkillResponse extends BaseResponse {
    private Iterable<Skill> skills;

    public EditSkillResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public EditSkillResponse(Iterable<Skill> skills) {
        this.skills = skills;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }
}
