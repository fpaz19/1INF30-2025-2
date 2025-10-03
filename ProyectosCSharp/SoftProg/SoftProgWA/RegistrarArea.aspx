<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="RegistrarArea.aspx.cs" Inherits="SoftProgWA.RegistrarArea" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Registrar Area
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    <script src="Scripts/SoftProg/registrarArea.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="card">
        <div class="card-header">
            <h2>
                <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>
            </h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIDArea" runat="server" CssClass="col-sm-2 col-form-label" Text="Id. del Area:"></asp:Label>
                <div class="col-2">
                    <asp:TextBox ID="txtIDArea" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNombre" runat="server" CssClass="col-sm-2 col-form-label" Text="Nombre:"></asp:Label>
                <div class="col-6">
                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left pe-2'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
            <asp:LinkButton ID="lbGuardar" CssClass="float-end btn btn-primary" runat="server" Text="<i class='fa-solid fa-floppy-disk pe-2'></i> Guardar" OnClick="lbGuardar_Click" />
        </div>
    </div>
    <div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-danger text-white">
                    <h5 class="modal-title" id="errorModalLabel">
                        <i class="fa-solid fa-triangle-exclamation me-2"></i>Mensaje de Error
                    </h5>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblMensajeError" runat="server" Text="Label" CssClass="form-text text-danger"></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
