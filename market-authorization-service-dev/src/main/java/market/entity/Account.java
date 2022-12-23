package market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password_hash")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "role", referencedColumnName = "authority", nullable = false)
    private Role role;

    @Column(name = "is_blocked")
    @DefaultValue("false")
    private Boolean isBlocked;
}

