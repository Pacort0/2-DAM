class CuentaCorriente():
    def __init__(self, DNI, saldo, nombre):
        self.DNI = DNI
        self.saldo = saldo
        self.nombre = nombre
    def __init_subclass__(self, DNI, saldo):
        self.DNI = DNI
        self.saldo = saldo
        self.nombre = ""
    def __str__(self):
        res = "El DNI del titular es " + self.DNI + "\n"
        res += "El saldo de la cuenta del titular es " + str(self.saldo) + "\n"
        res += "El nombre del titular de la cuenta es " + self.nombre + "\n"
        return res
    def __eq__(self, object):
        res = False
        if self.DNI == object.DNI:
            res=True
        return res
    def __lt__(self, object):
        res = False
        if self.saldo < object.saldo:
            res = True
        return res
    
    def sacarDinero(self, cantidad):
        res = False
        if self.saldo - cantidad >= 0:
            res = True
            self.saldo -= cantidad
        return res
    
    def ingresaDinero(self, cantidad):
        self.saldo += cantidad