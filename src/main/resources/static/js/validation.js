function validateEmail(text) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(text).toLowerCase());
}

function validatePassword(text) {
    // too short
    if (text.length < 8)
        return {
            valid: false,
            reason: 'length',
        };

    let hasUpper = false;
    let hasLower = false;
    let hasNumber = false;
    let hasSpecialChar = false;

    for (const c of text) {
        if ($.isNumeric(c)) {
            hasNumber = true;
        } else if (c.toUpperCase() !== c.toLowerCase()) {
            // is letter
            if (c.toUpperCase() === c)
                hasUpper = true;
            else
                hasLower = true;
        } else {
            // must be special char
            hasSpecialChar = true;
        }
    }

    if (!hasUpper) {
        return {
            valid: false,
            reason: 'no-upper',
        };
    }

    if (!hasLower) {
        return {
            valid: false,
            reason: 'no-lower',
        };
    }

    if (!hasNumber) {
        return {
            valid: false,
            reason: 'no-number',
        };
    }

    if (!hasSpecialChar) {
        return {
            valid: false,
            reason: 'no-special-char',
        };
    }

    return {
        valid: true,
    };
}

class Validator {
    constructor($remindErrorDiv, defaultErrorFn, defaultClearFn) {
        this.$remindErrorDiv = $remindErrorDiv;
        // Don't modify these
        this.inputElements = [];
        this.errorElements = [];
        this.validationFns = [];
        this.defaultErrorFn = defaultErrorFn || function ($el) {
            $el.css('display', 'list-item');
        };
        this.defaultClearFn = defaultClearFn || function ($el) {
            $el.css('display', 'none');
        };
    }

    registerInput($inputEl, $errorEl, isValid) {
        const currLen = this.inputElements.length;
        $inputEl.blur(() => {
            if (this.refresh(currLen, true) && this.refreshAll()) {
                this.$remindErrorDiv.css('display', 'none'); // clear error reminder
            }
        });
        this.inputElements.push($inputEl);
        this.errorElements.push($errorEl);
        this.validationFns.push(isValid || notEmpty);
    }

    registerForm($formEl) {
        $formEl.submit((e) => {
            if (!this.refreshAll(true)) {
                e.preventDefault();
                this.$remindErrorDiv.css('display', 'block');
            }
        });
    }

    // returns true if all inputs are valid
    refreshAll(displayErrors) {
        let allGood = 1;
        for (let i = 0; i< this.inputElements.length; i++) {
            allGood &= this.refresh(i, displayErrors);
        }
        return allGood;
    }

    refresh(i, displayError) {
        if (this.validationFns[i](this.inputElements[i])) {
            this.defaultClearFn(this.errorElements[i]);
            return true;
        } else {
            if (displayError)
                this.defaultErrorFn(this.errorElements[i]);
            return false;
        }
    }
}

function notEmpty($el) {
    return !!$el.val();
}