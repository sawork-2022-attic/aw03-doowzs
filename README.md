# WebPOS

MVC架构：

- Model定义数据类型和可以进行的操作（如购物车、商品的定义）
- View描述如何向用户展示数据（如HTML如何展示数据）
- Controller负责处理用户请求，连接Model和View层返回给用户结果（处理业务逻辑，返回一个View模型，注入数据展示结果）

MVC可以把数据和表示分离，三层之间相互独立，提高扩展性。

> The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
> ).
>
> ![](screenshot.png)
>
> To run
>
> ```shell
> mvn clean spring-boot:run
> ```
>
> Currently, it just lists the products for sale with a cart with one item (just for demonstration). 
>
> Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .
>
>
>
> And please elaborate your understanding in MVC architecture via this homework in your README.md.

