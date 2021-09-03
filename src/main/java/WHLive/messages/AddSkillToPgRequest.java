package WHLive.messages;

import java.util.List;

public class AddSkillToPgRequest extends BaseRequest {
    private List<Long> skills;

    AddSkillToPgRequest(){}

    public List<Long> getSkills() {
        return skills;
    }

    public void setSkills(List<Long> skills) {
        this.skills = skills;
    }
}
