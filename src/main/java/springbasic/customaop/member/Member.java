package springbasic.customaop.member;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
