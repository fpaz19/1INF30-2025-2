<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="RegistrarEmpleado.aspx.cs" Inherits="SoftProgWA.RegistrarEmpleado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Registrar Empleado
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    <script src="Scripts/SoftProg/registrarEmpleado.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>
                </h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblDNI" runat="server" CssClass="col-sm-2 col-form-label" Text="DNI:"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtDNIEmpleado" runat="server" CssClass="form-control" MaxLength="8" onkeypress="soloNumeros(event)"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label CssClass="col-sm-2 form-label" ID="lblNombre" runat="server" Text="Nombre:"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox CssClass="form-control" ID="txtNombre" runat="server"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblApellidoPaterno" runat="server" Text="Apellido Paterno: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtApellidoPaterno" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblArea" CssClass="col-sm-2 form-label" runat="server" Text="Area:"></asp:Label>
                    <div class="col-sm-8">
                        <asp:DropDownList ID="ddlAreas" CssClass="form-select" runat="server"></asp:DropDownList>
                    </div>
                </div>
                <div class="mb-3 row">
                    <div class="col-sm-2">
                        <asp:Label ID="lblSexo" runat="server" Text="Sexo: " CssClass="col-form-label"></asp:Label>
                    </div>
                    <div class="col-sm-8">
                        <div class="form-check form-check-inline">
                            <input type="radio" runat="server" id="rbMasculino" class="form-check-input" />
                            <label class="form-check-label" runat="server" for="cphContenido_rbMasculino">Masculino</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="radio" runat="server" id="rbFemenino" class="form-check-input" />
                            <label class="form-check-label" runat="server" for="cphContenido_rbFemenino">Femenino</label>
                        </div>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label runat="server" Text="Fecha Nacimiento: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <input id="dtpFechaNacimiento" class="form-control" type="date" runat="server" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblCargo" runat="server" Text="Cargo: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtCargo" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblSueldo" runat="server" Text="Sueldo: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtSueldo" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:LinkButton ID="btnRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left pe-2'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
                <asp:LinkButton ID="btnGuardar" CssClass="float-end btn btn-primary" runat="server" Text="<i class='fa-solid fa-floppy-disk pe-2'></i> Guardar" OnClick="btnGuardar_Click"/>
            </div>
        </div>
    </div>
    <div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-danger text-white">
                    <h5 class="modal-title" id="errorModalLabel">
                        <i class="bi bi-exclamation-triangle-fill me-2"></i>Mensaje de Error
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblMensajeError" runat="server" Text="Mensaje de ejemplo..." CssClass="form-text text-danger"></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>