from clases.libro import *

libro1 = Libro("Don Pijote", "Cervantes", 10, 5)
libro2 = Libro("El pajarillo de Forbes", "Anónimo Veneciano", 20, 25)

libro1.prestamo()
libro2.devolucion()

if libro2.__eq__(libro1):
    print("El pajarillo de Forbes y Don Pijote SON LO MISMO")
else: 
    print("Los libros presentados son completamente diferentes")

print(libro1)
print(libro2)