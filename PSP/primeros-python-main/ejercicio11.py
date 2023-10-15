caracter = input("Introduzca un caracter de entrada: ")

def esVocal(caracter):
    vocal = False
    if caracter == 'a':
        vocal = True
    elif caracter == 'e':
        vocal = True
    elif caracter == 'i':
        vocal = True
    elif caracter == 'o':
        vocal = True
    elif caracter == 'u':
        vocal = True
    else: vocal = False

    return vocal

if esVocal(caracter):
    print("El caracter introducido es una vocal")
else: 
    print("El caracter introducido no es una vocal")