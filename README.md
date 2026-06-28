# TP2 - Magia y Hechicería: Batalla de Magos vs Mortífagos

Trabajo Práctico N°2 de la materia **Paradigmas de Programación** (1C 2026).

Sistema de combate por turnos entre dos facciones — magos y mortífagos — desarrollado en Java con enfoque en programación orientada a objetos.

## Descripción

Cada facción cuenta con distintos tipos de personajes que poseen hechizos, efectos de estado y consumibles. Los batallones se enfrentan en turnos: cada personaje decide su acción (lanzar un hechizo, usar un consumible o meditar) según su estrategia particular, definida polimórficamente en cada subclase.

## Estructura del proyecto

```
src/
├── app/             Punto de entrada (App, Juego) y ValidadorMana
├── Unidades/        Jerarquía de personajes, Batallon y Factories
├── Hechizos/        Interfaz Hechizo, HechizoBase y hechizos concretos
├── Efectos/         Efecto abstracto y efectos de estado
├── Acciones/        Interfaz Accion y acciones concretas
├── consumible/      Consumible abstracto y pociones/orocrux
├── enums/           Enums de tipos de personaje y hechizo
├── logger/          Logger para salida por consola y archivo
├── Test/            Tests unitarios con JUnit 5
Diagramas/           Diagrama de clases UML (.drawio)
```

## Conceptos aplicados

- **Herencia y polimorfismo**: jerarquía Personaje → Mago/Mortífago → subclases concretas. Cada tipo define su propia estrategia de combate sin uso de `instanceof` en la lógica de negocio.
- **Interfaces**: `Combatiente`, `Hechizo`, `Accion`.
- **Patrón Factory**: `FactoryPersonaje`, `FactoryHechizos`, `FactoryConsumible` centralizan la creación de objetos.
- **Patrón Composite**: `Batallon` puede contener personajes u otros batallones.
- **Patrón Strategy**: cada personaje define su `pensarAccion()` con lógica propia.
- **Colecciones**: `List` para secuencia de ataques, `Set` para control de hechizos por ronda, `Map` para registro histórico de hechizos lanzados por personaje.

## Cómo ejecutar

1. Importar en Eclipse: File → Import → Existing Projects into Workspace → seleccionar la carpeta del proyecto.
2. Asegurar que JUnit 5 esté en el Build Path (Build Path → Add Library → JUnit 5).
3. Ejecutar `src/app/App.java` como Java Application.
4. Los tests se ejecutan desde la carpeta `Test/` con Run As → JUnit Test.

## Tecnologías

- Java 21
- JUnit 5
- Eclipse IDE
