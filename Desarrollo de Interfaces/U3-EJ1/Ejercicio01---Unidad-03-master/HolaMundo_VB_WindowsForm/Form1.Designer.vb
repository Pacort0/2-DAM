<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        btnSaludar = New Button()
        textoEntrada = New TextBox()
        SuspendLayout()
        ' 
        ' btnSaludar
        ' 
        btnSaludar.Location = New Point(155, 129)
        btnSaludar.Margin = New Padding(3, 2, 3, 2)
        btnSaludar.Name = "btnSaludar"
        btnSaludar.Size = New Size(52, 20)
        btnSaludar.TabIndex = 0
        btnSaludar.Text = "Saludo"
        btnSaludar.UseVisualStyleBackColor = True
        ' 
        ' textoEntrada
        ' 
        textoEntrada.Location = New Point(132, 100)
        textoEntrada.Margin = New Padding(3, 2, 3, 2)
        textoEntrada.Name = "textoEntrada"
        textoEntrada.Size = New Size(101, 23)
        textoEntrada.TabIndex = 1
        ' 
        ' Form1
        ' 
        AutoScaleDimensions = New SizeF(7F, 15F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(988, 542)
        Controls.Add(textoEntrada)
        Controls.Add(btnSaludar)
        Cursor = Cursors.No
        Font = New Font("Segoe UI", 9F, FontStyle.Regular, GraphicsUnit.Point)
        Margin = New Padding(3, 2, 3, 2)
        Name = "Form1"
        Text = "Form1"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents btnSaludar As Button
    Friend WithEvents textoEntrada As TextBox
End Class
