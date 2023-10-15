import random #Importamos el paquete 'random' 

numRandom = random.randint(1, 99) #Creamos un número aleatorio entre 1 y 99 incluyendo ambos

print("""Bienvenid@ al juego del número mágico.
Si en algún momento deseas rendirte, introduce -1""") 

num = int(input("Introduzca un número entero entre el 1 y el 100: ")) #Pedimos que se introduzca un número por teclado

while not num==-1 and not num==numRandom: #Mientras el número no sea -1 y no sea el mismo que el número aleatorio
    if num > numRandom: #si el número introducido es mayor que el aleatorio
        print("EL NÚMERO QUE BUSCAS ES MENOR")
    else: #Si es menor
        print("EL NÚMERO QUE BUSCAS ES MAYOR") 
    
    num = int(input("Introduzca un número entero entre el 1 y el 100: ")) #Pedimos de nuevo un número por teclado
    
if num == numRandom: #Si se ha acertado el número
    print("Enhorabuena, has ganado, el número era" ,numRandom)
else: #Si el usuario se ha rendido
    print("Vaya, qué feo que te hayas rendido...")
