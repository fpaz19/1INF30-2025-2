<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="RegistrarOrdenVenta.aspx.cs" Inherits="SoftProgWA.RegistrarOrdenVenta" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Gestion Orden Venta
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    <script src="Scripts/SoftProg/registrarOrdenVenta.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server" />
    <asp:UpdatePanel ID="upContenedor" runat="server" UpdateMode="Conditional">
        <ContentTemplate>
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <h2>Registrar Orden Venta</h2>
                    </div>
                    <div class="card-body">
                        <div class="card border">
                            <div class="card-header bg-light">
                                <h5 class="card-title mb-0">Informacion del Cliente</h5>
                            </div>
                            <div class="card-body">
                                <div class="mb-3 row">
                                    <asp:Label ID="lblDNICliente" runat="server" Text="DNI del Cliente:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-3">
                                        <asp:TextBox ID="txtDNICliente" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                                    </div>
                                    <asp:LinkButton ID="lbBuscarCliente" runat="server" Text="<i class='fa-solid fa-magnifying-glass'></i>" CssClass="btn btn-primary col-sm-auto" OnClick="lbBuscarCliente_Click"/>
                                </div>
                                <div class="mb-3 row">
                                    <asp:Label ID="lblNombreCliente" runat="server" Text="Nombre del Cliente:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-5">
                                        <asp:TextBox ID="txtNombreCliente" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card border">
                            <div class="card-header">
                                <h5 class="card-title mb-0">Detalle de la Orden de Venta</h5>
                            </div>
                            <div class="card-body">
                                <div class="mb-3 row">
                                    <asp:Label ID="lblIDProducto" runat="server" Text="ID del Producto:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-3">
                                        <asp:TextBox ID="txtIDProducto" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                                    </div>
                                    <asp:LinkButton ID="lbBuscarProducto" runat="server" CssClass="btn btn-primary col-sm-auto" Text="<i class='fa-solid fa-magnifying-glass'></i>" OnClick="lbBuscarProducto_Click"/>
                                </div>
                                <div class="mb-3 row">
                                    <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-5">
                                        <asp:TextBox ID="txtNombreProducto" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <asp:Label ID="lblPrecioUnitProducto" runat="server" Text="Precio Unitario:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-3">
                                        <asp:TextBox ID="txtPrecioUnitProducto" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <asp:Label ID="lblCantidadUnidades" runat="server" Text="Cantidad:" CssClass="col-sm-2 col-form-label"></asp:Label>
                                    <div class="col-sm-3">
                                        <asp:TextBox ID="txtCantidadUnidades" runat="server" CssClass="form-control"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:LinkButton ID="lbAgregarLOV" runat="server" Text="Agregar" CssClass="btn btn-success" OnClick="lbAgregarLOV_Click"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <asp:GridView ID="gvLineasOrdenVenta" runat="server"
                                        AllowPaging="true" PageSize="5" AutoGenerateColumns="false"
                                        CssClass="table table-hover table-responsive table-striped"
                                        OnRowDataBound="gvLineasOrdenVenta_RowDataBound" >
                                        <Columns>
                                            <asp:BoundField HeaderText="Nombre del Producto" />
                                            <asp:BoundField HeaderText="Precio Unit." />
                                            <asp:BoundField HeaderText="Cant" />
                                            <asp:BoundField HeaderText="Subtotal" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="lbBorrarLOV" runat="server" Text="<i class='fa-solid fa-trash'></i>" OnClick="lbBorrarLOV_Click" CommandArgument='<%# Eval("Producto.IdProducto")%>'/>
                                                </ItemTemplate>
                                            </asp:TemplateField>
                                        </Columns>
                                    </asp:GridView>
                                </div>
                                <div class="row align-items-center justify-content-end">
                                    <asp:Label ID="lblTotal" runat="server" Text="TOTAL:" CssClass="col-form-label col-sm-2 text-end"></asp:Label>
                                    <div class="col-sm-2">
                                        <asp:TextBox ID="txtTotal" runat="server" Enabled="false" CssClass="form-control col-sm-2"></asp:TextBox>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="card-footer clearfix">
                        <asp:LinkButton ID="lbRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnGuardar_Click"/>
                        <asp:LinkButton ID="lbGuardar" runat="server" Text="Guardar" CssClass="float-end btn btn-primary"  />
                    </div>
                </div>
            </div>
            <div class="modal" id="form-modal-cliente">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Busqueda de Cliente
                            </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <asp:UpdatePanel ID="upBusqCliente" runat="server" UpdateMode="Conditional">
                                <ContentTemplate>
                                    <div class="container row pb-3 pt-3">
                                        <div class="row align-items-center">
                                            <div class="col-auto">
                                                <asp:Label ID="lblDNINombreClienteModal" runat="server" Text="Ingresar DNI o nombre:"></asp:Label>
                                            </div>
                                            <div class="col-sm-3">
                                                <asp:TextBox ID="txtDNINombreClienteModal" runat="server" CssClass="form-control"></asp:TextBox>
                                            </div>
                                            <div class="col-sm-2">
                                                <asp:LinkButton ID="lbBusquedaClienteModal" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="lbBusquedaClienteModal_Click" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="container row">
                                        <asp:GridView ID="gvClientes" runat="server" PageSize="5"
                                            AllowPaging="true" AutoGenerateColumns="false"
                                            CssClass="table table-hover table-responsive table-striped"
                                            OnRowDataBound="gvClientes_RowDataBound">
                                            <Columns>
                                                <asp:BoundField HeaderText="DNI" />
                                                <asp:BoundField HeaderText="Nombre Completo" />
                                                <asp:TemplateField>
                                                    <ItemTemplate>
                                                        <asp:LinkButton ID="lbSeleccionarCliente" runat="server" Text="Seleccionar" CssClass="btn-success" OnClick="lbSeleccionarCliente_Click" CommandArgument='<%# Eval("IdPersona")%>' />
                                                    </ItemTemplate>
                                                </asp:TemplateField>
                                            </Columns>
                                        </asp:GridView>
                                    </div>
                                </ContentTemplate>
                            </asp:UpdatePanel>
                        </div>
                        <div class="modal-footer"></div>
                    </div>
                </div>
            </div>
            <div class="modal" id="form-modal-producto">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Busqueda de Producto
                            </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <asp:UpdatePanel ID="upBusqProducto" runat="server" UpdateMode="Conditional">
                                <ContentTemplate>
                                    <div class="container row pb-3 pt-3">
                                        <div class="col-auto">
                                            <asp:Label ID="lblNombreProductoModal" runat="server" Text="Ingrese el nombre del producto:" CssClass="form-label"></asp:Label>
                                        </div>
                                        <div class="col-sm-3">
                                            <asp:TextBox ID="txtNombreProductoModal" runat="server" CssClass="form-control"></asp:TextBox>
                                        </div>
                                        <div class="col-sm-2">
                                            <asp:LinkButton ID="lbBusquedaProductoModal" runat="server" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" CssClass="btn btn-info" OnClick="lbBusquedaProductoModal_Click" />
                                        </div>
                                    </div>
                                    <div class="container row">
                                        <asp:GridView ID="gvProductos" runat="server" PageSize="5"
                                            AllowPaging="true" CssClass="table table-hover table-responsive table-striped"
                                            AutoGenerateColumns="false" OnRowDataBound="gvProductos_RowDataBound">
                                            <Columns>
                                                <asp:BoundField HeaderText="Nombre del producto" />
                                                <asp:BoundField HeaderText="Precio" />
                                                <asp:TemplateField>
                                                    <ItemTemplate>
                                                        <asp:LinkButton ID="lbSeleccionarProducto" runat="server" Text="Seleccionar" CssClass="btn-success" OnClick="lbSeleccionarProducto_Click" CommandArgument='<%# Eval("IdProducto")%>' />
                                                    </ItemTemplate>
                                                </asp:TemplateField>
                                            </Columns>
                                        </asp:GridView>
                                    </div>
                                </ContentTemplate>
                            </asp:UpdatePanel>
                        </div>
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
        </ContentTemplate>
    </asp:UpdatePanel>
</asp:Content>
