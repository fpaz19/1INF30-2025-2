<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="ListarAreas.aspx.cs" Inherits="SoftProgWA.ListarAreas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Listar Areas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="container">
        <div class="container row">
            <div class="row align-items-center">
                <div class="col text-end">
                    <asp:LinkButton ID="lkRegistrar" runat="server" CssClass="btn btn-success" OnClick="lkRegistrar_Click">Registrar</asp:LinkButton>
                </div>
            </div>
        </div>
        <div class="container row">
            <asp:GridView ID="gvAreas" runat="server" AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id. Area" DataField="IdArea"/>
                    <asp:BoundField HeaderText="Nombre del Area" DataField="Nombre"/>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-pencil pe-4'></i>" OnClick="lkModificar_Click" CommandArgument='<%# Eval("IdArea")%>'/>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash'></i>" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
