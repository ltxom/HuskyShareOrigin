# HuskyShare

## Frontend guide

Frontend: only edit files in `src/main/resources`.

### Important notes
Add an attribute id="pageTitle" to all `title` tags in order for base.html to replace it.

### Directory structure
* `css`, `js`, `img`, etc. - static resource files.
* `templates` - html files. They will be parsed by Thymeleaf (explained below).
* `templates/fragments` - html fragments. Not to be served standalone. Only to be included in other html files.

### APIs used
* `Thymeleaf` - html template engine. Learn about it [here](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html).
* Not really anything else for now. Maybe `React` later.

## Backend guide
* Backend doesn't need a guide.
