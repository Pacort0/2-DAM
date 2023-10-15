num = int(input("Introduzca un número entero positivo: ")) #Pedimos el número por teclado
suma = 0

while not num<0: #Mientras el número introducido no sea menor que 0
    suma += num #sumamos los números entre sí y los guardamos en la variable 'suma'
    num = int(input("Introduzca un número entero positivo: ")) #Pedimos un nuevo número entero positivo

print("La suma de todos los números introducidos es" ,suma) #Mostramos el resultado
 