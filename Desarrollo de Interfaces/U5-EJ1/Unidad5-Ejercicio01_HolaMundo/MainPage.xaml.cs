using biblioteca;

namespace Unidad5_Ejercicio01_HolaMundo
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Método que se acciona cuando hacemos click en el botón de "Introducir apellidos". 
        /// Se guarda el texto introducido en el campo como nombre y se muestra un prompt en el que introducir los apellidos
        /// Se guardan los apellidos introducidos y se muestran junto con el nombre en un mensaje emergente
        /// Precondiciones: Los campos de nombre y apellidos no pueden estar vacíos
        /// Postcondiciones: Ninguna
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private async void OnApellidosClicked(object sender, EventArgs e)
        {
            clsPersona persona = new clsPersona();
            persona.Nombre = txtNombre.Text;
            persona.Apellidos = await DisplayPromptAsync("Apellidos", "Ingrese sus apellidos");
            if (!string.IsNullOrWhiteSpace(persona.Apellidos) && !string.IsNullOrWhiteSpace(persona.Nombre))
            {
                await DisplayAlert("Hola", "Saludos " + persona.NombreCompleto, "Aceptar");
            } else
            {
                lblError.Text = "Introduzca los datos correctamente por favor";
            }
        }
    }
}