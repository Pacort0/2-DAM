using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace HolaMundoWPF_C_
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string name = string.Empty;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnSaludo_Click(object sender, RoutedEventArgs e)
        {
            if (nombreText.Text.Length == 0)
            {
                textoError.Text = "Introduzca su nombre correctamente";
            }
            else
            {
                name = nombreText.Text;
                MessageBox.Show($"Hola, {name}");
            }
        }

        private void nombreText_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
}
