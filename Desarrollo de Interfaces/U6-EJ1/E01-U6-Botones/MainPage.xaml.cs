using static System.Net.Mime.MediaTypeNames;
using System.Xml.Linq;

namespace E01_U6_Botones
{
    public partial class MainPage : ContentPage
    {
        bool btnExiste = false;

        public MainPage()
        {
            InitializeComponent();
        }
        /// <summary>
        /// Función que crea un tercer botón cuando se pulsa el btn2
        /// Además, cambia el valor del booleano que indica si el botón ya se ha creado o no
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn2_Clicked(object sender, EventArgs e)
        {
            //Si no está creado
            if (!btnExiste)
            {
                Button btn3 = new Button()
                {
                    Text = "Boton3",
                    HorizontalOptions = LayoutOptions.Center,
                    BackgroundColor = Colors.Blue,
                    FontFamily = "Verdana",
                    FontSize = 16,
                    FontAttributes = FontAttributes.Bold,
                    BorderColor = Colors.Yellow,
                    BorderWidth = 4,
                    Margin = 30,
                };

                //ahora sí existe
                btnExiste = true;
                mainLayout.Children.Add(btn3); //Mostramos el botón en la pantalla
                btn3.Clicked += new EventHandler(btn3_Clicked); //Creamos un nuevo evento para cuando sea clicado
            }
        }

        /// <summary>
        /// Función que se activa cuando se hace clic en el btn3
        /// Elimina el btn1 de la pantalla y cambia el texto del btn2
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn3_Clicked(object sender, EventArgs e)
        {
            mainLayout.Children.Remove(btn1);
            btn2.Text = "Crear controles en tiempo de ejecución mola";
        }
    }
}