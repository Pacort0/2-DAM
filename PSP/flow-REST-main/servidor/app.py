from flask import *

app = Flask(__name__)

countries = [
    {"id":1, "name":"Thailand", "capital":"Bangkok", "area":53120},
    {"id":2, "name":"Spain", "capital":"Bienvenida", "area":881293},
    {"id":3, "name":"Francia", "capital":"Madrid", "area":6766666},
]

def _find_next_id():
    return max(country["id"] for country in countries) + 1

# App hace referencia al objeto de tipo Flask creado al inicio
@app.get("/countries")
# Dentro de los paréntesis indicamos la ruta usada para hacer la petición
# Al escribir esa ruta en el navegador se ejecutará la siguiente función
def getCountries():
    # jsonify convierte en formato json la lista que hemos definido
    # como base de datos
    return jsonify(countries)

# A la direccion de countries se le añade la posibilidad
# de indicar un id de un país a mostrar
@app.get("/countries/<int:id>")
# El nombre de esta función debe ser diferente al resto
# Se añade como parámetro el id del país a mostrar
def getCountry(id):
    for country in countries:
        if country["id"] == id:
            # Si se encuentra el país, se devuelve el país + código 200
            return country, 200
    # Si no se encuentra, se manda un mensaje de error
    return {"error" : "Country not found, payaso"}, 404

# Indicamos que la petición es de tipo POST
@app.post("/countries")
# Definimos la función correspondiente
def addCountry():
    # Se comprueba si la petición cumple con el formato json
    if request.is_json:
        # Creamos una variable para guardar el formato json, que coincide con un diccionario
        country = request.get_json()
        # Le indicamos al diccionario country que su nuevo id es el que nos devuelva la siguiente función
        country["id"] = _find_next_id()    
        # Añadimos el nuevo país a la lista
        countries.append(country)
        # Devolvemos el país en formato diccionario junto al código 201
        return country, 201
    # Si la petición no cumple con el formato JSON devuelve un mensaje de error + 415
    return{"error": "METE UN JASON TONTO"} , 415

# Indicamos que la petición es de tipo PUT
# Como tenemos que modificar un país concreto, en la dirección de petición
# se indicará el id del país a modificar
@app.put("/countries/<int:id>")
# Como la función de patch es la misma que la de PUT en este caso, simplemente lo ponemos debajo
@app.patch("/countries/<int:id>")
def modifyCountry(id):
    # Se comprueba que la petición que nos ha llegado cumple con el formato JSON
    if request.is_json:
        # Creamos una variable para guardar el formato JSON
        newCountry = request.get_json()
        # Buscamos por id el pais a modificar
        for country in countries:
            if country["id"] == id:
                # Modificamos todos los atributos del país con los valores indicados en el json
                for element in newCountry:
                    country[element] = newCountry[element]
                # Devolvemos el país como diccionario junto al código 200
                return country, 200
    # Si la petición no cumple con el formato JSON, devuelve un mensaje y código de error
    return {"error":"METE UN JASON NINIOOO"}, 415

# A la dirección de countries de le añade la posibilidad de
# indicar un id que será el id del país a eliminar
@app.delete("/countries/<int:id>")
# El id de la dirección se indica como parámetro de entrada
def delete_country(id):
    # Buscamos en la lista el id del país a eliminar
    for country in countries:
        if country['id'] == id:
            countries.remove(country)
            # Si se encuentra el país, se devuelve el país ya vacío y el código 200
            return "{}", 200
    # Si no se encuentra, se devuelve mensaje de error y 404
    return {"error":"Country not found"}, 404

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5050)