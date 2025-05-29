DESCRIPCION
********************************************************************************************************************************
Este proyecto es una automatizacion realizada a la pagina saucedemo como parte de la formacion como automate testing esta automatizacion combina la potencia de serenity
con la claridad de cucumber y la estructura limpia y mantenible de screenplay. Esta diseñado para facilitar la creacion, ejecucion y mantenimiento de pruebas automatizadas
de alta calidad 
********************************************************************************************************************************
TECHNOLOGIES

[JDK java] version 1.8
[Gradle] 8.11
[Selenium] 4.10.0
[Cucumbre] 7.16.0
[JUnit] 5.10.0

******************************************************************************************************************************
ESTRUCTURA DEL PROYECTO

El proyecto se desarrollo bajo el patron screenplay el cual obedece al siguiente esquema:

Los casos de prueba se describen en la ruta src/test/resources/features en los archivos .feature en el formato Given-When-Then, donde cada uno de los tres pasos que lo componen redireccionan a la definicion de los pasos.

Dentro de las clases Java de definición de pasos, cada uno de los pasos involucrados en su ejecución se describe utilizando las tareas especificadas en la ruta src/main/java/co/com/servicio/task  donde estas tareas y definiciones de pasos a su vez hacen uso de widgets descritos en clases UI de Java especificadas en la ruta src/main/java/co/com/servicio/userinterface  Algunas tareas también utilizan acciones generales descritas en la ruta src/main/java/co/com/servicio/actions. En la definición de los pasos de validación denotados por el decorador @Then o en las validaciones intermedias en los pasos de acción denotados con el decorador @When, se utilizan clases de preguntas de Java para realizar validaciones

Al ejecutar casos de prueba de tipo Front o E2E, el proyecto descargará automáticamente la versión más reciente del driver de Chrome según el sistema operativo donde se esté ejecutando. Si esta operación de descarga falla, se envía a la ruta src/test/resources/webdriver, estos drivers deben ser actualizados manualmente por el automator. Estos drivers se pueden descargar desde la página oficial de descarga de Chromium.

La ejecución de los casos de prueba se ordena por las clases Java de runners descritas en la ruta src/test/java/co/com/servicio/runners.

*************************************************************************************************************************
INSTALACION Y EJECUCION

Para ejecutar está aplicación, necesitas Gradle and Java JDK instalados en tu equipo, ten en cuenta que tu IDE puede gestionar la instalación de estos dos requerimientos. Desde la linea de comando:

gradle clean build
