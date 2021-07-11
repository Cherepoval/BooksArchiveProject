package cherepoval.springFramework.BooksArchive.registration.token;

import cherepoval.springFramework.BooksArchive.app_user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime creationTime;
    @Column(nullable = false)
    private LocalDateTime expiryTime;
    private LocalDateTime confirmationTime;

    @ManyToOne
    @JoinColumn(nullable = false,
                name = "app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime creationTime,
                             LocalDateTime expiryTime, AppUser appUser) {
        this.token = token;
        this.creationTime = creationTime;
        this.expiryTime = expiryTime;
        this.appUser = appUser;
    }
}