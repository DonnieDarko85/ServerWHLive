package WHLive.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="pg_skill")
public class PgSkill {
    private Long id;
    private Pg pg;
    private Skill skill;
    private Date acquireDate;

    @Id
    @SequenceGenerator(name = "pgSkillSeqGen", sequenceName = "pgSkillSeq", initialValue = 1000, allocationSize = 100)
    @GeneratedValue(generator = "pgSkillSeqGen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_id")
    public Pg getPg() {
        return pg;
    }

    public void setPg(Pg pg) {
        this.pg = pg;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Column(name = "acquire_date")
    public Date getAcquireDate() {
        return acquireDate;
    }

    public void setAcquireDate(Date acquireDate) {
        this.acquireDate = acquireDate;
    }
}