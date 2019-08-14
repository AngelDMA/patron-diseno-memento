# Patrón de diseño: Memento
Este patrón de diseño permite almacenar instancias de un objeto en particular (mementos), para que puedan ser recuperados en un futuro en caso de ser necesario, a continuación podemos ver el diseño básico de este patrón de diseño:

![Memento](https://www.tutorialspoint.com/design_pattern/images/memento_pattern_uml_diagram.jpg)

En general tendremos 3 clases principales:
- Originator
- Memento
- CareTaker

## Originator
Es el objeto desde el cual se cambia el estado.

## Memento
Almacena el estado del originator en un momento dado

## Caretaker
Registra los cambios del originator, nos permite recuperar algún estado del originator.

Desde el "cliente" se guarda el estado en el originator, este originator almacena el estado del originator, desde el "cliente" se guarda el originator en el caretaker para poder ser recuperado cuando sea pertinente, se puede en el caretaker, almacenar los originator's en una lista, para poder almacenar varios, de lo contrario solo se podría almacenar uno.

## Ventajas
- Poder recuperar una versión desedada del sistema en algún momento dado.
- La encapsulación del sistema sigue permaneciendo a pesar de los cambios.

## Desventajas
- A mayor número de mementos, mayor será el espacio de almacenamiento, por lo que puede que no sea conveniente para todas las aplicaciones, o se deba de colocar un máximo número de estados a guardar.
- A mayor cantidad de veces que se desee guardar el estado de un sistema, menor rendimiento de la aplicación.
