class Libro():
    def __init__(self, titulo, autor, numEjemplares, numPrestados):
        self.titulo = titulo
        self.autor = autor
        self.numEjemplares = numEjemplares
        self.numPrestados = numPrestados

    def prestamo(self):
        res = False
        if self.numPrestados < self.numEjemplares:
            self.numPrestados += 1
            self.numEjemplares -= 1
            res = True
        return res
    
    def devolucion(self):
        res = False
        if self.numPrestados > 0:
            self.numPrestados -= 1
            self.numEjemplares += 1
            res = True
        return res
    
    def __str__(self):
        res = "Título: " + self.titulo + "\n"
        res += "Autor: " + self.autor + "\n"
        res += "Nº Ejemplares: " + str(self.numEjemplares) + "\n"
        res += "Nº Prestados: " + str(self.numPrestados) +"\n"
        return res

    def __eq__(self, object):
        res = False
        if self.titulo == object.titulo and self.autor == object.autor:
            res = True
        return res

    def __lt__(self, object):
        res = False
        if self.autor < object.autor:
            res = True
        return res