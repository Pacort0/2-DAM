from flask import *

fichero = ".countries/countries.json"

def leeFichero():
    archivo=open(fichero, "r")
    countries=json.load(archivo)
    archivo.close()
    return countries


def escribeFichero(countries):
    archivo=open(fichero, "w")
    json.dump(countries,archivo)
    archivo.close

def _find_next_id():
    countries = leeFichero()
    return max(country["id"] for country in countries) + 1