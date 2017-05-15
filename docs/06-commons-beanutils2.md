<!-- .slide: data-background="img/background-dark-orig.jpg" data-state="intro" class="center" -->
## Component <!-- .element: class="heading" style="text-align: center;"-->
### Apache Commons BeanUtils2 <!-- .element: class="heading" style="text-align: center;"-->

---

### Overview

- Java reflection has always been a PITA
- BeanUtils provides some help
- But: very old school API
- BeanUtils2 as complete rewrite

---

### Fluent API

```
import static org.apache.commons.beanutils2.BeanUtils.on;

on(person).set("firstName").with("Peter")
          .set("lastName").with("Parker")
          .copyPropertiesTo(another);
```

---

### Creating new instances

```
import static org.apache.commons.beanutils2.BeanUtils.onClassName;

Person person = onClassName("com.example.Person")
          .loadWithThreadContextClassLoader()
          .newInstance()
          .get()
```

Note:
- Variants for passing arguments to constructors

---

### Exception wrapper

- Wraps all exceptions thrown by java.reflect API
- `BeanReflectionException` as base exception

```
try {
  on(person).set("firstName").with("Peter");
} catch (BeanPropertyNotWritableException) {
  // oh oh, this property does not have a setter!
} catch (BeanReflectionException) {
  // something else went wrong...
}
```

---

### Current development

- API for registering converters
- Or should we better finalize Commons Convert first?
- Do we still need the DynaBean API?
