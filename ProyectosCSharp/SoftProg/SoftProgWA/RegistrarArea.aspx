<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RegistrarArea.aspx.cs" Inherits="SoftProgWA.RegistrarArea" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Pagina de Registro de Area</title>
</head>
<body>
    <h1>Registrar Area</h1>
    <form id="formRegArea" runat="server">
        
        <asp:Label runat="server">Nombre:</asp:Label>
        <asp:TextBox id="txtNombre"
            runat="server"></asp:TextBox>

        <asp:Button runat="server" 
            Text="Guardar" OnClick="Unnamed2_Click">
        
        </asp:Button>
    </form>
</body>
</html>
