# HuskyShare

## Frontend guide

Frontend: only edit files in `src/main/resources`.

### Important notes
Start all page templates with the following code:
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <th:block th:include="fragments/base :: head"/>
    <title id="pageTitle">Page title</title>
    <!-- other stuff to add -->
</head>
```
Add the page title (without suffix " | HuskyShare" as it is added by default), and
add other stuff such as css below \<title\>.

### Directory structure
* `css`, `js`, `img`, etc. - static resource files.
* `templates` - html files. They will be parsed by Thymeleaf (explained below).
* `templates/fragments` - html fragments. Not to be served standalone. Only to be included in other html files.

### APIs used
* `Thymeleaf` - html template engine. Learn about it [here](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html).
* Not really anything else for now. Maybe `React` later.

## Backend guide
* Backend doesn't need a guide.
