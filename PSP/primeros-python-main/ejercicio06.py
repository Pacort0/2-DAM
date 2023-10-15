num = int(input("Introduce un número entero: ")) #Pedimos un número por teclado 
resultado = 1

for numeros in range(2, num+1): #desde el 2 hasta el número insertado, los vamos multiplicando
    resultado *= numeros

print("El factorial de" ,num, "es" ,resultado) #resultado