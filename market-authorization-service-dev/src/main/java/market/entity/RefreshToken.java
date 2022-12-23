package market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken implements Serializable {

    private static final int EXPIRATION = 30 * 60 * 24;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "account_id")
    private Account account;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public RefreshToken(RefreshToken token) {
        this.token = String.valueOf(token);
        expiryDate = token.getExpiryDate();
    }

}

