# HuskyShare

## Frontend guide

Frontend: only edit files in `src/main/resources`.

### Directory structure
* `static` - static assets (css, js, image, etc.). They are mapped to `/static/` in the website url.
* `templates` - html files. They will be parsed by Thymeleaf (explained below).
* `templates/fragments` - html fragments. Not to be served standalone. Only to be included in other html files.

### APIs used
* `Thymeleaf` - html template engine. Learn about it [here](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html).
* Not really anything else for now. Maybe `React` later.

## Backend guide
* Backend doesn't need a guide.
