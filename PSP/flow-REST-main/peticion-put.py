import requests
url = "https://jsonplaceholder.typicode.com/todos/5"

dict = {'userId':2, 'title': "Hacer tareas", 'completed':False}
response = requests.put(url, json=dict)

print("Mensajito de estado: ", response.status_code)
print(response.json())  