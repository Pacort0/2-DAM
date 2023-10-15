from clases.punto import *

punto1 = Punto(1,5)
punto2 = Punto(8,-2)

punto1.desplaza(2,7)

distancia = punto1.distancia(punto2)

print(punto1)
print("La distancia entre el punto 1 y el punto 2 es", distancia)