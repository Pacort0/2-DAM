import requests
url = "http://localhost:5050/countries/3"

dict = {"name":"pedrito"}
response = requests.patch(url, json=dict)

print("Código de estado: ", response.status_code)
print(response.json())