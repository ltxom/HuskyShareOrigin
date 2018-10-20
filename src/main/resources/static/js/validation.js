
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

