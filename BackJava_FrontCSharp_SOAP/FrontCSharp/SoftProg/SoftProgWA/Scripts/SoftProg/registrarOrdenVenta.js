let modalFormCliente;
let modalFormProducto;
let modalFormError;

function mostrarModalCliente() {
    modalFormCliente = new bootstrap.Modal(document.getElementById('form-modal-cliente'));
    modalFormCliente.show();
}

function cerrarModalCliente() {
    modalFormCliente.hide();
} 

function mostrarModalProducto() {
    modalFormProducto = new bootstrap.Modal(document.getElementById('form-modal-producto'));
    modalFormProducto.show();
}

function cerrarModalProducto() {
    modalFormProducto.hide();
}

function mostrarModalFormError() {
    modalFormError = new bootstrap.Modal(document.getElementById('errorModal'));
    modalFormError.show();
}