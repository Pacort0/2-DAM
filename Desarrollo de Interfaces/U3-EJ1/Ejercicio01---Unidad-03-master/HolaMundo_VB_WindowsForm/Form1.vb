Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles btnSaludar.Click
        MessageBox.Show($"Hola {textoEntrada.Text}")
    End Sub

    Private Sub TextoEntrada_TextChanged(sender As Object, e As EventArgs) Handles textoEntrada.TextChanged

    End Sub
End Class
