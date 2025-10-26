let modalFormError;
function soloNumeros(e) {
    var key = e.key;

    // Permitir control: borrar, tab, flechas
    if (["Backspace", "Delete", "ArrowLeft", "ArrowRight", "Tab"].indexOf(key) !== -1) {
        return;
    }

    // Solo números (0-9)
    if (!/^[0-9]$/.test(key)) {
        e.preventDefault();
    }
}

function mostrarModalError() {
    modalFormError = new bootstrap.Modal(document.getElementById('errorModal'));
    modalFormError.show();
}