# TorneoDeFrescas
Trabajo practico Torneo de Frescas

Reglas del Juego
Bebe el vikingo y el espartano. Ambos tienen una tolerancia random a la cerveza la cual es potenciada tambien de manera random. Si el personaje bebe mas de su tolerancia corre al baño y es descalificado. Cuando uno de los dos equipos se queda sin participantes pierde.

Teoria
¿Que es Maven? Maven es un framework de administración de proyectos; en otras palabras, una herramienta que automatiza el proceso de construcción de un proyecto Java.
Provee un conjunto de estándares de construcción, un modelo de repositorio de artefactos y un motor de software que administra y describe los proyectos. Por ejemplo, teniendo en cuenta la naturaleza interdependiente de proyectos open source, Maven permite normalizar ubicaciones para los archivos fuente, documentación y archivos binarios, para proveer una plantilla común para la documentación de proyecto y recuperar dependencias de proyecto de un repositorio compartido, de tal forma que el proceso de construcción consume menos tiempo y es mucho más transparente.
POM que significa y para que sirve. POM significa Project Object Model y es utilizado para describir el proyecto de software a construir, sus dependencias de otros módulos y componentes externos, y el orden de construcción de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado.
Diferencia entre Archetipe y Artifacid. La diferencia entre arquetipo y artifact es que el primero se encarga de crear la estructura y la configuracion inicial del proyecto mientras que el segundo es la unidad minima que maneja el repositorio. Estos son agrupados e identificados mediante un ID propio y de grupo, ademas de una version y un clasificador. Estos son administrados en el pom.
Goals
mvn clean: limpia todas las clases compiladas del proyecto 
mvn compile: compila el proyecto 
mvn package: realiza el empaquetado del proyecto. En el caso de que sea un proyecto simple genera una .jar 
mvn install: instala el artefacto en el repositorio local
Scopes
compile: Si no se especifica Scope esta por defecto. Indica que la dependencia es necesaria para poder compilar. Ademas, la dependencia se propaga en los proyectos dependientes. 
provided: Es como compile pero espera que el contenedor ya tenga la libreria. 
runtime: Esta dependencia es necesaria en tiempo de ejecucion pero no para compilar 
test: Esta dependencia es solo para testing 
system: Es como provided pero hay que incluir la dependencia explicitamente. Maven no va a realizar la busqueda en su repositorio local. Hay que expecificar la ruta de la dependencia con la etiqueta 
import: Es utilizado para importar otras dependencias.

