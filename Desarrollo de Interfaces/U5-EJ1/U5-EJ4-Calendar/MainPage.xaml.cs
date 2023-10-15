namespace U5_EJ4_Calendar
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Método que se acciona cuando elegimos una fecha en uno de los calendarios.
        /// Se calcula la diferencia de días entre ambos calendarios y se imprime un total de los días reservados
        /// Si no existen días entre una fecha y otra, se muestra mensaje de error
        /// Precondiciones: Se debe elegir una fecha en alguno de los calendarios
        /// Postcondiciones: Ninguna
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void DateSelected(object sender, DateChangedEventArgs e)
        {
            TimeSpan timeSpan = EndDate.Date - StartDate.Date;
            if (timeSpan.Days == 0)
            {
                lblDays.Text = "No puedes reservar para quedarte 0 días cabezón";
            }
            else
            {
                lblDays.Text = $"Total day/s --> {timeSpan.Days}";
            }
        }
    }
}