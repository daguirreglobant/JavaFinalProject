# JavaFinalProject UML diagram class
![UML diagram class](./UML.png)
¿Por qué utilicé Map? Por la complejidad temporal. 

Para el caso de <strong>Estudiantes</strong><br/>
El acceso por ID es constante O(1) y cada estudiante tiene como atributo una lista de materias inscritas. De esta forma para obtener las materias de un estudiante solo es acceder al ID del estudiante y obtener la lista de materias inscritas (Esta es una mejor solucion cuando el tamaño de estudiantes es muy grande).

Para el caso de <strong>Cursos</strong><br/>
Si tuviera una lista de cursos debo recorrer la lista hasta encontrar el curso que necesito (complejidad O(N)) para agregar al estudiante. Con un map puedo obtener el curso en tiempo constante O(1).
