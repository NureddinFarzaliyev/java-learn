# Beans in Spring Boot

This example shows how to use beans in spring boot.

`ColorsApplication`, which is a `@SpringBootApplication` has a dependency of `ColorPrinter` in its constructor.
So, Spring Boot Component Scanning tries to find a bean (which should be annotated with `@Component`) that implements `ColorPrinter` interface.
After finding it, attaches this bean to the `ColorsApplication`.

Same process is conducted for the dependencies of `ColorPrinter` itself.
