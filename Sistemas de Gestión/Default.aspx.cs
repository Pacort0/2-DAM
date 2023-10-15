using Microsoft.Ajax.Utilities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace HelloWorld.WebForm
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text;
            if (string.IsNullOrEmpty(nombre))
            {
                lblError.Text = "Introduzca su nombre";
                if(lblSaludo.Text.Length > 0)
                {
                    lblSaludo.Text = "";
                }
            } else { 
                lblSaludo.Text = "Hola " + nombre;
                lblError.Text = "";
            }    
        }
    }
}