# huskyshare_static
Temporary repo for static content in huskyshare.com

Please push to github regularly even if you are editing this on Tom's server, as Github should host the latest content now.

## JavaScript Code Style
JS这个语言在大项目里极其容易搞乱，所以请尽力遵守一下下面一些规范要求：
* 不要用 inline JS. 这样有两个好处:
	1. 用户浏览器可以缓存，加快速度
	2. 页面结构、逻辑、和外观模块化，更容易管理
* 把相关的代码放在同一个文件里。 这样还是确保管理容易，也会减少`<script>`tag顺序不对的可能性
* 不要用 `var`。用更严谨的`let`和`const`代替
* 可以的话，用 `() => {}` 代替 `function`，保留本地scope
