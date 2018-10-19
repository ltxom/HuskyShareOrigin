$(() => {
    const emailInput = $('#emailInput');
    const emailInvalidDiv = $('.email-invalid');

    const passwordInput = $('#passwordInput');
    const passwordInvalidDiv = $('.password-invalid');

    const confirmPwdInput = $('#confirmPasswordInput');
    const passwordMismatchDiv = $('.password-mismatch');

    const usernameInput = $('#usernameInput');
    const usernameInvalidDiv = $('.username-invalid');

    const firstNameInput = $('#firstNameInput');
    const firstNameInvalidDiv = $('.first-name-invalid');

    const lastNameInput = $('#lastNameInput');
    const lastNameInvalidDiv = $('.last-name-invalid');

    const remindErrorsAlert = $('.remind-errors');

    let isEmailFine = true;
    let isPasswordFine = true;
    let isConfirmPwdFine = true;
    let isUsernameFine = true;
    let isFirstNameFine = true;
    let isLastNameFine = true;

    const allGood = () => isEmailFine && isPasswordFine && isConfirmPwdFine && isUsernameFine && isFirstNameFine && isLastNameFine;

    const tryDismissAlert = () => {
        // try to dismiss the alert of invalid input if possible
        if (isEmailFine && isPasswordFine && isConfirmPwdFine)
            remindErrorsAlert.css('display', 'none');
    };

    const refreshEmailFn = () => {
        validateEmail(emailInput.val()) ? hideErrorLi(emailInvalidDiv) : displayErrorLi(emailInvalidDiv);
        if (!validateEmail(emailInput.val())) {
            isEmailFine = false;
            displayErrorLi(emailInvalidDiv);
        } else {
            isEmailFine = true;
            hideErrorLi(emailInvalidDiv);
            tryDismissAlert();
        }
    };

    const refreshPasswordFn = () => {
        const resObj = validatePassword(passwordInput.val());
        if (!resObj.valid) {
            let problemText;
            switch (resObj.reason) {
                case 'length':
                    problemText = 'Your password should be at least 8 characters long.';
                    break;
                case 'no-upper':
                    problemText = 'Your password should have at least one upper-case letter.';
                    break;
                case 'no-lower':
                    problemText = 'Your password should have at least one lower-case letter.';
                    break;
                case 'no-number':
                    problemText = 'Your password should have at least one number.';
                    break;
                case 'no-special-char':
                    problemText = 'Your password should have at least one special character (e.g. \'-\', \'_\', etc.)';
                    break;
            }
            if (problemText) {
                passwordInvalidDiv.text(problemText);
                isPasswordFine = false;
                displayErrorLi(passwordInvalidDiv);
            } else {
                isPasswordFine = true;
                hideErrorLi(passwordInvalidDiv);
                tryDismissAlert();
                console.error("validatePassword() returned unexpected value.");
            }
        } else {
            isPasswordFine = true;
            hideErrorLi(passwordInvalidDiv);
            tryDismissAlert();
        }
    };

    const refreshConfirmPasswordFn = () => {
        if (passwordInput.val() !== confirmPwdInput.val()) {
            isConfirmPwdFine = false;
            displayErrorLi(passwordMismatchDiv);
        } else {
            isConfirmPwdFine = true;
            hideErrorLi(passwordMismatchDiv);
            tryDismissAlert();
        }
    };

    const refreshUsernameFn = () => {
        if (!usernameInput.val()) {
            isUsernameFine = false;
            displayErrorLi(usernameInvalidDiv);
        } else {
            isUsernameFine = true;
            hideErrorLi(usernameInvalidDiv);
            tryDismissAlert();
        }
    };

    const refreshFirstNameFn = () => {
        if (!firstNameInput.val()) {
            isFirstNameFine = false;
            displayErrorLi(firstNameInvalidDiv);
        } else {
            isFirstNameFine = true;
            hideErrorLi(firstNameInvalidDiv);
            tryDismissAlert();
        }
    };

    const refreshLastNameFn = () => {
        if (!lastNameInput.val()) {
            isLastNameFine = false;
            displayErrorLi(lastNameInvalidDiv);
        } else {
            isLastNameFine = true;
            hideErrorLi(lastNameInvalidDiv);
            tryDismissAlert();
        }
    };

    emailInput.blur(refreshEmailFn);
    passwordInput.blur(refreshPasswordFn);
    confirmPwdInput.blur(refreshConfirmPasswordFn);
    usernameInput.blur(refreshUsernameFn);
    firstNameInput.blur(refreshFirstNameFn);
    lastNameInput.blur(refreshLastNameFn);

    const form = $('#registerForm');
    form.submit((e) => {
        refreshEmailFn();
        refreshPasswordFn();
        refreshConfirmPasswordFn();
        refreshUsernameFn();
        refreshFirstNameFn();
        refreshLastNameFn();
        if (!allGood()) {
            e.preventDefault();
            remindErrorsAlert.css('display', 'inline-block');
        }
    });
});

function displayErrorLi(jqEl) {
    jqEl.css('display', 'list-item');
}

function hideErrorLi(jqEl) {
    jqEl.css('display', 'none');
}
