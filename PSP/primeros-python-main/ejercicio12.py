num1 = float(input("Introduzca el primer número real: "))
num2 = float(input("Introduzca el segundo número real: "))

def calculadora(num1, num2):
    resultado = 0
    decision = int(input("""Introduzca una opción: 
                         1. Sumar
                         2. Restar
                         3. Multiplicar
                         4. Dividir: 
                         """))
    
    if decision == 1:
        resultado = num1+num2
    elif decision == 2:
        resultado = num1-num2
    elif decision == 3:
        resultado = num1*num2
    elif decision ==4: 
        resultado = num1/num2
    else: 
        print("La opción introducida no está contemplada")
        
    return resultado

res = calculadora(num1, num2)
print("El resultado de su operación es" ,res)
        