import requests
url = "http://localhost:5050/countries"

dict = {"name":"Italy", "capital":"Segovia", "area":97612378941}
response = requests.post(url, json=dict)

print("Código de estado: ", response.status_code)
print(response.json())