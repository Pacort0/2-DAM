num1 = int(input("Introduzca el primer número entero: ")) #pedimos el primer número entero por teclado
num2 = int(input("Introduzca el segundo número entero: ")) #pedimos el segundo número entero por teclado

def numerosComprendidos(num1, num2): #creamos una función con ambos números como parámetros
    if num1 > num2 : #si num1 es mayor que num2, cambiamos sus valores
        num1,num2 = num2,num1
    for numeros in range(num1, num2+1): #mostramos los números entre ellos
            print(numeros)
    if num1 == num2: #si no se da ningún caso, son el mismo número
        print("Los números introducidos son iguales")
    
numerosComprendidos(num1, num2) #llamamos a la función