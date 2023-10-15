<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="HelloWorld.WebForm._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <main>
        <section class="row" aria-labelledby="aspnetTitle">
            <h1 id="aspnetTitle">Saludos</h1>
            <p><asp:Label ID="Label1" runat="server" Text="Usuario, introduzca su nombre: "></asp:Label>
                <asp:TextBox ID="txtNombre" runat="server"></asp:TextBox>
                <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
            </p>
            <asp:Button ID="btnSaludar" runat="server" OnClick="Button1_Click" Text="Button" Width ="80px"/>
            <br />
            <asp:Label ID="lblSaludo" runat="server"></asp:Label>
        </section>
    </main>

</asp:Content>
