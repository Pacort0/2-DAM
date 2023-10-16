from flask import *

app = Flask(__name__)

countries = [
    {"id":1, "name":"Thailand", "capital":"Bangkok", "area":53120},
    {"id":2, "name":"Spain", "capital":"Bienvenida", "area":881293},
    {"id":3, "name":"Francia", "capital":"Madrid", "area":6766666},
]

def _find_next_id():
    return max(country["id"] for country in countries) + 1

@app.get("/countries")

def getCountries():
    return jsonify(countries)

@app.get("/countries/<int:id>")
def getCountry(id):
    for country in countries:
        if country["id"] == id:
            return country, 200
    return {"error" : "Country not found, payaso"}, 404

@app.post("/countries")
def addCountry():
    if request.is_json:
        country = request.get_json()
        country["id"] = _find_next_id()
        countries.append(country)
        return country, 201
    return{"error": "METE UN JASON TONTO"} , 415

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5050)