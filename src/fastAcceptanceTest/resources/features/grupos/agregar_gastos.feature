# language: es

Característica: Agregar gastos a un grupo

  Regla: El total del grupo debe ser mayor o igual a 0

    Escenario: No puedo setear el total en negativo
      Dado un grupo con total 0
      Cuando el usuario intenta setear el total en -1
      Entonces el total del grupo será 0
      Y se notifica el error

    Escenario: Puedo agregar gasto a un grupo si el total queda positivo
      Dado un grupo con total 1000
      Cuando el usuario intenta agregar un gasto de -999
      Entonces el total del grupo será 1

    Escenario: Puedo agregar gasto a un grupo si el total queda cero
      Dado un grupo con total 1000
      Cuando el usuario intenta agregar un gasto de -1000
      Entonces el total del grupo será 0

    Escenario: No puedo agregar gasto a un grupo si el total queda negativo
      Dado un grupo con total 1000
      Cuando el usuario intenta agregar un gasto de -1001
      Entonces el total del grupo será 1000
      Y se notifica el error

