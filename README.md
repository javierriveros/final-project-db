# **Proyectos Fin de Carrera**

La  Escuela de ingeniería quiere generar un sistema para tener controlado en una base de datos todo lo referente a los proyectos de fin de carrera (PFC): alumnos que los realizan, profesores que los dirigen, temas de los que tratan y tribunal que los corrigen. Por tanto, es de interés:
Que los alumnos se definan por su número de matrícula, CI y nombre. Un alumno realiza, evidentemente, sólo un PFC.
Que los PFC se definen por su tema, por un número de orden y por la fecha de comienzo. Un PFC determinado, no puede ser realizado por varios alumnos.

Que un profesor se define por su CI, nombre y domicilio; y puesto que los PFC son del área en el que trabaja, NO interesa conocer el PFC que dirige sino a qué alumno se lo dirige.

Que un tribunal (jurados)  está formado por varios profesores y los profesores pueden formar parte de varios tribunales. Por otra parte, sí es de interés para el tribunal conocer qué alumno es el que se presenta, con qué PFC,  en qué fecha-hora (entrada y salida) y quien lo ha defendido. El tribunal se define por un número de tribunal y un lugar de presentación.
Al margen de esto, un alumno puede haber pertenecido a algún grupo de investigación del que haya surgido la idea del PFC. Dichos grupos se identifican por un número de grupo, su nombre y por su número de componentes. Un alumno no puede pertenecer a más de un grupo y no es de interés saber si el grupo tiene algo que ver o no con el PFC del alumno; siendo de interés la fecha de incorporación a dicho grupo.

Por otra parte, un profesor, al margen de dirigir el PFC de algunos alumnos, puede haber colaborado con otros en la realización de dicho PFC pero siendo otro profesor el que lo dirige. En este caso, sólo es interesante conocer qué profesor ha ayudado a qué alumno (a un alumno le pueden ayudar varios profesores).

### Detalles de la aplicación
* Implementar un módulo de registro y control de proyectos de fin de carrera
* Reporte de proyectos por fecha con información de profesores,  tribunal, fecha de presentación, alumnos y tiempo de duración.
* Reporte de grupo de investigación con sus respectivos integrantes.
* Reporte de profesores colaboradores en trabajos de fin de carrera.
* Reporte de estudiantes con información de profesores  colaboradores y tutores o dirigidos. 
* Implementar un disparador que registre los proyectos que ya fueron evaluados por un tribunal.
* Definir una regla de integridad que cuando se elimine un grupo de investigación se actualicen sus referencias.

### Detalles del desarrollo
* Crear una instancia para el acceso a la base de datos (Singleton)
* Cada tabla o relación de la base de datos debe tener consulta y actualización de datos (CRUD).
* La aplicación debe permitir el ingreso a un usuario administrador, el cual tiene todos los privilegios sobre la base de datos y a un usuario final.

### Entregables
* Aplicación en óptimas condiciones de funcionamiento bajo plataforma Linux y con requerimientos ya mencionados.
* Informe escrito con los siguientes ítems: objetivo, justificación, alcance y modelo entidad relación. 

