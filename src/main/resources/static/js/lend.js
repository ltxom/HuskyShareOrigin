$(() => {
    const nameInput = $('#nameInput');
    const categoryInput = $('#categoryInput');
    const priceInput = $('#priceInput');
    const form = $('#lend-form');

    const val = new Validator($('.remind-errors'));
    val.registerInput(nameInput, $('.name-invalid'));
    val.registerInput(categoryInput, $('.category-invalid'), ge0);
    val.registerInput(priceInput, $('.price-invalid'), ge0);
    val.registerForm(form);
});

function ge0($jqEL) {
    return !!$jqEL.val() && $jqEL.val() >= 0;
}