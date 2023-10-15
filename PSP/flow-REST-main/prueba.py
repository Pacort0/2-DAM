import requests
api_url = "https://jsonplaceholder.typicode.com/users/1/todos?id=11"
response = requests.get(api_url)
print('Código de estado: ', response.status_code)
print(response.json())