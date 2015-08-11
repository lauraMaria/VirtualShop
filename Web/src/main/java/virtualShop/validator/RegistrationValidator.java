package virtualShop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import virtualShop.dto.UserDTO;
import virtualShop.view_model.RegistrationViewModel;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class RegistrationValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return RegistrationViewModel.class.equals(aClass);
    }

    public void validate(Object object, Errors errors) {
        ValidationUtils
                .rejectIfEmpty(errors, "firstName", "required.firstName");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName");
        ValidationUtils.rejectIfEmpty(errors, "username", "required.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confPassword",
                "required.confPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confEmail", "required.confEmail");

        RegistrationViewModel newRegistration = (RegistrationViewModel) object;

        if (newRegistration.getUsername().length() < 5) {
            errors.rejectValue("userName", "length.username");
        }

        if (newRegistration.getPassword().length() < 5) {
            errors.rejectValue("password", "length.password");
        }

        if (!(newRegistration.getPassword().equals(newRegistration
                .getConfPassword()))) {
            errors.rejectValue("password", "notmatch.password");
        }

        if (!(newRegistration.getEmail().equals(newRegistration.getConfEmail()))) {
            errors.rejectValue("email", "notmatch.email");
        }
    }
}
