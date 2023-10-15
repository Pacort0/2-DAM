import math

class Punto():
    def __init__(self, ejeX, ejeY):
        self.ejeX = ejeX
        self.ejeY = ejeY
        
    def __str__(self):
        res = str((self.ejeX, self.ejeY))
        return res
    
    def setXY(self, ejeX, ejeY):
        self.ejeX = ejeX
        self.ejeY = ejeY
    
    def desplaza(self, dX, dY):
        self.ejeX += dX
        self.ejeY += dY
    
    def distancia(self, object):
        d = math.sqrt((object.ejeY**2 - self.ejeX**2) + (object.ejeX**2 - self.ejeY**2))
        return d