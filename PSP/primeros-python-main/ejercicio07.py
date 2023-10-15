num = int(input("Introduzca un número entero positivo: ")) #Pedimos un número por teclado

def esPrimo(numero): #Creamos la función esPrimo
    primo = True #ponemos la variable booleana 'primo' a 'true'
    for numeros in range(2, num): #desde el 2 hasta el número insertado, comprobamos si son divisibles
        if numero%numeros == 0:
            primo = False #Si son divisibles, ponemos el booleano a false
        break
    return primo #devolvemos el resultado del booleano

primo = esPrimo(num) #llamamos a la funcion
 
if primo: #si es primo
    print("El número introducido es primo")
else: #si no es primo
    print("El número introducido no es primo")
