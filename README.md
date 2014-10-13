ista de funcionarios Administrativos MEC a través de llamadas WGET
==================================================================

* Crear un directorio donde se ubicarán los archivos.

* Bajar los 3 archivos del github, bajar_paginas, converter.java y Persona.java y ubicarlos en el directorio creado.

Observación: todos los archivos deben encontrarse en el mismo directorio

* Abrir una terminal y ejecutar el script **bajar_paginas**

 `$ sh bajar_paginas.sh 2 2014 06`

Este comando recibe 3 parámetros:
Primer parámetro: cantidad de páginas que tiene la tabla original de la que vamos a extraer los datos,
Segundo parámetro: año,
Tercer parámetro: mes a ser procesado.

* Este comando genera el csv en el mismo directorio con el nombre **funcionarios.csv**.
