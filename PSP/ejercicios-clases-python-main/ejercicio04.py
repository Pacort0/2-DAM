from clases.articulo import *

nabos = Articulo("Nabos frescos", 2, 40)
luisonas = Articulo("Luisonas muy gaming", 500, 10)

print("El PVP de los nabos es", nabos.getPVP(), "euros")
print("El PVP con descuento de los nabos es", nabos.getPVPDescuento(20), "euros")

if not luisonas.vender(20):
    print("No hay suficientes artículos de este tipo en stock como para vender esta cantidad")
    
luisonas.vender(2)

print(luisonas)
print(nabos)