from funciones import *

url = "https://jsonplaceholder.typicode.com/posts"
num = 8

while num != 0:
    num = int(input("""Bienvenido de nuevo, usuario.
    ¿Qué quiere hacer hoy?
    1. Mostrar todos los posts
    2. Mostrar un post concreto
    3. Añadir una nueva publicación
    4. Modificar una publicación
    0. Salir
                    """))

    if num == 1:
        getAllPosts(url)
    elif num == 2:
        numPubl = int(input("Introduzca una publicación (1-100): "))
        getPost(url, numPubl)
    elif num == 3:
        print("Introduzca los datos necesarios: ")
        idPost = int(input("Introduzca el id de la nueva publicación: "))
        title = input("Introduzca el título de la nueva publicación: ")
        body = input("Introduzca el cuerpo de la nueva publicación: ")
        newPost(url, idPost, title, body)
    elif num == 4:
        idPost = int(input("Introduzca una publicación a modificar (1-100): "))
        print("Introduzca los datos necesarios.")
        idPost = int(input("Introduzca el id de la publicación: "))
        idUser = int(input("Introduzca el id del usuario: "))
        title = input("Introduzca el título de la publicación: ")
        body = input("Introduzca el cuerpo de la publicación: ")