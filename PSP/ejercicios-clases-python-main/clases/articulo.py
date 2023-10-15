class Articulo():
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        self.iva = 21

    def getPVP(self):
        return self.precio + (self.precio*self.iva/100)
    
    def getPVPDescuento(self, descuento):
        return self.getPVP() - (self.getPVP()*descuento/100)
    
    def vender(self,cantidad):
        res = False
        if cantidad <= self.stock:
            self.stock -= cantidad
        return res
    
    def almacenar(self, cantidad):
        self.stock += cantidad

    def __str__(self):
        res = "Nombre: " + self.nombre + "\n"
        res += "Precio: " + str(self.precio) + "\n"
        res += "Cantidad: " + str(self.stock)
        return res
    
    def __eq__(self, object):
        res = False

        if self.nombre == object.nombre:
            res = True
        return res
    
    def __lt__(self, object):
        res = False

        if self.nombre < object.nombre:
            res = True
        return res