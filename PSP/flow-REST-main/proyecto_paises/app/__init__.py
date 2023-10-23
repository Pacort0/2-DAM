"""Module providing a function printing python version."""
from flask import *
from .countries.routes import countriesBP

app = Flask(__name__)

app.register_blueprint(countriesBP, url_prefix="/countries")
