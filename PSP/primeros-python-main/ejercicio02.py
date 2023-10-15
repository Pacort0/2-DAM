num1 = int(input("Introduce el primer número entero: ")) #Pedimos el primer número entero por teclado
num2 = int(input("Introduce el segundo número entero: ")) #Pedimos el segundo número entero 

if num1>num2: #Si el primer número es mayor que el segundo
    print(num1, ">" ,num2)
elif num2>num1: #Si el segundo número es mayor que el primero
    print(num2, ">" ,num1)
else: print(num1, "=" ,num2) #Si no ocurre ninguno de los dos casos, son el mismo número