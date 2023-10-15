import requests

def getAllPosts(url):
    response = requests.get(url)
    lista = response.json()
    for diccionario in lista:
        for clave in diccionario:
            print(clave, ":", diccionario[clave])
        print()

def getPost(url, numPubl):
    response = requests.get(url+"/"+str(numPubl))
    if response.status_code == 200:
        diccionario = response.json()
        for clave in diccionario:
            print(clave,":", diccionario[clave])
        print()
    else:
        print("La petición no ha terminado correctamente. Código:", response.status_code)

def newPost(url, userId, title, body):
    todo = {"userId":userId, "title":title, "body":body}
    response = requests.post(url, json=todo, timeout=None)
    if response.status_code == 201:
        diccionario = response.json()
        for clave in diccionario:
            print(clave,":",diccionario[clave])
        print()
    else: print(response.status_code)

def modifyPost(url, userId, id, title, body):
    todo = {"userId":userId, "id":id, "title":title, "body":body}
    response = requests.put(url+"/"+id, json=todo)
    print(response.status_code)
    if response.status_code == 200:
        diccionario = response.json()
        for clave in diccionario:
            print(clave,":",diccionario[clave])
        print()
    else: print(response.status_code)
        