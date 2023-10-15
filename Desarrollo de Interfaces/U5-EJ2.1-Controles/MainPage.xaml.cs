namespace U5_EJ2._1_Controles
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
        /// Precondiciones: Se debe elegir una fecha en alguno de los calendarios
        /// Postcondiciones: Ninguna
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void DateSelected(object sender, DateChangedEventArgs e)
        {
            TimeSpan timeSpan = EndDate.Date - StartDate.Date;
            lblDays.Text = $"Total day/s --> {timeSpan.Days}";
        }
    }
}