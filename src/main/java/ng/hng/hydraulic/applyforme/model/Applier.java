package ng.hng.hydraulic.applyforme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a user or member of the system who submits application on behalf of a developer
 * or professional. Applier can be an Agent or Reverse Recruiter.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APPLIER")
public class Applier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="professional_id")
    private Professional professional;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
    private Set<Submission> submissions = new HashSet<>();
}
