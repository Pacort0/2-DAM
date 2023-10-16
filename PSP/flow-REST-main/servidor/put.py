import requests
url = "http://localhost:5050/countries/3    "

dict = {"name":"Norway", "capital":"Guadalete", "area":87263}
response = requests.put(url, json=dict)

print("Código de estado: ", response.status_code)
print(response.json())