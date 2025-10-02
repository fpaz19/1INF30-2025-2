<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="RegistrarArea.aspx.cs" Inherits="SoftProgWA.RegistrarArea" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Registrar Area
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="card">
        <div class="card-header">
            <h2>
                <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>
            </h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row align-items-center">
                <asp:Label ID="lblIDArea" runat="server" CssClass="col-form-label" Text="Id. del Area:"></asp:Label>
                <div class="col-2">
                    <asp:TextBox ID="txtIDArea" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row align-items-center">
                <asp:Label ID="lblNombre" runat="server" CssClass="col-form-label" Text="Nombre:"></asp:Label>
                <div class="col-6">
                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:LinkButton ID="lbGuardar" CssClass="float-end btn btn-secondary" runat="server" Text="<i class='fa-solid fa-floppy-disk'></i> Guardar" OnClick="lbGuardar_Click" />
        </div>
    </div>
</asp:Content>
