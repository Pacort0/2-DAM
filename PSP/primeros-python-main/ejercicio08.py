altura = int(input("Introduce la altura de la pirámide: ")) #pedimos por teclado la altura de la pirámide

for i in range(1, altura+1): #recorremos todos los pisos de la pirámide
    print (" "*(altura-i) + "* " * i) 
   
   
   
   
   
   
   #Así lo planteé yo (estaba bien también)
   
   #for espacio in range(1, (altura-i)+1): #El número de los espacios que debemos insertar por línea es inversamente proporcional 
                                           #al número de asteriscos que va a haber en cada una 
   #     print(end="  ") #La función "print()" acaba por defecto en "\n", por lo que usamos "end= para acabar la línea de otra manera, 
                        #en este caso, agregando espacios"

    #while not i==0: #Mientras queden asteriscos por colocar, se seguirá recorriendo este bucle
    #    print("*", end="   ")
    #    i -= 1
    
   # print()