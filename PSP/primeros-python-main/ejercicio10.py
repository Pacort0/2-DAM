num1 = int(input("Introduzca el primer número entero: "))
num2 = int(input("Introduzca el segundo número entero: "))

def numMax (num1, num2):
    max = 0
    if num1>num2:
        max = num1
    else: 
        max = num2
        
    return max

if num1==num2:
    print("Ambos números son el mismo")
else:
    print("El número más mayor es el" ,numMax(num1, num2))