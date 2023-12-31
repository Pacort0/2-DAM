﻿namespace biblioteca
{
    public class clsPersona
    {
        #region atributos
        private String nombre;
        private String apellidos;
        #endregion

        #region constructores
        public clsPersona()
        {
            nombre = "";
            apellidos = "";
        }

        public clsPersona(string nombre, string apellidos)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        #endregion

        #region propiedades
        public String Nombre { 
            get { return nombre; } 
            set { nombre = value; } 
        }
        public String Apellidos {  
            get { return apellidos; } 
            set { apellidos = value; } 
        }
        public String NombreCompleto
        {
            get { return $"Su nombre completo es: {nombre} {apellidos}"; }
        } 
        public String Direccion { get; set; }
        #endregion
        #region funciones y metodos
        ///<summary>
        ///Funcion que devuelve la concatenacion del atributo nombre y el atributo apellido
        ///Precondiciones: ninguna
        ///Postcondiciones: primera letra de cada palabra sea mayúscula, que no sea null... etc.
        ///</summary>
        ///<returns>string con el nombre completo</returns>
        public String FuncionNombreCompleto()
        {
            return $"Su nombre completo es: {nombre} {apellidos}";
        }
        #endregion
    }
}