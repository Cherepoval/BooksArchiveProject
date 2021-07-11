package cherepoval.springFramework.BooksArchive.registration;

import cherepoval.springFramework.BooksArchive.app_user.AppUser;
import cherepoval.springFramework.BooksArchive.app_user.AppUserRole;
import cherepoval.springFramework.BooksArchive.app_user.AppUserService;
import cherepoval.springFramework.BooksArchive.registration.token.ConfirmationToken;
import cherepoval.springFramework.BooksArchive.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpNewUser(new  AppUser(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(),
                AppUserRole.USER
        ));
    }
@Transactional
    public String confirmToken(String token){
    ConfirmationToken confirmationToken = confirmationTokenService.
                getToken(token).orElseThrow(()-> new IllegalStateException("token not found"));
        if (confirmationToken.getConfirmationTime() != null){
            throw  new IllegalStateException("email already confirmed");
        }
        confirmationTokenService.setConfirmationTime(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
