file = open("numeros.txt", "rt", encoding="utf8")
lista = []
for linea in file.readlines():
    num=int(linea)
    lista.append(num)

print(lista)
#ordeno los números
lista.sort()
file.close()
filew = open("numeros_ordenados.txt", "w", encoding="utf8")

for numero in lista:
    filew.write(str(numero) + "\n")

filew.close