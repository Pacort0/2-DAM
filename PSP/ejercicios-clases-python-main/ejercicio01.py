from clases.CuentaCorriente import *

cuenta1 = CuentaCorriente("29765432K", 50.00, "Franciscock")
cuenta2 = CuentaCorriente("29765432K", 100, "Luisona")

cuenta1.ingresaDinero(35)
if cuenta1.sacarDinero(65):
    print("La retirada de dineros se ha realizado con éxito")

if cuenta1.__eq__(cuenta2):
    print("Luisa me suplanta la identidad socorran")
    
if cuenta1.__lt__(cuenta2):
    print("Luisa es rica")

print(cuenta1)

